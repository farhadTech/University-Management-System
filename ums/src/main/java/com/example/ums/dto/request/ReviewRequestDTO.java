package com.example.ums.dto.request;

import java.io.Serializable;

public record ReviewRequestDTO(
        String comment,
        int rating
) implements Serializable {
}
