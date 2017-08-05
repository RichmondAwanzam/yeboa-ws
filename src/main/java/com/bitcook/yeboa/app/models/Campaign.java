package com.bitcook.yeboa.app.models;

import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bitcook.yeboa.app.helpers.DateISO8601Adapter;

@Entity
@Table(name="campaigns")
public class Campaign {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title = "";
	
	//enter patient name as appear on health documents
	@Column(name = "patient_name")
	private String patientName = "";
	
	@Column(name = "description")
	private String description = "";

	@Column(name = "target")
	private BigDecimal target;
	
	@Column(name = "patient_condition")
	private String condition;
	
	@Column(name = "diagnosis")
	private String diagnosis;
	
	@Column(name = "amount_donated")
	private BigDecimal amountDonated;
	
	@Column(name = "total_following")
	private int totalFollowing;
	
	@Column(name = "total_endorsed")
	private int totalEndorsed;
	
	@Column(name = "no_of_donors")
	private int numberOfDonors;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "status")
	private String status;
	

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
	@XmlJavaTypeAdapter(DateISO8601Adapter.class)
	private Date updateDate;

//	
//	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "campaign", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<CampaignDonations> donations = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "campaign", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<CampaignComments> comments = new ArrayList<>();
	
	
	
	@JsonIgnore
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name ="campaign_endorses", 
			joinColumns = {	@JoinColumn(name="campaign_id")},
			inverseJoinColumns = {@JoinColumn(name="doctor_id")}
	)
	private List<User> doctorsEndorsed = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name ="campaign_followers", 
			joinColumns = {	@JoinColumn(name="campaign_id")},
			inverseJoinColumns = {@JoinColumn(name="follower_id")}
	)
	private List<User> followers = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "campaign", targetEntity = CampaignMedia.class, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CampaignMedia> media = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getTarget() {
		return target;
	}
	public void setTarget(BigDecimal target) {
		this.target = target;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public BigDecimal getAmountDonated() {
		return amountDonated;
	}
	public void setAmountDonated(BigDecimal amountDonated) {
		this.amountDonated = amountDonated;
	}
	public int getTotalFollowing() {
		return totalFollowing;
	}
	public void setTotalFollowing(int totalFollowing) {
		this.totalFollowing = totalFollowing;
	}
	public int getTotalEndorsed() {
		return totalEndorsed;
	}
	public void setTotalEndorsed(int totalEndorsed) {
		this.totalEndorsed = totalEndorsed;
	}
	public int getNumberOfDonors() {
		return numberOfDonors;
	}
	public void setNumberOfDonors(int numberOfDonors) {
		this.numberOfDonors = numberOfDonors;
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
	public String getCoverImageUrl() {
		return coverImageUrl;
	}
	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
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

	public List<User> getDoctorsEndorsed() {
		return doctorsEndorsed;
	}
	public void setDoctorsEndorsed(List<User> doctorsEndorsed) {
		this.doctorsEndorsed = doctorsEndorsed;
	}
	public List<User> getFollowers() {
		return followers;
	}
	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	public List<CampaignMedia> getMedia() {
		return media;
	}
	public void setMedia(List<CampaignMedia> media) {
		this.media = media;
	}
	public List<CampaignDonations> getDonations() {
		return donations;
	}
	public void setDonations(List<CampaignDonations> donations) {
		this.donations = donations;
	}
	public List<CampaignComments> getComments() {
		return comments;
	}
	public void setComments(List<CampaignComments> comments) {
		this.comments = comments;
	}
}
