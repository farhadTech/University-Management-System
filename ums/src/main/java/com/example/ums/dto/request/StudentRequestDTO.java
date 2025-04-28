package com.example.ums.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Set;

public record StudentRequestDTO(
        @NotBlank(message = "Enter full name: ")
        String fullName,

        @NotBlank(message = "Enter username: ")
        String username,

        @Email(message = "Enter a valid email")
        String email,

        Set<Long> courseIds

) implements Serializable {}

