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

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getUser(id));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto user) {
        return ResponseEntity.ok(this.service.register(user));
    }

    //login
    @PostMapping(value = "/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto user) {
        return ResponseEntity.ok(this.service.login(user));
    }

    // logout
    @PostMapping(value = "/logout")
    public ResponseEntity<UserDto> logout(@RequestBody UserDto user) {
        return ResponseEntity.ok(this.service.logout(user));
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.ok(this.service.updateUser(id, user));
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.deleteUser(id));
    }

}
