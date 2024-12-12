package com.contactmanager.services;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class MailService {

	

	public void sendEmailWithAttachment(String message, String subject, String to) {
        // Set mail server properties
		 String from = "aman135kumar@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aman135kumar@gmail.com", "vhin xztm rbcs oemq"); // Replace credentials
            }
        });

        try {
            // Compose the message
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set sender and recipient
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set subject
            mimeMessage.setSubject(subject);

            // Create multipart message
            MimeMultipart multipart = new MimeMultipart();

            // Add message body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(message);

            // Add attachment
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            String filePath ="C:\\Users\\aman1\\OneDrive\\Pictures\\hey.png"; // Replace with actual file path
//            File file = new File(filePath);

//            if (file.exists()) {
//                attachmentPart.attachFile(file);
//            } else {
//                System.out.println("File not found: " + filePath);
//                return;
//            }

            // Combine message and attachment
            multipart.addBodyPart(textPart);
//            multipart.addBodyPart(attachmentPart);

            mimeMessage.setContent(multipart);

            // Send the message
            Transport.send(mimeMessage);

            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }
}
