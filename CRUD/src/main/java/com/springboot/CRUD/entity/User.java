package com.springboot.CRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 20)
    private String status;

    // Default constructor required by JPA
    public User() {
    }

    // Parameterized constructor for convenience
    public User(int id, String name, String address, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Optional: Override toString, equals, and hashCode
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", address=" + address + ", status=" + status + "]";
    }

}