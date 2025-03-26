package com.CodeBolds.info.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CodeBolds.info.dao.BlogRepository;
import com.CodeBolds.info.entities.BlogsEntity;

@Component
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository; //autowirng the repository
	
	public BlogsEntity createBlog(BlogsEntity blogs) {
		blogs.setCreatedAt(new Date()); // Set creation time  
	    return blogRepository.save(blogs);
	}
}
