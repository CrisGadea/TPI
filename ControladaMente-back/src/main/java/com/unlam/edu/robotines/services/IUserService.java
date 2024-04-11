package com.unlam.edu.robotines.services;

import com.unlam.edu.robotines.models.dtos.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> getUsers();
}
