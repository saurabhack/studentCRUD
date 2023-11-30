package com.DataBaseManagementSystem.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="Roll_No")
    private int rollNo;

    public Student(){

    }

    public Student(String firstName, String lastName, int rollNo){
        this.firstName=firstName;
        this.lastName=lastName;
        this.rollNo=rollNo;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getRollNo(){
        return rollNo;
    }

    public void setRollNo(int rollNo){
        this.rollNo=rollNo;
    }

    @Override
    public String toString(){
        return "Students{"+
                "id="+id+
                ",firstName='"+firstName+'\''+
                ",lastName='"+lastName+'\''+
                ",rollNo='"+rollNo+'\''+
                '}';
    }

}

