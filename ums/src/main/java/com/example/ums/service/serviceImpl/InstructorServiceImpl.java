package com.example.ums.service.serviceImpl;

import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.model.Instructor;
import com.example.ums.repository.InstructorRepository;
import com.example.ums.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorRepository.findAllProjectedBy();
    }

    @Override
    public InstructorResponseDTO getInstructorById(Long id) {
        InstructorResponseDTO instructorResponseDTO = instructorRepository.findProjectedById(id);
        if (Objects.isNull(instructorResponseDTO)) {
            throw new RuntimeException("instructor with id " + id + " not found");
        }
        return instructorResponseDTO;
    }


    @Override
    public void addInstructor(InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequestDTO.firstName());
        instructor.setLastName(instructorRequestDTO.lastName());
        instructor.setEmail(instructorRequestDTO.email());
        instructor.setPassword(instructorRequestDTO.password());
        instructor.setPhone(instructorRequestDTO.phone());
        instructorRepository.save(instructor);
    }

    @Override
    public void updateInstructor(Long id, InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = instructorRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));

        instructor.setFirstName(instructorRequestDTO.firstName());
        instructor.setLastName(instructorRequestDTO.lastName());
        instructor.setEmail(instructorRequestDTO.email());

        instructor.setPassword(instructorRequestDTO.password());

        instructor.setPhone(instructorRequestDTO.phone());

        instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public InstructorDetailResponseDTO getInstructorDetailByInstructorId(Long id){
        return instructorRepository.findInstructorDetailByInstructorId(id)
                .orElseThrow(() -> new RuntimeException("Instructor detail not found with id: " + id));
    }
}







