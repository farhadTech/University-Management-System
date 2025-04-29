package com.example.ums.dto.response;

import java.util.List;

public interface InstructorCustomResponseDTO {
    Long getId();
    String getFullName();
    String getUsername();
    String getEmail();

    List<InstructorDetailInfo> getInstructorDetail();

    interface InstructorDetailInfo {
        Long getId();
        String getBio();
        String getYoutubeChannel();
        String getHobby();
    }
}
