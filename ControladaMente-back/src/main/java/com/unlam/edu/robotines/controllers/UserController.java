package com.unlam.edu.robotines.controllers;

import com.unlam.edu.robotines.models.dtos.UserDto;
import com.unlam.edu.robotines.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.PATCH, RequestMethod.DELETE})
public class UserController {

    @Autowired
    public IUserService service;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(this.service.getUsers());
    }

}
