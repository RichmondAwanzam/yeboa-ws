package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="users")
public  class User extends AuditedObject implements Serializable{

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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<CampaignDonations> donations = new ArrayList<>();
	
	@ManyToMany(mappedBy="followers")
	public List<Campaign> followingCamapigns = new ArrayList<>();
	
	@ManyToMany(mappedBy="doctorsEndorsed")
	public List<Campaign> endorsedCampaigns = new ArrayList<>();
	public List<CampaignDonations> getDonations() {
		return donations;
	}
	public void setDonations(List<CampaignDonations> donations) {
		this.donations = donations;
	}
	public List<Campaign> getFollowingCamapigns() {
		return followingCamapigns;
	}
	public void setFollowingCamapigns(List<Campaign> followingCamapigns) {
		this.followingCamapigns = followingCamapigns;
	}
	public List<Campaign> getEndorsedCampaigns() {
		return endorsedCampaigns;
	}
	public void setEndorsedCampaigns(List<Campaign> endorsedCampaigns) {
		this.endorsedCampaigns = endorsedCampaigns;
	}
	
	
}
