package com.example.crudapp;

import com.example.crudapp.model.Role;
import com.example.crudapp.model.User;
import com.example.crudapp.repo.RoleRepository;
import com.example.crudapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DefaultAdminCreator implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultAdminCreator(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        // Check if the default admin already exists
        if (userRepository.findByEmailAddress("admin") == null) {
            // Create a default admin user
            User admin = new User();
            admin.setEmailAddress("admin");
            admin.setPassword(passwordEncoder.encode("adminPassword"));
            Role adminRole = roleRepository.findByName("ADMIN");
            admin.setRoles(new HashSet<>(Arrays.asList(adminRole)));

            // Save the user to the database
            userRepository.save(admin);

            System.out.println("Default admin created!");
        } else {
            System.out.println("Default admin already exists.");
        }
    }

}
