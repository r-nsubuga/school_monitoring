package com.example.crudapp.controller;

import com.example.crudapp.model.DayPass;
import com.example.crudapp.model.Parent;
import com.example.crudapp.repo.DayPassRepo;
import com.example.crudapp.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
/**
 * Controller class handling HTTP requests related to Parent entities.
 * Utilizes Thymeleaf templates for rendering views.
 */
@Controller
public class ParentController {
    @Autowired
    private ParentRepo parentRepo;

    /**
     * Handles GET request to display a list of all Parent entities.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for listing Parent entities
     */
    @GetMapping("/parents")
    public String listParents(Model model) {
        List<Parent> parentList = parentRepo.findAll();
        model.addAttribute("parents", parentList);
        return "list-parents";
    }

    /**
     * Handles GET request to display the form for adding a new Parent entity.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for adding a Parent entity
     */
    @GetMapping("/add-parent")
    public String showParentForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "add-parent";
    }

    /**
     * Handles POST request to save a new Parent entity.
     *
     * @param parent the Parent entity to be saved
     * @return the redirect URL to the list of Parent entities
     */
    @PostMapping("/save-parent")
    public String saveParents(@ModelAttribute("parent") Parent parent) {
        parentRepo.save(parent);
        return "redirect:/parents";
    }

    /**
     * Handles GET request to display the form for editing an existing Parent entity.
     *
     * @param id    the ID of the Parent entity to be edited
     * @param model the model to be populated and passed to the view
     * @return the view name for editing a Parent entity
     */
    @GetMapping("/edit-parent/{id}")
    public String showEditParentsForm(@PathVariable Long id, Model model) {
        Parent parent = parentRepo.findById(id).orElse(null);
        model.addAttribute("parent", parent);
        return "edit-parent";
    }

    /**
     * Handles GET request to delete an existing Parent entity.
     *
     * @param id the ID of the Parent entity to be deleted
     * @return the redirect URL to the list of Parent entities
     */
    @GetMapping("/delete-parent/{id}")
    public String deleteParent(@PathVariable Long id) {
        parentRepo.deleteById(id);
        return "redirect:/parents";
    }

}
