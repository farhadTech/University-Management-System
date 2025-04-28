package com.example.ums.service.serviceImpl;

import com.example.ums.common.exception.IDNotFoundException;
import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.model.Student;
import com.example.ums.repository.CourseRepository;
import com.example.ums.repository.StudentRepository;
import com.example.ums.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        StudentResponseDTO studentResponseDTO = studentRepository.findStudentById(id);
        if(studentResponseDTO == null) {
            throw new IDNotFoundException("Student not found with id: " + id);
        }
        return studentResponseDTO;
    }

    @Override
    public Student createStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setFullName(studentRequestDTO.fullName());
        student.setUsername(studentRequestDTO.username());
        student.setEmail(studentRequestDTO.email());

        Set<Course> courses = new LinkedHashSet<>();
        for(Long courseId : studentRequestDTO.courseIds()) {
            Course course = courseRepository.getCourseById(courseId);
            if(course == null) {
                throw new IDNotFoundException("Course not found with id: " + courseId);
            }
            courses.add(course);
        }
        student.setCourses(courses);

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.getStudentById(id);
        if(student == null) {
            throw new IDNotFoundException("Student not found with id: " + id);
        }
        student.setFullName(studentRequestDTO.fullName());
        student.setUsername(studentRequestDTO.username());
        student.setEmail(studentRequestDTO.email());

        Set<Course> courses = new LinkedHashSet<>();
        for(Long courseId : studentRequestDTO.courseIds()) {
            Course course = courseRepository.getCourseById(courseId);
            if(course == null) {
                throw new IDNotFoundException("Course not found with id: " + courseId);
            }
            courses.add(course);
        }
        student.setCourses(courses);

        return studentRepository.save(student);
    }


    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById((id));
        return "Student deleted";
    }
}

