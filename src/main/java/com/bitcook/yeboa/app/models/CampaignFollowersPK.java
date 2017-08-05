package com.bitcook.yeboa.app.models;

import java.io.Serializable;

public class CampaignFollowersPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer campaignId;
	private Integer followerId;
	
	
	
	public Integer getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	public Integer getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
