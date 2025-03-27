package com.CodeBolds.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeBolds.info.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
