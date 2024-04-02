package ru.practicum.confidence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.confidence.dto.UserDto;
import ru.practicum.confidence.exception.NotFoundException;
import ru.practicum.confidence.exception.UserDuplicateEmailException;
import ru.practicum.confidence.mapper.UserMapperDto;
import ru.practicum.confidence.model.User;
import ru.practicum.confidence.repository.UserRepository;
import ru.practicum.confidence.service.UserService;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapperDto userMapperDto;

    @Override
    public UserDto create(UserDto userDto) {
        checkDuplicatesEmail(userDto);
        User user = userRepository.save(userMapperDto.toDto(userDto));
        userDto.getBasket().setId(userDto.getId());
        return userMapperDto.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new NotFoundException("Пользователя с таким Id не существует"));
        checkDuplicatesEmail(userDto);
        userMapperDto.updateUserDto(userDto, user);
        User updated = userRepository.save(user);
        return userMapperDto.toUserDto(updated);
    }

    @Override
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new NotFoundException("Пользователя с таким Id не существует");
        }
    }

    @Override
    public UserDto getById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователя с таким Id не существует"));
        return userMapperDto.toUserDto(user);
    }

    private void checkDuplicatesEmail(UserDto userDto) {
        List<User> emailExist = userRepository.findAll().stream()
                .filter(user -> user.getEmail().equals(userDto.getEmail()))
                .toList();
        if (!isEmpty(emailExist)) {
            User user = emailExist.get(0);
            if (userDto.getEmail().equals(user.getEmail())) {
                return;
            }
            throw new UserDuplicateEmailException("Такой email уже зарегистрирован");
        }
    }
}
