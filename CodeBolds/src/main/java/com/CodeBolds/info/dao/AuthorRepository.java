package com.CodeBolds.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodeBolds.info.entities.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{

}
