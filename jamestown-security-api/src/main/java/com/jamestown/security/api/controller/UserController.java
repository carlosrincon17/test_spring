package com.jamestown.security.api.controller;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.model.exception.ApiException;
import com.jamestown.security.api.service.UserServiceProcessor;
import com.jamestown.microdemo.intf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/user")
@RestController
public class UserController implements UserService {

    @Autowired
    private UserServiceProcessor userService;

    @PostMapping
    @Override
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @PutMapping
    @Override
    public ResponseEntity updateUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity getUser(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @GetMapping
    @Override
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(userService.getUsers());
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/add-roles/")
    @Override
    public ResponseEntity addRolToUser(@PathVariable String id, @RequestBody Rol rol) {
        try {
            return ResponseEntity.ok(userService.addRolToUser(id, rol));
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

}
