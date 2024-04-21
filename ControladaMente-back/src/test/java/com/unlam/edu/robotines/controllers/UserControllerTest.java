package com.unlam.edu.robotines.controllers;

import com.unlam.edu.robotines.models.dtos.UserDto;
import com.unlam.edu.robotines.services.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    IUserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Should Return All Users")
    @Test
    public void getUsers() {
        UserDto user1 = new UserDto();
        UserDto user2 = new UserDto();
        when(userService.getUsers()).thenReturn(Arrays.asList(user1, user2));

        ResponseEntity<List<UserDto>> response = userController.getUsers();

        assertEquals(2, response.getBody().size());
        verify(userService, times(1)).getUsers();
    }

    @DisplayName("Should Return User By Id")
    @Test
    public void getUser() {
        UserDto user = new UserDto();
        when(userService.getUser(anyLong())).thenReturn(user);

        ResponseEntity<UserDto> response = userController.getUser(1L);

        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUser(anyLong());
    }

    // Add more tests for register, login, logout, updateUser, deleteUser
}
