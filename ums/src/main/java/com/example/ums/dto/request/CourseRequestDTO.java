package com.example.ums.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

public record CourseRequestDTO(
        @NotBlank(message = "Enter title of the course: ")
        String title,
        @NotBlank(message = "Enter department name of the course: ")
        String departmentName,
        @NotNull(message = "Enter credits fo the course: ")
        int credits,

        Long instructorId,
        Set<Long> reviewIds,
        Set<Long> studentIds
) implements Serializable {}
