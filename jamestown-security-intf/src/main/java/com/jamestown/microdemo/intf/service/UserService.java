package com.jamestown.microdemo.intf.service;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Descripcion del endpoint expuesto por este micro-servicio.
 */
public interface UserService {

    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> updateUser(User user);

    ResponseEntity<User> getUser(String id);

    ResponseEntity<User> getUsers();

    ResponseEntity<User> addRolToUser(String id, Rol rol);

}
