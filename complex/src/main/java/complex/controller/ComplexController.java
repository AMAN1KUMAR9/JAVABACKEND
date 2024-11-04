
package complex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import complex.model.Complex;
import complex.services.ComplexServices;


@Controller
public class ComplexController {
	@Autowired
	private ComplexServices complexServices;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/complex";
	}
	@RequestMapping("/complex")
	public String complex() {
//		String s = null;
//		int st = s.length();
		return "ComplexForm";
	}
////	
	@RequestMapping(path = "/handle" ,method = RequestMethod.POST )
	public String handler( @ModelAttribute("com") Complex com , BindingResult result) {
		if(result.hasErrors()) {
			return "ComplexForm";
		}
		System.out.println(com); 
		System.out.println(complexServices.insertUser(com));
		
		return "handler";
	}
//	

	    
//	    @Autowired
//	    private ComplexServices complexServices;
//
//	    @RequestMapping(path = "/handle", method = RequestMethod.POST)
//	    public String handler1(@ModelAttribute Complex com) {
//	        long id = complexServices.insertUser(com);  // Insert user into the database
//	        System.out.println("Inserted record with id: " + id);
//	        return "handler";  // Success page/view
//	    }
	}

	

