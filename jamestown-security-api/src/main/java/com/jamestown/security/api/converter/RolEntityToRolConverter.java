package com.jamestown.security.api.converter;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.security.api.entities.RolEntity;
import com.jamestown.security.api.entities.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RolEntityToRolConverter implements Converter<RolEntity, Rol> {

    @Override
    public Rol convert(RolEntity rolEntity) {
        Rol rol = new Rol();
        rol.setId(rolEntity.getId());
        rol.setName(rolEntity.getName());
        return rol;
    }
}
