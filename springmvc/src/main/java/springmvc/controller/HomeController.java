package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping( "/home" )
	public String home(Model model) {
		model.addAttribute("name" , "aman kumar");
		return "index";
	}
	@RequestMapping(  "/about"  )
	public ModelAndView about() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id" , 1234);
		modelAndView.setViewName("about");
		return modelAndView;
	}
	@RequestMapping(  "/"  )
	public String main(Model model) {
		model.addAttribute("idd" , 121234);
		List<String> ls = new ArrayList<String>();
		ls.add("hi");
		ls.add("hey");
		model.addAttribute("ls",ls);
		
		return "main";
	}

}

