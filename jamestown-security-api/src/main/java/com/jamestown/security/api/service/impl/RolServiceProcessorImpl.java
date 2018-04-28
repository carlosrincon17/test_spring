package com.jamestown.security.api.service.impl;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import com.jamestown.model.exception.ApiException;
import com.jamestown.security.api.converter.RolEntityToRolConverter;
import com.jamestown.security.api.converter.RolToRolEntityConverter;
import com.jamestown.security.api.converter.UserEntityToUserConverter;
import com.jamestown.security.api.converter.UserToUserEntityConverter;
import com.jamestown.security.api.dao.RolDao;
import com.jamestown.security.api.dao.UserDao;
import com.jamestown.security.api.entities.RolEntity;
import com.jamestown.security.api.entities.UserEntity;
import com.jamestown.security.api.service.RolServiceProcessor;
import com.jamestown.security.api.service.UserServiceProcessor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RolServiceProcessorImpl implements RolServiceProcessor {

    @Autowired
    private RolDao rolDao;

    @Autowired
    private RolToRolEntityConverter rolToRolEntityConverter;

    @Autowired
    private RolEntityToRolConverter rolEntityToRolConverter;

    @Override
    public Rol createRol(Rol rol) throws ApiException {
        RolEntity rolEntity = rolToRolEntityConverter.convert(rol);
        return rolEntityToRolConverter.convert(rolDao.save(rolEntity));
    }

    @Override
    public boolean deleteRol(Rol rol) {
        rolDao.delete(rol.getId());
        return true;
    }
}
