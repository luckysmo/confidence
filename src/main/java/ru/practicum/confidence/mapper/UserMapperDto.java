package ru.practicum.confidence.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.confidence.dto.UserDto;
import ru.practicum.confidence.model.User;

@Mapper(componentModel = "spring")
public interface UserMapperDto {
    User toDto(UserDto userDto);

    UserDto toUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserDto(UserDto dto, @MappingTarget User user);
}
