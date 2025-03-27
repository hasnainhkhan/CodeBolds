package com.CodeBolds.info.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.CodeBolds.info.dao.BlogRepository;
import com.CodeBolds.info.entities.BlogsEntity;

import jakarta.transaction.Transactional;

@Component
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository; //autowirng the repository
	
	public BlogsEntity createBlog(BlogsEntity blogs) {
		blogs.setCreatedAt(new Date()); // Set creation time  
	    return blogRepository.save(blogs);
	}
	
	public List<BlogsEntity> findAllBlogs() {
	    return blogRepository.findAll();
	}
	
	public BlogsEntity findById(int id) {
	    return blogRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
	}
	 @Transactional
    public boolean deleteUser(Integer id) {
        BlogsEntity existingUser = blogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        blogRepository.delete(existingUser);
        return "User with ID " + id + " deleted successfully." != null;
    }
	
	public BlogsEntity updateBlogs(Integer id, BlogsEntity updatedBlog) {
		BlogsEntity existingBlog = blogRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found"));
		
		existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        existingBlog.setAuthor(updatedBlog.getAuthor());
        existingBlog.setUser(updatedBlog.getUser());
        return blogRepository.save(existingBlog);
		
	}
}
