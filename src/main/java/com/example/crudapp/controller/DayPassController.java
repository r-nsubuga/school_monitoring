package com.example.crudapp.controller;

import com.example.crudapp.forms.DayPassForm;
import com.example.crudapp.model.DayPass;
import com.example.crudapp.repo.DayPassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DayPassController {

    @Autowired
    private DayPassRepo dayPassRepo;

    @GetMapping("/daypasses")
    public String listDayPasses(Model model) {
        List<DayPass> dayPassList = dayPassRepo.findAll();
        model.addAttribute("daypasses", dayPassList);
        return "list-daypasses";
    }

    @GetMapping("/add-daypass")
    public String showDayPassForm(Model model) {
        model.addAttribute("daypass", new DayPass());
        return "add-daypass";
    }

    @PostMapping("/save-daypass")
    public String saveDayPass(@ModelAttribute("daypass") DayPass dayPass) {
        dayPassRepo.save(dayPass);
        return "redirect:/daypasses";
    }

    @GetMapping("/edit-daypass/{id}")
    public String showEditDayPassForm(@PathVariable Long id, Model model) {
        DayPass dayPass = dayPassRepo.findById(id).orElse(null);
        model.addAttribute("daypass", dayPass);
        return "edit-daypass";
    }

    @GetMapping("/delete-daypass/{id}")
    public String deleteDayPass(@PathVariable Long id) {
        dayPassRepo.deleteById(id);
        return "redirect:/daypasses";
    }





//
//    @GetMapping("/daypass")
//    public String dayPassForm(Model model){
//        model.addAttribute("daypass", new DayPassForm());
//        return "daypassform";
//    }
//
//    @PostMapping("/daypass")
//    public String dayPassSubmit(@ModelAttribute DayPassForm dayPassForm, Model model, DayPassRepo repo){
//        model.addAttribute("dayPassFormResults", dayPassForm);
////        repo.save(new DayPass(dayPassForm.getReason(),dayPassForm.getParent_approval(),dayPassForm.getRes_parent_approval(),dayPassForm.getGuard_sign_off()));
//        System.out.println(dayPassForm.getReason());
//        return "redirect:/result";
//    }
//
//    @GetMapping("/result")
//    public String dayPassFormResult(Model model){
//        return "result";
//    }


}
