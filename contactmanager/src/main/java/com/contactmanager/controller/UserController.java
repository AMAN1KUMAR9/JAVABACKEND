package com.contactmanager.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.contactmanager.dao.ContactsDao;
import com.contactmanager.dao.Dao;
import com.contactmanager.entities.Contacts;
import com.contactmanager.entities.User;
import com.contactmanager.message.SignupMessage;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMethod;



@Controller


@RequestMapping("/user")
public class UserController {
	@Autowired
	Dao dao;
	
	@Autowired
	ContactsDao cDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@ModelAttribute
	public void addCommonContent (Model model , Principal principal) {
		System.out.println(principal.getName());
		String name = principal.getName();
		User user = dao.getUserByEmail(name);
		System.out.println(user);
		model.addAttribute("user", user );
	}
	
	
	@GetMapping("/index")
	public String login( Model model , Principal principal) {

		return "user/dashboard";
	}
	
	@RequestMapping(value = "/add_contact", method=RequestMethod.GET)
	public String addContact(Model model ) {

		model.addAttribute("title", "add-contact");

		
		return "user/add_contact";
	}
	
	
	@PostMapping("/contact-submit")
	public String contactDetailsSubmission(@ModelAttribute Contacts contact ,@RequestParam ( "profileimage") MultipartFile mFile,Principal principal ,HttpSession session) {
		try {
			
			if (mFile.isEmpty()) {
				
				contact.setImage("profile.jpg");
				System.out.println("File is Empty");
				String name = principal.getName();
				User user = dao.getUserByEmail(name);
				contact.setUser(user);
				user.getContacts().add(contact);
				
				dao.save(user);
				session.setAttribute("message", new SignupMessage("contact saved successfully", "alert-success"));
				
				System.out.println(contact);
			}
			else {
			contact.setImage(mFile.getOriginalFilename());
			File file = new ClassPathResource("static/image").getFile();
			
			Path path = Paths.get(file.getAbsolutePath() + File.separator + mFile.getOriginalFilename());
			
			Files.copy(mFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			String name = principal.getName();
			User user = dao.getUserByEmail(name);
			contact.setUser(user);
			user.getContacts().add(contact);
			
			dao.save(user);
			session.setAttribute("message", new SignupMessage("contact saved successfully", "alert-success"));
			
			System.out.println(contact);
			}
		}
		catch (Exception e) {
			
			session.setAttribute("message", new SignupMessage("Something went wrong!", "alert-danger"));
		}
		return "user/add_contact";
	}
	
	
	@GetMapping("/view-contact/{pageNo}")
	public String viewContact (@PathVariable("pageNo") Integer pageNo ,Model model , Principal principal) {
		model.addAttribute("title" , "view-contact");
		
		String username = principal.getName();
		
		User userByEmail = dao.getUserByEmail(username);
		
		Pageable pageRequest = (Pageable) PageRequest.of(pageNo, 5);
		
		Page<Contacts> contactsByUserId = cDao.getContactsByUserId(userByEmail.getId() , pageRequest );
		
		model.addAttribute("contactsList",contactsByUserId);
		model.addAttribute("currentPage" , pageNo);
		model.addAttribute("totalPages" , contactsByUserId.getTotalPages());
		
		return  "user/viewContact";
	}
	
	
	@GetMapping("/profile/{cID}")
	public String profileView(@PathVariable("cID") Integer cID , Model model , Principal principal) {

		String username = principal.getName();
		
		User user = dao.getUserByEmail(username);
		
		Optional<Contacts> contactProfile = cDao.findById(cID);
		Contacts contacts = contactProfile.get();
		if (user.getId() == contacts.getUser().getId()) {
		model.addAttribute("contact", contacts);}
		else {
			model.addAttribute("denied" , "Access Denied");
		}
		
		return "user/profile";
	}
	
	
	@GetMapping("/delete-contact/{cId}")
	public String delete(@PathVariable("cId") Integer cId , @RequestParam("page") int page , Model model ,Principal principal) {
		
		String username = principal.getName();
		
		User user = dao.getUserByEmail(username);
		Contacts contact = cDao.findById(cId).get();
		
		
		
		if (user.getId() == contact.getUser().getId()) {
			contact.setImage(null);
			contact.setUser(null);
			cDao.delete(contact);}
			else {
				model.addAttribute("denied" , "Access Denied");
				return "user/profile";
			} 
		
		return  "redirect:/user/view-contact/" + page;
	}
	
	
	@PostMapping("/update/{cId}")
	public String update(@PathVariable("cId") Integer cId ,  Model m , Principal principal) {
		
		String username = principal.getName();
		
		User user = dao.getUserByEmail(username);
		Contacts contact = cDao.findById(cId).get();
		
		m.addAttribute("contact",contact);
		m.addAttribute("title", "update-contact");
		
		return "user/update_contact";
	}
	
	
	
 @GetMapping("/password")
 public String setting(Model m) {
	 
	 m.addAttribute("title", "user-settings");
     return "user/password_setting";
 }
 
 @PostMapping("/pass-update-form")
 public String postMethodName(@RequestParam("old") String oldPass ,@RequestParam("new") String newPass , Principal principal , HttpSession session) {

     String userName = principal.getName();
     
     User user = dao.getUserByEmail(userName);
     
     user.getPassword();
	 
     boolean matches = bCryptPasswordEncoder.matches(oldPass, user.getPassword());
     
     
     if(matches) {
    	 
    	 user.setPassword(bCryptPasswordEncoder.encode(newPass));
    	 dao.save(user);
    	 session.setAttribute("message", new SignupMessage("Password Chaneged successfully", "alert-success"));
    	 return  "redirect:/user/index";
     }
    
     
     session.setAttribute("message", new SignupMessage("Wrong password entered!", "alert-danger"));
     return "redirect:/user/password";
 }
 

 @GetMapping("/user-profile")
 public String userProfile(Model m , Principal principal) {
	 m.addAttribute("title" , "profile page");
	 
	 String name = principal.getName();
	 
	 User user = dao.getUserByEmail(name);
	 
	 m.addAttribute("user", user);
	 
     return  "user/dashboard";
 }
 
}







