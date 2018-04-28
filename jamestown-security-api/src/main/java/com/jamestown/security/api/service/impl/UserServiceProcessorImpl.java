package com.jamestown.security.api.service.impl;

import com.google.common.collect.Lists;
import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.model.exception.ApiException;
import com.jamestown.security.api.converter.UserEntityToUserConverter;
import com.jamestown.security.api.converter.UserToUserEntityConverter;
import com.jamestown.security.api.dao.RolDao;
import com.jamestown.security.api.dao.UserDao;
import com.jamestown.security.api.entities.RolEntity;
import com.jamestown.security.api.entities.UserEntity;
import com.jamestown.security.api.service.UserServiceProcessor;
import com.jamestown.security.util.EncryptUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceProcessorImpl implements UserServiceProcessor {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RolDao rolDao;

    @Autowired
    private UserToUserEntityConverter userToUserEntityConverter;

    @Autowired
    private UserEntityToUserConverter userEntityToUserConverter;

    @Override
    public User createUser(User user) throws ApiException {
        user.setCreatedAt(new Date());
        user.setPassword(EncryptUtils.encodeSHA266(user.getPassword()));
        if (userDao.existsByUsernameOrEmail(user.getUsername(), user.getEmail())) {
            throw new ApiException("Ya existe un usuario con los datos ingresados.", HttpStatus.SC_BAD_REQUEST);
        }
        UserEntity userEntity = userToUserEntityConverter.convert(user);
        userEntity = userDao.save(userEntity);
        return userEntityToUserConverter.convert(userEntity);
    }

    @Override
    public User updateUser(User user) throws ApiException {
        UserEntity userEntity = userToUserEntityConverter.convert(user);
        userEntity = userDao.save(userEntity);
        return userEntityToUserConverter.convert(userEntity);
    }

    @Override
    public User getUser(String id) throws ApiException {
        UserEntity userEntity = userDao.findOne(id);
        if(userEntity == null ){
            throw new ApiException("Ya existe un usuario con los datos ingresados.", HttpStatus.SC_BAD_REQUEST);
        }
        return userEntityToUserConverter.convert(userEntity);
    }

    @Override
    public List<User> getUsers() throws ApiException {
        List<UserEntity> userEntities = userDao.findAll();
        return userEntities.stream().map(userEntity -> userEntityToUserConverter.convert(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public User addRolToUser(String id, Rol rol) throws ApiException {
        UserEntity userEntity = userDao.findOne(id);
        if (userEntity == null) {
            throw new ApiException("El usuario seleccionado no existe.", HttpStatus.SC_BAD_REQUEST);
        }
        RolEntity rolEntity = rolDao.findOne(rol.getId());
        if (rolEntity == null) {
            throw new ApiException("No existe el rol seleccionado.", HttpStatus.SC_BAD_REQUEST);
        }
        if (userEntity.getRoles() == null) {
            userEntity.setRoles(Lists.newArrayList());
        }
        userEntity.getRoles().add(rolEntity);
        return userEntityToUserConverter.convert(userDao.save(userEntity));
    }
}
