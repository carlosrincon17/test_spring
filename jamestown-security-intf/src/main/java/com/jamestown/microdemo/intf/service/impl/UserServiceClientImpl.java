//package com.jamestown.microdemo.intf.service.impl;
//
//import com.jamestown.microdemo.intf.service.UserService;
//import com.jamestown.model.dto.NivelIngles;
//import com.jamestown.model.dto.Rol;
//import com.jamestown.model.dto.User;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//import java.util.List;
//
//public class UserServiceClientImpl implements UserService {
//
//    private final RestTemplate restTemplate;
//
//    private final String microDemoUrlBase;
//
//    public UserServiceClientImpl(String microDemoUrlBase) {
//        this.restTemplate = new RestTemplate();
//        this.microDemoUrlBase = microDemoUrlBase;
//    }
//
//    @Override
//    public User createUser(User user) {
//        return null;
//    }
//
//    @Override
//    public User updateUser(User user) {
//        return null;
//    }
//
//    @Override
//    public User getUser(String id) {
//        return null;
//    }
//
//    @Override
//    public List<User> getUsers() {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<User> addRolToUser(String id, Rol rol) {
//        return null;
//    }
//}
