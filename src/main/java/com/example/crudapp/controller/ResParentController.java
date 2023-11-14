package com.example.crudapp.controller;

import com.example.crudapp.model.Parent;
import com.example.crudapp.model.ResParent;
import com.example.crudapp.repo.ParentRepo;
import com.example.crudapp.repo.ResParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller class handling HTTP requests related to Residential Parent (ResParent) entities.
 * Utilizes Thymeleaf templates for rendering views.
 */
@Controller
public class ResParentController {
    @Autowired
    private ResParentRepo resParentRepo;

    /**
     * Handles GET request to display a list of all Residential Parent (ResParent) entities.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for listing ResParent entities
     */
    @GetMapping("/resparents")
    public String listResParents(Model model) {
        List<ResParent> resParents = resParentRepo.findAll();
        model.addAttribute("resparents", resParents);
        return "list-resparents";
    }

    /**
     * Handles GET request to display the form for adding a new Residential Parent (ResParent) entity.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for adding a ResParent entity
     */
    @GetMapping("/add-resparent")
    public String showResParentForm(Model model) {
        model.addAttribute("resparent", new ResParent());
        return "add-resparent";
    }

    /**
     * Handles POST request to save a new Residential Parent (ResParent) entity.
     *
     * @param resParent the ResParent entity to be saved
     * @return the redirect URL to the list of ResParent entities
     */
    @PostMapping("/save-resparent")
    public String saveResParents(@ModelAttribute("resparent") ResParent resParent) {
        resParentRepo.save(resParent);
        return "redirect:/resparents";
    }

    /**
     * Handles GET request to display the form for editing an existing Residential Parent (ResParent) entity.
     *
     * @param id    the ID of the ResParent entity to be edited
     * @param model the model to be populated and passed to the view
     * @return the view name for editing a ResParent entity
     */
    @GetMapping("/edit-resparent/{id}")
    public String showEditResParentsForm(@PathVariable Long id, Model model) {
        ResParent resParent = resParentRepo.findById(id).orElse(null);
        model.addAttribute("resparent", resParent);
        return "edit-resparent";
    }

    /**
     * Handles GET request to delete an existing Residential Parent (ResParent) entity.
     *
     * @param id the ID of the ResParent entity to be deleted
     * @return the redirect URL to the list of ResParent entities
     */
    @GetMapping("/delete-resparent/{id}")
    public String deleteResParent(@PathVariable Long id) {
        resParentRepo.deleteById(id);
        return "redirect:/resparents";
    }
}
