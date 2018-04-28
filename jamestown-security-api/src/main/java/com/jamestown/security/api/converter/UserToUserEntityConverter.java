package com.jamestown.security.api.converter;

import com.jamestown.model.dto.User;
import com.jamestown.security.api.entities.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityConverter implements Converter<User, UserEntity> {

    @Override
    public UserEntity convert(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(user.getCreatedAt());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setId(user.getId());
        return userEntity;
    }
}
