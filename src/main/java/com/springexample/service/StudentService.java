package com.springexample.service;

import java.util.List;

import com.springexample.model.Student;

public interface StudentService {
public List doGetStudents();
public List doGetStudent(int id);
public List doGetStudentByMail(String email);
public void doAddStudent(Student student);
public void doDeleteStudent(int id);
}
