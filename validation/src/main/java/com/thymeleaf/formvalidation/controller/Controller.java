package com.thymeleaf.formvalidation.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.thymeleaf.formvalidation.entity.Entity;

import jakarta.validation.Valid;


@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/signin")
	public String login( Model m) {
		
		m.addAttribute("entity", new Entity());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String upload(@Valid @ModelAttribute("entity") Entity entity, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "login"; // Return the name of your HTML template
	    }
	    // Process the entity as needed (e.g., save it or perform business logic)
	    return "success"; // Redirect or forward to a success page
	}

	
	
	
}
