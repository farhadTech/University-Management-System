package com.example.ums.dto.request;

public record StudentRequestDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        String address;
) implements Serializable{}
