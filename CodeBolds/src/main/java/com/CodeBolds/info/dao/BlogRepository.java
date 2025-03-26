package com.CodeBolds.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodeBolds.info.entities.BlogsEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogsEntity, Integer> {

}
