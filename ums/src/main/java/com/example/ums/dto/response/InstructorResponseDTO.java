package com.example.ums.dto.response;

import com.example.ums.model.Instructor;

public interface InstructorResponseDTO {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhone();
    Instructor getInstructor();
}
