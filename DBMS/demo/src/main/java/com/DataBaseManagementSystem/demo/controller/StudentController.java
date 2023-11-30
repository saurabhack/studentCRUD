package com.DataBaseManagementSystem.demo.controller;

import com.DataBaseManagementSystem.demo.entity.Student;
import com.DataBaseManagementSystem.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService theStudentService){
        studentService=theStudentService;
    }

    // add mapping for "/list"

    @GetMapping("/st")
    public String listStudents(Model theModel){
        List<Student> theStudents=studentService.findAll();
        theModel.addAttribute("student",theStudents);
        return "students/StudentsList";
    }

    @GetMapping("/addForm")
    public String addForm(Model theModel){
        Student theStudent=new Student();
        theModel.addAttribute("student",theStudent);
        return "students/add";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("studentId") int theId, Model theModel){
        Student theStudent=studentService.findById(theId);
        theModel.addAttribute("student",theStudent);
        return "students/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student theStudent){
        studentService.save(theStudent);
        return "redirect:/students/st";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId){
        studentService.deleteById(theId);
        return "redirect:/students/st";
    }

}
