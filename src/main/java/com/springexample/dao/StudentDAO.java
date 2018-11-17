package com.springexample.dao;

import java.util.List;

import com.springexample.model.Student;

public interface StudentDAO {
public List GetStudents();
public List GetStudent(int id);
public List GetStudentByMail(String email);
public void AddStudent(Student student);
public void DeleteStudent(int id);
}
