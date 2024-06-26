package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

	@GetMapping("/")
	public String index() {
		return "top";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
