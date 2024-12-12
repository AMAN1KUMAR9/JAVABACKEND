package com.contactmanager.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contactmanager.dao.Dao;
import com.contactmanager.entities.User;
import com.contactmanager.message.SignupMessage;
import com.contactmanager.services.MailService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ForgotController {
	@Autowired
	Dao dao;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/forgot-password")
	public String forgotPassword(HttpSession session) {
		
		
		                return "forgot_password";
	}
	
	@PostMapping("/otp-page")
	public String postMethodName(@RequestParam("username") String email , HttpSession session) {
		User user = dao.getUserByEmail(email);
		if (user != null) {
		int length = 6;
		  Random random = new Random();
	        int min = (int) Math.pow(10, length - 1);  // Minimum value for the OTP
	        int max = (int) Math.pow(10, length) - 1;  // Maximum value for the OTP
	       int otp = random.nextInt(max - min + 1) + min;
	       System.out.println(otp );
	       System.out.println(user);
	       session.setAttribute("myOTP", otp);
	       session.setAttribute("email", email);
	       session.setAttribute("message", new SignupMessage("We have send you an otp", "alert-success"));
	       
	       String message = "your otp is "+ otp;
	       String subject = "change password for contact sphere";
	       String to = "amankumar13092pms@gmail.com";
	       this.mailService.sendEmailWithAttachment(message, subject, to);
	       
	       return "otp";
	}
		
		   session.setAttribute("message", new SignupMessage("username doesnot exist!", "danger"));
		return "redirect:/forgot-password";
	}
	
	
	@PostMapping("/otp-verification")
	public String OTPverification(@RequestParam("OTP") int otp , HttpSession session) {
		//TODO: process POST request
		
		int myOTP = (int)session.getAttribute("myOTP");
		if (otp == myOTP) {
			return "change_password";
		}
		
		session.setAttribute("message", new SignupMessage("wrong otp try again!", "alert-danger"));
		
		return "otp";
	}
	
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("newPass") String newPass , HttpSession session ) {
		
		String email = (String)session.getAttribute("email");
		
		User user = dao.getUserByEmail(email);
		
		user.setPassword(bCryptPasswordEncoder.encode(newPass));
		
		dao.save(user);
		
		
		return "redirect:/signin?change=password changed sucessfully";
	}
	
	

}
