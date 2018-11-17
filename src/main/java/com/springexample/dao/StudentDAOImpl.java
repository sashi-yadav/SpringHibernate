package com.springexample.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springexample.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	 protected Session getSession(){
		  return sessionFactory.getCurrentSession();
		 }

	public List GetStudents() {
		Criteria criteria = getSession().createCriteria(Student.class);
		return (List) criteria.list();
	}
	public List GetStudent(int id) {
		List student= getSession().createCriteria(Student.class).add(Restrictions.eq("id",id)).list();
		return student;
		
	}
	public List GetStudentByMail(String email)
	{
		List student=getSession().createCriteria(Student.class).add(Restrictions.eq("email", email)).list();
		return student;
	}
	public void AddStudent(Student student) {
		getSession().save(student);
	}
	public void DeleteStudent(int id)
	{
		Student student=(Student) getSession().get(Student.class, id);
		getSession().delete(student);
	}
}
