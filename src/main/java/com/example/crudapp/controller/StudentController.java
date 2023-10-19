package com.example.crudapp.controller;

import com.example.crudapp.model.Parent;
import com.example.crudapp.model.ResParent;
import com.example.crudapp.model.Student;
import com.example.crudapp.repo.ParentRepo;
import com.example.crudapp.repo.ResParentRepo;
import com.example.crudapp.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private ResParentRepo resParentRepo;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> studentList = studentRepo.findAll();
        model.addAttribute("students", studentList);
        return "list-students";
    }

    @GetMapping("/add-student")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        List<Parent> parentList = parentRepo.findAll();
        model.addAttribute("parents", parentList);
        List<ResParent> resParentList = resParentRepo.findAll();
        model.addAttribute("resparents", resParentList);
        return "add-student";
    }

    @PostMapping("/save-student")
    public String saveBook(@ModelAttribute("student") Student student) {
        studentRepo.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentRepo.findById(id).orElse(null);
        model.addAttribute("student", student);

        List<Parent> parentList = parentRepo.findAll();
        model.addAttribute("parents", parentList);
        List<ResParent> resParentList = resParentRepo.findAll();
        model.addAttribute("resparents", resParentList);

        return "edit-student";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
        return "redirect:/students";
    }

}
