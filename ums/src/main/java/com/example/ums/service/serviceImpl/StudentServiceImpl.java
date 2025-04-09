package com.example.ums.service.serviceImpl;

import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.model.Student;
import com.example.ums.repository.StudentRepository;
import com.example.ums.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAllProjectedBy();
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        StudentResponseDTO studentResponseDTO = studentRepository.findById(id);
        return studentResponseDTO;
    }

    @Override
    public void addStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setFirstName(studentRequestDTO.firstName());
        student.setLastName(studentRequestDTO.lastName());
        student.setEmail(studentRequestDTO.email());
        student.setPassword(studentRequestDTO.password());
        student.setPhone(studentRequestDTO.phone());
        student.setAddress(studentRequestDTO.address());
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException(
                        "Student not found with id: " + id));
        student.setFirstName(studentRequestDTO.firstName());
        student.setLastName(studentRequestDTO.lastName());
        student.setEmail(studentRequestDTO.email());
        student.setPassword(studentRequestDTO.password());
        student.setAddress(studentRequestDTO.address());

        studentRepository.save(student);
    }


    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(Math.toIntExact(id))){
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(Math.toIntExact(id));
    }
}

