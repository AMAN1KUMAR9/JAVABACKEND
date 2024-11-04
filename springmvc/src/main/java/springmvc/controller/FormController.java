package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.services.UserService;
@Controller
public class FormController {
	@Autowired
	private UserService service;
	/*
	 * @ModelAttribute public void addCommonAttributes(Model m) { //
	 * m.addAttribute("header" , "registration"); }
	 */
	
	@RequestMapping("/form")
	public String form(Model m) {
		m.addAttribute("hey" , "registration");
		return "form";
	}
/*	primitive way
 * @RequestMapping(path = "processform" ,method = RequestMethod.POST )
	public String processFrom(HttpServletRequest httpServletRequest) {
		String email = httpServletRequest.getParameter("email");
		System.out.println(email);
		return null;
		
	}
	
	
	
	*/
	
/*
 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
 * String processFrom(@RequestParam(name = "email" , required = true ) String
 * userEmail,
 * 
 * @RequestParam("Name") String userName,
 * 
 * @RequestParam("Password") String userPass, Model model) {
 * 
 * // Logging to the console System.out.println(userEmail);
 * System.out.println(userPass); System.out.println(userName);
 * 
 * // Adding form data to the model to pass it to the view
 * model.addAttribute("name", userName); model.addAttribute("pass", userPass);
 * model.addAttribute("email", userEmail);
 * 
 * // Returning the view name (success.jsp or success.html) return "success"; }
 * 
 * 
 */
	 @RequestMapping(path = "processform" ,method = RequestMethod.POST )
	 public String processFrom(@ModelAttribute User user , Model model) {
			model.addAttribute("hey" , "registration");
			
		 int id = service.insertUser(user);
		 
		 
		return "sucess";
		 
	 }
}
