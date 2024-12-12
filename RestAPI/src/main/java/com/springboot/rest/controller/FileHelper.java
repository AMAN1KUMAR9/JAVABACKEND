package com.springboot.rest.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
	
	
//	String path = "C:\\Users\\aman1\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\RestAPI\\src\\main\\resources\\templates";
	String path = new ClassPathResource("/").getFile().getAbsolutePath();
	
	public FileHelper() throws IOException{
//		super();
	}

	public Boolean name(MultipartFile mf) {
		Boolean f = false;
		System.out.println(path);
		try {
			
		Files.copy(mf.getInputStream(),Paths.get(path+File.separator+mf.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		f= true;
		}
		catch (Exception e) {
		System.out.println(e);
		}
		return f;
	}
	
}
