package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bitcook.yeboa.app.helpers.DateISO8601Adapter;

@XmlRootElement
@Entity
@Table(name = "patients")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstname = "";
	@Column(name = "last_name")
	private String lastname = "";

	
	@Column(name = "name")
	private String name = "";

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;


	@Column(name = "city")
	private String city;

	@Column(name = "primary_phone")
	private String primaryPhone;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "status")
	private String status;

	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "social_security_number")
	private String socialSecurityNumber;
	
	@Column(name = "nationality")
	private String nationality;
	


	@Column(name = "cover_image_url")
	private String coverImageUrl;

	@Column(name = "created_by")
	private String createdBy = "";

	@Column(name = "updated_by")
	private String updatedBy = "";

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@XmlJavaTypeAdapter(DateISO8601Adapter.class)
	private Date createdDate;

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@XmlTransient
	@JsonIgnore
	@OneToMany(mappedBy = "patient", targetEntity = PatientCondition.class, fetch = FetchType.EAGER)
	private List<PatientCondition> conditions = new ArrayList<PatientCondition>();
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<PatientCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<PatientCondition> conditions) {
		this.conditions = conditions;
	}

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



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}
	
	
}
