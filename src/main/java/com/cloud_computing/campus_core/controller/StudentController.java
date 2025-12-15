package com.cloud_computing.campus_core.controller;

import com.cloud_computing.campus_core.entity.Student;
import com.cloud_computing.campus_core.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    StudentService service;

    @GetMapping
    public String list(Model model){
        model.addAttribute("students", service.findAll());
        return "students/list";
    }

    // CREATE FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    // CREATE
    @PostMapping
    public String create(@ModelAttribute Student student) {
        service.create(student);
        return "redirect:/students";
    }

    // EDIT FORM
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.findById(id));
        return "students/form";
    }

    // UPDATE
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student) {
        service.update(id, student);
        return "redirect:/students";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}
