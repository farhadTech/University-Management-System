package com.example.ums.service;

import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<InstructorResponseDTO> getAllInstructors();
    InstructorResponseDTO getInstructorById(Long id);
    void addInstructor(InstructorRequestDTO instructorRequestDTO);
    void updateInstructor(Long id, InstructorRequestDTO instructorRequestDTO);
    void deleteInstructorById(Long id);
}
