package com.contactmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.contactmanager.dao.Dao;
import com.contactmanager.entities.User;
import com.contactmanager.message.SignupMessage;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;



@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Dao dao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@GetMapping("/")
	public String home( Model model) {
		model.addAttribute("title" , "home - Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about( Model model) {
		model.addAttribute("title" , "about - Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model model ,HttpSession session) {
		model.addAttribute("title" , "signup - Smart Contact Manager");
		model.addAttribute("user",new User());
		 session.removeAttribute("message");
		return "signup";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "login";
	}
	
	@PostMapping("/register")
	public String doRegister( @Valid @ModelAttribute User user ,BindingResult result, @RequestParam(value = "agreement" ,defaultValue = "false") boolean agree ,HttpSession session ,Model model ) {
		
		try {

			if (!agree) {
				System.out.println("You have not agreed the terms and conditions");
				throw new Exception("You have not agreed the terms and conditions");
			}
			
			if (result.hasErrors()) {
				model.addAttribute("user" , user);
				return "signup";
			}
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			user.setImageUrl("default.png");
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			dao.save(user);
			
			session.setAttribute("message", new SignupMessage("success" , "alert-success"));
			model.addAttribute("user" , new User());
		
		}
		catch (Exception e) {
			System.out.println("Something went wrong");
			session.setAttribute("message", new SignupMessage("something went wrong!!" +e.getMessage() , "alert-danger"));
			model.addAttribute("user" , user);
			
		}
		return "signup";		
		
	}
	

	
}
