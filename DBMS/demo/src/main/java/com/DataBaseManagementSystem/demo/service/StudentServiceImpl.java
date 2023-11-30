package com.DataBaseManagementSystem.demo.service;

import com.DataBaseManagementSystem.demo.dao.StudentRepository;
import com.DataBaseManagementSystem.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl (StudentRepository theStudentRepository){
     studentRepository=theStudentRepository;
    }


    @Override
    public List<Student> findAll(){
        return studentRepository.findByOrderByLastNameAsc();
    }

    public Student findById(int theId){
        Optional<Student> result=studentRepository.findById(theId);
        Student theStudent=null;

        if(result.isPresent()){
            theStudent=result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " +theId);
        }
        return theStudent;
    }

    @Override
    public Student save(Student theStudents){
        return studentRepository.save(theStudents);
    }

    @Override
    public void deleteById(int theId){
        studentRepository.deleteById(theId);
    }

}
