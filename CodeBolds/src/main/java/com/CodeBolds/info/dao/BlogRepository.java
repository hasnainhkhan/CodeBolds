package com.CodeBolds.info.dao;

import java.awt.print.Pageable;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodeBolds.info.entities.BlogsEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogsEntity, Integer> {
	
}
