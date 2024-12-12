package com.thymeleaf.formvalidation.entity;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Entity {

	@NotBlank(message = "Email is required")
//	@jakarta.validation.constraints.Email(message = "Please provide a valid email address")
	@Pattern(
		    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
		    message = "Please provide a valid email address"
		)
	private String email;




  @NotBlank(message = "Username cannot be blank")
  @Size(min = 3, max = 12, message = "Username should be between 3 to 12 characters")
    private String username; 
  
  @AssertTrue(message = "You must agree to the terms and conditions")
  private Boolean check;

    public Entity() {
    }

    public Entity(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Entity [email=" + email + ", username=" + username + "]";
    }
}
