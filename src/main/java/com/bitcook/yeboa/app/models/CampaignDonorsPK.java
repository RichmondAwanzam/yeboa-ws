package com.bitcook.yeboa.app.models;

import java.io.Serializable;

public class CampaignDonorsPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer campaignId;
	
	private Integer donorId;

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Integer getDonorId() {
		return donorId;
	}

	public void setDonorId(Integer donorId) {
		this.donorId = donorId;
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
