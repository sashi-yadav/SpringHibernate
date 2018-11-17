package com.springexample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.dao.StudentDAO;
import com.springexample.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	 StudentDAO studentDao;
	 
	 @Autowired
	 public void setStudentDao(StudentDAO studentDao) {
	  this.studentDao = studentDao;
	 }

	public List doGetStudents() {
		return studentDao.GetStudents();
	}
	public List doGetStudent(int id)
	{
		return studentDao.GetStudent(id);
	}
	public void doAddStudent(Student student)
	{
		 studentDao.AddStudent(student);
	}

	public List doGetStudentByMail(String email) {
		return studentDao.GetStudentByMail(email);
	}
	public void doDeleteStudent(int id)
	{
		studentDao.DeleteStudent(id);
	}
}
