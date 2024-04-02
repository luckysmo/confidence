package ru.practicum.confidence.service;

import ru.practicum.confidence.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);

    UserDto getById(Long userId);
}
