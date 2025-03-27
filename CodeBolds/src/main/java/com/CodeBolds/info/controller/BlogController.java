package com.CodeBolds.info.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodeBolds.info.dao.BlogRequest;
import com.CodeBolds.info.dao.UserRepository;
import com.CodeBolds.info.entities.BlogsEntity;
import com.CodeBolds.info.entities.UserEntity;
import com.CodeBolds.info.service.BlogService;
import com.CodeBolds.info.service.HuggingFaceService;

import jakarta.persistence.EntityManager;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	
	private final HuggingFaceService huggingFaceService;
	
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
	
	@GetMapping("/blogs") //find all 
	public ResponseEntity<List<BlogsEntity>> getAllBlogs() {
	    List<BlogsEntity> blogs = blogService.findAllBlogs();
	    return ResponseEntity.ok(blogs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BlogsEntity> getBlog(@PathVariable Integer id) {
	    try {
	        BlogsEntity blog = blogService.findById(id);
	        return ResponseEntity.ok(blog);
	    } catch (Exception e) {
	        e.printStackTrace(); // Avoid printing stack trace in production, use logging instead.
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
	    boolean isDeleted = blogService.deleteUser(id); // Assuming service returns boolean

	    if (isDeleted) {
	        return ResponseEntity.ok("User deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }
	    
	    
	}
	
	  @PutMapping("/{id}")
	    public ResponseEntity<BlogsEntity> updateBlog(@PathVariable Integer id, @RequestBody BlogsEntity updatedBlog) {
	        BlogsEntity blog = blogService.updateBlogs(id, updatedBlog);
	        return ResponseEntity.ok(blog);
	    }
	  
	  

	    public BlogController(HuggingFaceService huggingFaceService) {
	        this.huggingFaceService = huggingFaceService; //args constructure
	    }

	    @PostMapping("/summarize")
	    public ResponseEntity<String> summarizeBlog(@RequestBody BlogRequest request) {
	        String summary = huggingFaceService.summarizeText(request.getBlogContent());
	        return ResponseEntity.ok(summary);
	    }
	    public String ma() {
	    	return "this is main";
	    }
	
}
