package com.jamestown.security.api.controller;

import com.jamestown.microdemo.intf.service.RolService;
import com.jamestown.microdemo.intf.service.UserService;
import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.model.exception.ApiException;
import com.jamestown.security.api.service.RolServiceProcessor;
import com.jamestown.security.api.service.UserServiceProcessor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/rol")
@RestController
public class RolController implements RolService {

    @Autowired
    private RolServiceProcessor rolService;

    @PostMapping
    @Override
    public ResponseEntity createRol(@RequestBody Rol rol) {
        try {
            return ResponseEntity.ok(rolService.createRol(rol));
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteRol(@PathVariable String id) {
        try {
            Rol rol = new Rol();
            rol.setId(id);
            if (rolService.deleteRol(rol)) {
                return ResponseEntity.ok("Rol eliminado correctamente");
            }
            return ResponseEntity.status(HttpStatus.SC_BAD_GATEWAY).body("Error al eliminar el rol");
        } catch (ApiException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

}
