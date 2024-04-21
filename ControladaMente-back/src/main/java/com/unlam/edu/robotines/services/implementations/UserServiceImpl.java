package com.unlam.edu.robotines.services.implementations;

import com.unlam.edu.robotines.mappers.UserMapper;
import com.unlam.edu.robotines.models.dtos.UserDto;
import com.unlam.edu.robotines.models.entities.User;
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

    public UserDto getUser(Long id) {
        return UserMapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public UserDto register(UserDto user) {
        // register and validate email with auth service
        return null;
    }

    public Boolean login(UserDto user) {
        // login and validate email
        //User userFounded = this.repository.getByEmailAndPassword(user.getEmail(), user.getPassword());
        //return userFounded != null;
        return user.getEmail().equals("admin") && user.getPassword().equals("admin");
    }   

    public UserDto logout(UserDto user) {
        // logout and validate email with auth service
        return null;
    }

    public UserDto updateUser(Long id, UserDto user) {
        User userToUpdate = this.repository.findById(id).orElseThrow();
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        return UserMapper.toDto(this.repository.save(userToUpdate));
    }

    public UserDto deleteUser(Long id) {
        User userToDelete = this.repository.findById(id).orElseThrow();
        this.repository.delete(userToDelete);
        return UserMapper.toDto(userToDelete);
    }
}
