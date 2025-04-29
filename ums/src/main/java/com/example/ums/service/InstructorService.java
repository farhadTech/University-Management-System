package com.example.ums.service;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorCustomResponseDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Course;
import com.example.ums.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<InstructorResponseDTO> getAllInstructors();
    List<InstructorCustomResponseDTO> getAllInstructorsCustom();
    InstructorResponseDTO getInstructorById(Long id);
    Instructor createInstructor(InstructorRequestDTO instructorRequestDTO);
    Instructor updateInstructor(Long id, InstructorRequestDTO instructorRequestDTO);
    String deleteInstructorById(Long id);
//    InstructorResponseDTO getInstructorDetailByInstructorId(Long id);
}
