package com.example.crudapp.controller;

import com.example.crudapp.model.Parent;
import com.example.crudapp.model.User;
import com.example.crudapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Handles GET request to display the form for adding a new User instance.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for adding the instance
     */
    @GetMapping("/add-user")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    /**
     * Handles POST request to save a new User instance.
     *
     * @param user the User instance to be saved
     * @return the redirect URL to the list of Parent entities
     */
    @PostMapping("/save-user")
    public String saveParents(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/parents";
    }

    /**
     * Handles GET request to display the form for editing an existing User instance.
     *
     * @param id    the ID of the User instance to be edited
     * @param model the model to be populated and passed to the view
     * @return the view name for editing a User instance
     */
    @GetMapping("/edit-user/{id}")
    public String showEditParentsForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "edit-user";
    }

    /**
     * Handles GET request to delete an existing User instance.
     *
     * @param id the ID of the User instance to be deleted
     * @return the redirect URL to the list of User instances
     */
    @GetMapping("/delete-user/{id}")
    public String deleteParent(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
