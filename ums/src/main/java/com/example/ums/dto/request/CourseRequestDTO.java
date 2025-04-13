package com.example.ums.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CourseRequestDTO(
        @NotBlank(message = "Enter title of the course: ")
        String title,
        @NotBlank(message = "Enter department name of the course: ")
        String departmentName,
        @NotBlank(message = "Enter credits fo the course: ")
        int credits
) implements Serializable {}
