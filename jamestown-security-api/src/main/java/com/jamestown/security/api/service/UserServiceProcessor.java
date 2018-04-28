package com.jamestown.security.api.service;


import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.model.exception.ApiException;

import java.util.List;

/**
 * Servicio que permite manipular el repositorio de datos para la entidad {@link User}.
 */
public interface UserServiceProcessor {

    User createUser(User user) throws ApiException;

    User updateUser(User user) throws ApiException;

    User getUser(String id) throws ApiException;

    List<User> getUsers() throws ApiException;

    User addRolToUser(String id, Rol rol) throws ApiException;

}
