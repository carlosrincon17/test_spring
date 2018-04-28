package com.jamestown.security.api.dao;

import com.jamestown.security.api.entities.RolEntity;
import com.jamestown.security.api.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDao extends MongoRepository<RolEntity, String> {

}
