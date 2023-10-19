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

@Controller
public class ResParentController {
    @Autowired
    private ResParentRepo resParentRepo;

    @GetMapping("/resparents")
    public String listResParents(Model model) {
        List<ResParent> resParents = resParentRepo.findAll();
        model.addAttribute("resparents", resParents);
        return "list-resparents";
    }

    @GetMapping("/add-resparent")
    public String showResParentForm(Model model) {
        model.addAttribute("resparent", new ResParent());
        return "add-resparent";
    }

    @PostMapping("/save-resparent")
    public String saveResParents(@ModelAttribute("resparent") ResParent resParent) {
        resParentRepo.save(resParent);
        return "redirect:/resparents";
    }

    @GetMapping("/edit-resparent/{id}")
    public String showEditResParentsForm(@PathVariable Long id, Model model) {
        ResParent resParent = resParentRepo.findById(id).orElse(null);
        model.addAttribute("resparent", resParent);
        return "edit-resparent";
    }

    @GetMapping("/delete-resparent/{id}")
    public String deleteResParent(@PathVariable Long id) {
        resParentRepo.deleteById(id);
        return "redirect:/resparents";
    }
}
