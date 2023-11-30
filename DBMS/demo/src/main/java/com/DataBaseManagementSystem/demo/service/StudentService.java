package com.DataBaseManagementSystem.demo.service;


import com.DataBaseManagementSystem.demo.entity.Student;

import java.util.List;
public interface StudentService  {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudents);

    void deleteById(int theId);

}
