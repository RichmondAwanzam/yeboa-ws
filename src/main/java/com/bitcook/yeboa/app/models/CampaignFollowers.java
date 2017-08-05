package com.bitcook.yeboa.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



public class CampaignFollowers {


	@Id
	private Integer campaignId;
	
	@Id
	private Integer followerId;
	
	@JoinColumn(name = "campaign_id")
	@PrimaryKeyJoinColumn(name ="campaign_id", referencedColumnName ="id")
	private Campaign campaign;
	
	@JoinColumn(name="follower_id")
	@PrimaryKeyJoinColumn(name ="follower_id", referencedColumnName ="id")
	private User follower;

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

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User followers) {
		this.follower= followers;
	}

	
	
}
