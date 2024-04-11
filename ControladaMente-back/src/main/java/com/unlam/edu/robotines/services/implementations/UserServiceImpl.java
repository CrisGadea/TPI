package com.unlam.edu.robotines.services.implementations;

import com.unlam.edu.robotines.mappers.UserMapper;
import com.unlam.edu.robotines.models.dtos.UserDto;
import com.unlam.edu.robotines.repositories.IUserRepository;
import com.unlam.edu.robotines.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;

    public UserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }

    public List<UserDto> getUsers() {
        return this.repository.findAll().stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
}
