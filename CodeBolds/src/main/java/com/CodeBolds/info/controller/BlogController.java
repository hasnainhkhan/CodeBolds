package com.CodeBolds.info.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodeBolds.info.dao.UserRepository;
import com.CodeBolds.info.entities.BlogsEntity;
import com.CodeBolds.info.entities.UserEntity;
import com.CodeBolds.info.service.BlogService;

import jakarta.persistence.EntityManager;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/home")
	public String test() {
		return "this is controller";
	}
	
	@PostMapping("/")
	public ResponseEntity<BlogsEntity> createBlog(@RequestBody BlogsEntity blog) {
	 
	    BlogsEntity savedBlog = blogService.createBlog(blog);

	    return ResponseEntity.status(HttpStatus.CREATED).body(savedBlog);
	}

	
}
