package com.unlam.edu.robotines.services;

import com.unlam.edu.robotines.models.dtos.UserDto;
import com.unlam.edu.robotines.models.entities.User;
import com.unlam.edu.robotines.repositories.IUserRepository;
import com.unlam.edu.robotines.services.implementations.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    IUserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Should Return All Users")
    @Test
    public void getUsers() {
        User user1 = new User();
        User user2 = new User();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<UserDto> users = userService.getUsers();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    /*@DisplayName("Should Return User By Id")
    @Test
    public void getUser() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        UserDto userDto = userService.getUser(1L);

        assertEquals(user, userDto);
        verify(userRepository, times(1)).findById(anyLong());
    }

    @DisplayName("Should Return Null When User Not Found")
    @Test
    public void getUserNotFound() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        UserDto userDto = userService.getUser(1L);

        assertNull(userDto);
        verify(userRepository, times(1)).findById(anyLong());
    }*/

    @DisplayName("Should Return True When User Login")
    @Test
    public void userLogin() {
        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setEmail("test@test.com");
        userDto.setPassword("password");
        when(userRepository.getByEmailAndPassword(anyString(), anyString())).thenReturn(user);

        Boolean result = userService.login(userDto);

        assertTrue(result);
        verify(userRepository, times(1)).getByEmailAndPassword(anyString(), anyString());
    }

    // Add more tests for register, logout, updateUser, deleteUser
}