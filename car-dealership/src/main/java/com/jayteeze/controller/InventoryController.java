package com.jayteeze.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jayteeze.entity.Transaction;

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
	
	@GetMapping("/modifyInventory")
	public ModelAndView modifyInv(Model model) {
		return new ModelAndView("modify", "inventory", inventoryService.getInventory());
	}
	
	@GetMapping("/modifyInventory/edit")
	public ModelAndView editEntry(Model model, Integer transactionId, HttpSession session) {
		Transaction entry = inventoryService.entryById(transactionId);
		
		session.setAttribute("entryForUpdate", entry);
		
		return new ModelAndView("edit-entry", "entry", entry);
	}
	
	@PostMapping("/modifyInventory/edit")
	public ModelAndView handleEditEntry(Model model, HttpSession session) {
		Transaction updatedEntry = (Transaction) session.getAttribute("entryForUpdate");
		model.addAttribute("updatedEntry", updatedEntry);
		System.out.println(updatedEntry.getId());
		
		inventoryService.updateEntry(updatedEntry);
		
		System.out.println("in handle edit servlet");
		session.removeAttribute("updatedEntry");
		
		return new ModelAndView("modify", "inventory", inventoryService.getInventory());
	}
	
	@GetMapping("/modifyInventory/delete")
	public ModelAndView deleteEntry(Model model, Integer transactionId) {
		inventoryService.deleteEntry(transactionId);
		return new ModelAndView("modify", "inventory", inventoryService.getInventory());
	}

}
