package com.unlam.edu.robotines.services;

import com.unlam.edu.robotines.models.dtos.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> getUsers();

    UserDto getUser(Long id);

    UserDto register(UserDto user);

    Boolean login(UserDto user);

    UserDto logout(UserDto user);

    UserDto updateUser(Long id, UserDto user);

    UserDto deleteUser(Long id);
}
