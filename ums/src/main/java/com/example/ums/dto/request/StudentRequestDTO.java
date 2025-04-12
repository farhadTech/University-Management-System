package com.example.ums.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

// send data from client to server
public record StudentRequestDTO(
        @NotBlank(message = "Enter first name: ")
        String firstName,

        @NotBlank(message = "Enter last name: ")
        String lastName,

        @Email(message = "Enter a valid email")
        String email,

        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}$",
                message = "Password must include at least one uppercase letter, one number, and one special character"
        )
        @NotBlank(message = "Enter password: ")
        String password,

        @Pattern(regexp = "^(\\+8801|01)[0-9]{9}$", message = "Enter a valid Bangladeshi phone number")
        @NotBlank(message = "Enter phone number: ")
        String phone,

        @NotBlank(message = "Enter address: ")
        String address
) implements Serializable {}

