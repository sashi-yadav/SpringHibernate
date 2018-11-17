package com.springexample.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springexample.model.Student;
import com.springexample.model.Ticket;
import com.springexample.service.StudentService;
import com.springexample.service.TicketService;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@Autowired
	private TicketService ticketservice;
	
	@RequestMapping(value="/list",method=RequestMethod.GET , headers="Accept=application/json")
	public @ResponseBody List getStudents() {
		List students = service.doGetStudents();
		return students;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody List getStudent(@PathVariable("id") int id)
	{
		List student=service.doGetStudent(id);
		return student;
	}
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public @ResponseBody List getStudentByMail(HttpEntity<String> httpentity)throws IOException
	{
		String json=httpentity.getBody();
		ObjectMapper mapper=new ObjectMapper();
		JsonNode obj=mapper.readTree(json);
		JsonNode obj2=obj.get("EMAIL");
		String email=obj2.asText();
		List student=service.doGetStudentByMail(email);
		return student;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody ResponseEntity AddStudent(@RequestBody Student student)
	{
		try {
			service.doAddStudent(student);
			return  ResponseEntity.ok("Record Added Sucessfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity DeleteStudent(@PathVariable int id)
	{
		
		try {
			service.doDeleteStudent(id);
			return  ResponseEntity.ok("Record deleted Sucessfully");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value="/addTicket",method=RequestMethod.POST)
	public @ResponseBody Ticket AddTicket(@RequestBody Ticket ticket)
	{
		/*String json=httpentity.getBody();
		ObjectMapper mapper=new ObjectMapper();
		JsonNode obj=mapper.readTree(json);
		JsonNode obj2=obj.get("student");
		JsonNode obj3=obj2.get("id");
		int id=obj3.asInt();
		service.doGetStudent(id);*/
		ticketservice.doAddTicket(ticket);
		return ticket;
	}
}
