package com.example.ums.service;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;

import java.util.List;

public interface InstructorDetailService {
    List<InstructorDetailResponseDTO> getAllInstructorDetail();
    InstructorDetailResponseDTO getInstructorDetailById(Long id);
    void addInstructorDetail(InstructorDetailRequestDTO instructorDetailRequestDTO);
    void updateInstructorDetail(Long id, InstructorDetailRequestDTO instructorDetailRequestDTO);
    void deleteInstructorDetail(Long id);
    InstructorResponseDTO getInstructorByInstructorDetailId(Long id);
}
