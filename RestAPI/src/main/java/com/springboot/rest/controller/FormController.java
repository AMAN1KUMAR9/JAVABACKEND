package com.springboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FormController {
	@Autowired
	private FileHelper fileHelper;
	@PostMapping("/file")
	public ResponseEntity<String> form(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.isEmpty());
		
		
		
		if(fileHelper.name(file)) {
			
			System.out.println("uploaded sucessfully");
		}
		return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		
	}
}
