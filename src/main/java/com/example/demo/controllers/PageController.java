package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.students.Student;

@Controller
public class PageController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getStudent());
        return "showStudents";
    }

    @GetMapping("addStudent")
    public String addStudentForm(Model model) {
        model.addAttribute(new Student());
        return "addStudent";
    }

    @GetMapping("updateStudent")
    public String updateStudentForm(Model model) {
        model.addAttribute(new Student());
        return "updateStudent";
    }

    @GetMapping("deleteStudent")
    public String deleteStudentForm(Model model) {
        model.addAttribute(new Student());
        return "deleteStudent";
    }

    @PostMapping("addStudent")
    public String addStudentSubmit(@ModelAttribute Student student) {
        studentService.postStudent(student);
        return "addStudent";
    }

    @PostMapping("updateStudent")
    public String updateStudentSubmit(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "updateStudent";
    }

    @PostMapping("deleteStudent")
    public String deleteStudentSubmit(@ModelAttribute Student student) {
        studentService.deleteStudent(student);
        return "deleteStudent";
    }
}
