package com.jamestown.security.api.converter;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.security.api.entities.RolEntity;
import com.jamestown.security.api.entities.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RolToRolEntityConverter implements Converter<Rol, RolEntity> {

    @Override
    public RolEntity convert(Rol rol) {
        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(rol.getId());
        rolEntity.setName(rol.getName());
        return rolEntity;
    }
}
