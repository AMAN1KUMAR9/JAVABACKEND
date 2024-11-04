package complex.exceptionHandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class exceptionHandler {

	
	@ExceptionHandler(value = Exception.class)
	public String Exception(Model m) {
		
		
		
		m.addAttribute("error", "error");
		return "Exception";
	}
	

}
