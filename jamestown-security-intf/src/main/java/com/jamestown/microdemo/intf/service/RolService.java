package com.jamestown.microdemo.intf.service;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import org.springframework.http.ResponseEntity;

/**
 * Descripcion del endpoint expuesto por este micro-servicio.
 */
public interface RolService {

    ResponseEntity createRol(Rol rol);

    ResponseEntity deleteRol(String id);

}
