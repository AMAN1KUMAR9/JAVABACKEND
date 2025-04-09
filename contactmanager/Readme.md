# Contact Sphere - Contact Manager Application

Contact Sphere is a full-stack web application built with Spring Boot that allows users to securely manage their personal and professional contacts. The application provides user registration, login, contact CRUD operations, and a clean, responsive UI.

## Features

- User Registration and Login  
- Secure Authentication with Spring Security  
- Add, View, Edit, and Delete Contacts  
- Upload and Display Contact Images  
- Search and Filter Contacts  
- Pagination for Contact Listings  
- Responsive Frontend using Bootstrap and Thymeleaf  
- Role-Based Access Control  
- Custom Error Handling and Validations

## Tech Stack

- **Backend:** Spring Boot, Spring MVC, Spring Data JPA, Spring Security  
- **Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap  
- **Database:** MySQL  
- **Build Tool:** Maven

## Installation and Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/contact-sphere.git
   cd contact-sphere

2. Set up MySQL Database

Create a MySQL database (e.g., contact_manager)

Update application.properties with your DB credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/contact_manager
spring.datasource.username=root
spring.datasource.password=....
spring.jpa.hibernate.ddl-auto=update



3. Build and Run the Application

./mvnw spring-boot:run


4. Access the Application Open your browser and go to http://localhost:8080



Project Structure

src/
├── main/
│   ├── java/
│   │   └── com/example/contactmanager/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── service/
│   │       └── ContactManagerApplication.java
│   ├── resources/
│   │   ├── templates/
│   │   ├── static/
│   │   └── application.properties


Future Improvements

Add Email Notification Feature

Export Contacts to CSV

Integration with cloud storage for image uploads

RESTful API version for mobile clients
