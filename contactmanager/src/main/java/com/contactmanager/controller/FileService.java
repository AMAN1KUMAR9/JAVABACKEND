package com.contactmanager.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileService {

    public boolean deleteFile(String fileName) {
        try {
            // Resolve the file path
            File file = new File("src/main/resources/static/image/" + fileName);
            
            // Check if the file exists
            if (file.exists()) {
                return file.delete();  // Attempt deletion
            } else {
                System.out.println("File not found: " + fileName);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
