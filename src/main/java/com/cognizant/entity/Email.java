package com.cognizant.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table  (name = "employee_table")

public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="Email_To")
	private String email_to;

	public String getEmail_to() {
		return email_to;
	}
	public void setEmail_to(String email_to) {
		this.email_to = email_to;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String subject;

	@Transient
	private String body;
	
   
	LocalDate publicationDate;   
	
public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
	public LocalTime getPublicationTime() {
		return publicationTime;
	}
	public void setPublicationTime(LocalTime publicationTime) {
		this.publicationTime = publicationTime;
	}
   
	LocalTime publicationTime;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
