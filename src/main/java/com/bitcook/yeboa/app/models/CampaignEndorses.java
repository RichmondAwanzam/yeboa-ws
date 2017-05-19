package com.bitcook.yeboa.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



public class CampaignEndorses{

	@Id
	private Integer campaignId;
	
	@Id
	private Integer doctorId;
	
	@JoinColumn(name = "campaign_id")
	@PrimaryKeyJoinColumn(name ="campaign_id", referencedColumnName ="id")
	private Campaign campaign;
	
	@JoinColumn(name="doctor_id")
	@PrimaryKeyJoinColumn(name ="doctor_id", referencedColumnName ="id")
	private User doctors;

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public User getDoctors() {
		return doctors;
	}

	public void setDoctors(User doctors) {
		this.doctors = doctors;
	}
	
}
