package com.example.ums.service;

import com.example.ums.dto.request.InstructorDetailRequestDTO;
import com.example.ums.dto.request.InstructorRequestDTO;
import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.InstructorDetail;

import java.util.List;

public interface InstructorDetailService {
    List<InstructorDetailResponseDTO> getAllInstructorDetail();
    InstructorDetailResponseDTO getInstructorDetailById(Long id);
    InstructorDetail createInstructorDetail(InstructorDetailRequestDTO instructorDetailRequestDTO);
    InstructorDetail updateInstructorDetail(Long id, InstructorDetailRequestDTO instructorDetailRequestDTO);
    String deleteInstructorDetail(Long id);
//    InstructorDetailResponseDTO getInstructorByInstructorDetailId(Long id);
}
