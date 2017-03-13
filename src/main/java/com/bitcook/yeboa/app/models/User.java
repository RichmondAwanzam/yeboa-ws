package com.bitcook.yeboa.app.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class User extends AuditedObject{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="first_name")
	private String firstname="";
	@Column(name="last_name")
	private String lastname="";
	
	private String fullname="";
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFullname() {
		return this.firstname+" "+this.lastname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
	
	
}
