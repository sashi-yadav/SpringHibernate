package com.springexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

 @Id
 @Column(name="ID")
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private int id;
 
 @Column(name="NAME", nullable=false)
 private String name;
 
 @Column(name="EMAIL",nullable=false)
 private String email;

 @Column(name="IS_ACTIVE",nullable=false)
 private boolean is_active = true;
 
public boolean isIs_active() {
	return is_active;
}

public void setIs_active(boolean is_active) {
	this.is_active = is_active;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
 
}
