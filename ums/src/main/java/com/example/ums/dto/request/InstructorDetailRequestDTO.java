package com.example.ums.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record InstructorDetailRequestDTO(
        @NotBlank(message = "Enter youtube channel name: ")
        String youtubeChannel,

        String bio,

        String hobby

) implements Serializable {}
