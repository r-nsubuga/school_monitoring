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
@Controller
public class ParentController {
    @Autowired
    private ParentRepo parentRepo;

    @GetMapping("/parents")
    public String listParents(Model model) {
        List<Parent> parentList = parentRepo.findAll();
        model.addAttribute("parents", parentList);
        return "list-parents";
    }

    @GetMapping("/add-parent")
    public String showParentForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "add-parent";
    }

    @PostMapping("/save-parent")
    public String saveParents(@ModelAttribute("parent") Parent parent) {
        parentRepo.save(parent);
        return "redirect:/parents";
    }

    @GetMapping("/edit-parent/{id}")
    public String showEditParentsForm(@PathVariable Long id, Model model) {
        Parent parent = parentRepo.findById(id).orElse(null);
        model.addAttribute("parent", parent);
        return "edit-parent";
    }

    @GetMapping("/delete-parent/{id}")
    public String deleteParent(@PathVariable Long id) {
        parentRepo.deleteById(id);
        return "redirect:/parents";
    }

}
