package com.example.crudapp.model;

import com.example.crudapp.constants.Gender;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private Set<Role> roles;
    private String password;
    private String phoneNumber;
    private Gender gender;
    private String emailAddress;

    public User() {
    }

    public User(String emailAddress, String password, Set<Role> roles) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.roles = roles;

    }


    @Column(
            name = "password",
            nullable = false
    )
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "role_users",
            joinColumns = {@JoinColumn(
                    name = "user_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "role_id"
            )}
    )
    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Column(
            name = "email_address",
            nullable = true
    )
    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Column(
            name = "last_name",
            nullable = true
    )
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(
            name = "first_name",
            nullable = true
    )
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(
            name = "gender",
            nullable = true
    )
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return this.gender;
    }

    @Column(
            name = "phone_number",
            nullable = true
    )
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
