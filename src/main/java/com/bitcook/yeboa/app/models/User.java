package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bitcook.yeboa.app.utils.PasswordUtils;

@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name=User.FIND_BY_LOGIN_PASSWORD,query="SELECT u FROM User u WHERE u.username = :login AND u.passwordHash = :password")
})
public  class User extends AuditedObject implements Serializable{
	public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";
	public enum UserType{
		USER("user"),DOCTOR("doctor");
			private String description;
			
			private UserType(String description) {
				this.description = description;
			}

			public String getDescription() {
				return description;
			}
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name")
	private String firstname="";
	
	@Column(name="last_name")
	private String lastname="";
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Transient
	private String fullname="";
	
	@Column(name="password")
	private String passwordHash;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="password_status")
	private String passwordStatus;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade=CascadeType.ALL)
	private List<CampaignDonations> donations = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade=CascadeType.ALL)
	private List<CampaignComments> comments = new ArrayList<>();
	
	@ManyToMany(mappedBy="followers",cascade=CascadeType.ALL)
	public List<Campaign> followingCamapigns = new ArrayList<>();
	
	@ManyToMany(mappedBy="doctorsEndorsed",cascade=CascadeType.ALL)
	public List<Campaign> endorsedCampaigns = new ArrayList<>();
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, targetEntity=Security_UserGroupAssociation.class, fetch=FetchType.LAZY)
	private List<Security_UserGroupAssociation> userGroupAssociations;
	
	
	
	@PrePersist
	private void setup(){
		this.setCreatedDate(new Date());
		this.setPasswordHash(PasswordUtils.digestPassword(this.getPasswordHash()));
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
	public String getFullname() {
		return this.firstname+" "+this.lastname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	

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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPasswordStatus() {
		return passwordStatus;
	}
	public void setPasswordStatus(String passwordStatus) {
		this.passwordStatus = passwordStatus;
	}
	public List<CampaignComments> getComments() {
		return comments;
	}
	public void setComments(List<CampaignComments> comments) {
		this.comments = comments;
	}
	public List<Security_UserGroupAssociation> getUserGroupAssociations() {
		return userGroupAssociations;
	}
	public void setUserGroupAssociations(List<Security_UserGroupAssociation> userGroupAssociations) {
		this.userGroupAssociations = userGroupAssociations;
	}
	
	
}
