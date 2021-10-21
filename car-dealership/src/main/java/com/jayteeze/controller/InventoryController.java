package com.jayteeze.controller;

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
	
	// Displays cars for sale
	@GetMapping("/inventory")
	public String currentInv(Model model) {
		model.addAttribute("inventory", inventoryService.forSale());
		return "inventory";
	}
	
	@GetMapping("/inventory/details")
	public ModelAndView getCarDetails(Model model, Integer transactionId) {
		return new ModelAndView("car-details-customer", "selectedCar", inventoryService.findById(transactionId));
	}
	
	@GetMapping("/inventory/findByKeyword")
	public ModelAndView findCar(Model model, String keyword) {
		return new ModelAndView("inventory", "inventory", inventoryService.findByKeyword(keyword));
	}
	
	
	// Page with options to buy selected car
	@GetMapping("/purchase")
	public ModelAndView purchaseCar(Model model, Integer transactionId) {
		return new ModelAndView("buy-bid", "selectedCar", inventoryService.findById(transactionId));
	}
	
	
	
	// Administrative options to modify/add/delete all cars/transactions
	@GetMapping("/modifyInventory")
	public ModelAndView modifyInv(Model model) {
		return new ModelAndView("admin-view", "inventory", inventoryService.getInventory());
	}
	
	// Add new entries
	@GetMapping("/modifyInventory/add")
	public ModelAndView addEntry(Model model) {
		return new ModelAndView("modify-entry-fields", "entry", new Transaction());
	}
	
	@PostMapping("/modifyInventory/add")
	public ModelAndView handleAddEntry(Model model, @ModelAttribute Transaction newEntry) {
		newEntry.setId(inventoryService.getNewIdNumber());
		inventoryService.addToInventory(newEntry);
		return new ModelAndView("admin-view", "inventory", inventoryService.getInventory());
	}
	
	// Edit existing entries
	@GetMapping("/modifyInventory/edit")
	public ModelAndView editEntry(Model model, Integer transactionId) {
		Transaction entry = inventoryService.findById(transactionId);
		return new ModelAndView("modify-entry-fields", "entry", entry);
	}
	
	@PostMapping("/modifyInventory/edit")
	public ModelAndView handleEditEntry(Model model, @ModelAttribute Transaction updatedEntry) {
		inventoryService.updateEntry(updatedEntry);
		return new ModelAndView("admin-view", "inventory", inventoryService.getInventory());
	}
	
	// Delete existing entries
	@GetMapping("/modifyInventory/delete")
	public ModelAndView deleteEntry(Model model, Integer transactionId) {
		inventoryService.deleteEntry(transactionId);
		return new ModelAndView("admin-view", "inventory", inventoryService.getInventory());
	}
	
	@GetMapping("/allTransactions")
	public String businessReport(Model model) {
		model.addAttribute("inventory", inventoryService.allTransactions());
		return "reports";
	}

}
