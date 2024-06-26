package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	private ItemsService itemsService;

	public ItemsController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@GetMapping("/")
	public String top(Model model) {
		model.addAttribute("items", itemsService.getItems());
		return "items";
	}

	@GetMapping("/create")
	public String create() {
		return "create";
	}
}
