package com.CodeBolds.info.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/home")
	public String test() {
		return "this is controller";
	}
}
