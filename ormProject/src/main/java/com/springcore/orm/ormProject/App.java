package com.springcore.orm.ormProject;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springcore.orm.Dao.StudentDao;
import com.springcore.orm.entities.Student;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao st = context.getBean("stDao", StudentDao.class);
        Scanner sc = new Scanner(System.in);
        boolean con = true;

        while (con) {
            System.out.println("PRESS 1 for add new student");
            System.out.println("PRESS 2 for display all students");
            System.out.println("PRESS 3 for get detail of single student");
            System.out.println("PRESS 4 for delete student");
            System.out.println("PRESS 5 for update student");
            System.out.println("PRESS 6 for exit");

            try {
                int input = sc.nextInt();
                sc.nextLine();  // Consume newline

                switch (input) {
                    case 1:
                        // Insert student
                        System.out.println("Enter id");
                        int id = sc.nextInt();
                        sc.nextLine();  // Consume newline

                        System.out.println("Enter Name");
                        String name = sc.nextLine();

                        System.out.println("Enter city");
                        String city = sc.nextLine();

                        Student student = new Student(id, name, city);
                        System.out.println(st.insert(student));
                        break;

                    case 2:
                        // Fetch all students
                        for (Student stu : st.getAllStudent()) {
                            System.out.println(stu);
                        }
                        break;

                    case 3:
                        // Fetch a single student
                        System.out.println("Enter student id to fetch details:");
                        int i_d = sc.nextInt();
                        sc.nextLine();  // Consume newline

                        Student fetchedStudent = st.getStudent(i_d);
                        if (fetchedStudent != null) {
                            System.out.println(fetchedStudent);
                        } else {
                            System.out.println("Student with id " + i_d + " not found.");
                        }
                        break;

                    case 4:
                        // Delete student
                        System.out.println("Enter id to delete:");
                        int delId = sc.nextInt();
                        System.out.println("Student with id " + delId + " deleted");
                        st.delete(delId);
                        break;

                    case 5:
                        // Update student
                        System.out.println("Enter id of the student to update:");
                        int updateId = sc.nextInt();
                        sc.nextLine();  // Consume newline

                        // Fetch the existing student to ensure it exists
                        Student existingStudent = st.getStudent(updateId);
                        if (existingStudent != null) {
                            System.out.println("Enter new name:");
                            String newName = sc.nextLine();

                            System.out.println("Enter new city:");
                            String newCity = sc.nextLine();

                            // Update the student details
                            existingStudent.setStudentName(newName);
                            existingStudent.setStudentCity(newCity);

                            st.update(existingStudent);
                            System.out.println("Student with id " + updateId + " updated.");
                        } else {
                            System.out.println("Student with id " + updateId + " not found.");
                        }
                        break;

                    case 6:
                        con = false;
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid entry, please try again.");
                sc.nextLine(); // Clear the buffer
            }
        }
        sc.close();
    }
}
