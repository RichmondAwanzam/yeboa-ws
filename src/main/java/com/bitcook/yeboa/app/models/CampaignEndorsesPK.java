package com.bitcook.yeboa.app.models;

import java.io.Serializable;

public class CampaignEndorsesPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer campaignId;
	private Integer doctorId;
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
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	
}
