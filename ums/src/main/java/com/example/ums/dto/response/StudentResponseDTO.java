package com.example.ums.dto.response;

import com.example.ums.model.Student;

public interface StudentResponseDTO {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhone();
    String getAddress();

}
