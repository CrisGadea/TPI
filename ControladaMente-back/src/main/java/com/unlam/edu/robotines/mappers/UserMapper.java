package com.unlam.edu.robotines.mappers;

import com.unlam.edu.robotines.models.dtos.UserDto;
import com.unlam.edu.robotines.models.entities.User;

import java.time.LocalDateTime;

public class UserMapper {

    public static UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User entity = new User();
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return entity;
    }
}
