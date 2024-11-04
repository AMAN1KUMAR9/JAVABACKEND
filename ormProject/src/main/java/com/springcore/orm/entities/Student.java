package com.springcore.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Details")
public class Student {

    @Id
    @Column(name = "Student_id")
    private int studentId;
    
    @Column(name = "Student_name")
    private String studentName;
    
    @Column(name = "Student_city")
    private String studentCity;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public Student(int studentId, String studentName, String studentCity) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity + "]";
    }
}
