package com.example.ums.dto.response;

import com.example.ums.model.Instructor;
import com.example.ums.model.InstructorDetail;

public interface InstructorResponseDTO {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhone();

    InstructorDetailResponseDTO getInstructorDetail();
}

