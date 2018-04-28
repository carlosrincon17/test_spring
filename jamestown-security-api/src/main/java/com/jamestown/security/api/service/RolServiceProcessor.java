package com.jamestown.security.api.service;


import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.model.exception.ApiException;

import java.util.List;

/**
 * Servicio que permite manipular el repositorio de datos para la entidad {@link User}.
 */
public interface RolServiceProcessor {

    Rol createRol(Rol rol) throws ApiException;

    boolean deleteRol(Rol rol) throws ApiException;
}
