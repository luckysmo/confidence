package ru.practicum.confidence.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserUpdateDto {
    Long id;

    String name;
    @Email
    String email;
}
