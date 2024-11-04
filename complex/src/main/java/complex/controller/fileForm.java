package complex.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class fileForm {

	@RequestMapping("/fileform")
	public String fileForm() {
		return "fileupload";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileAccepter(@RequestParam("formupload") CommonsMultipartFile file , HttpSession s , Model m) {
		System.out.println(file.getSize());
		System.out.println(file.getName());
		byte [] data = file.getBytes();
		
		String path = s.getServletContext().getRealPath("/") +"WEB-INF" + File.separator +"resources" +File.separator + file.getOriginalFilename();
		
		System.out.println(path);
		
		
		try {
			FileOutputStream out = new FileOutputStream(path);
			out.write(data);
			out.close();
			m.addAttribute("msg","upload successfully"  );
			m.addAttribute("fname", file.getOriginalFilename()  );
		}
		catch(IOException e) {
			m.addAttribute("msg", "upload failed");
			System.out.println("upload failed");
			
		}
		return "successs";
		
	}
}
