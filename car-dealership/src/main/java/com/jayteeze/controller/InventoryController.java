package com.jayteeze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/")
	public String welcome(Model model) {
		inventoryService.populateApp();
		return "home";
	}
	
	@GetMapping("/inventory")
	public String currentInv(Model model) {
		model.addAttribute("inventory", inventoryService.getInventory());
		return "inventory";
	}

}
