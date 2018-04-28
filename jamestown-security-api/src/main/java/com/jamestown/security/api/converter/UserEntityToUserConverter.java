package com.jamestown.security.api.converter;

import com.google.common.collect.Lists;
import com.jamestown.model.dto.User;
import com.jamestown.security.api.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserEntityToUserConverter implements Converter<UserEntity, User> {

    @Autowired
    RolEntityToRolConverter rolEntityToRolConverter;

    @Override
    public User convert(UserEntity userEntity) {
        User user = new User();
        user.setCreatedAt(userEntity.getCreatedAt());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());
        user.setId(userEntity.getId());
        if (userEntity.getRoles() == null) {
            userEntity.setRoles(Lists.newArrayList());
        }
        user.setRoles(userEntity.getRoles().stream()
                .map(rolEntityToRolConverter::convert).collect(Collectors.toList()));
        return user;
    }
}
