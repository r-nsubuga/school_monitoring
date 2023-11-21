package com.example.crudapp.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Parent")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Parent{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // First name of the parent
    private String firstName;
    // Last name of the parent
    private String lastName;

    // Phone number of the parent
    private String phoneNumber;

    // Email address of the parent
    public String email;

    // One-to-Many relationship with Student entities
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "parent"
    )

    private List<Student> students = new ArrayList<>();


    // Getter and Setter methods for 'firstName'
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter methods for 'lastName'
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter methods for 'phoneNumber'
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods for 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
