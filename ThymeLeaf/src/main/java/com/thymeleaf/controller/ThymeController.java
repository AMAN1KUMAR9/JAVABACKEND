package com.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ThymeController {
	
	@RequestMapping(value = "/hey", method=RequestMethod.GET)
	public String requestMethodName(Model model ) {
		
		model.addAttribute("hey", "hello");
		
		List<String> list = List.of("aman" , "arjun" , "aditya" ,"bheem " , "sulochan");
	
		model.addAttribute("list", list);
		return "about";
	}
	
	

}
