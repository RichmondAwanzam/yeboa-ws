package com.bitcook.yeboa.app.services;

import java.util.List;

import com.bitcook.yeboa.app.models.Campaign;

public interface CampaignService {

	Campaign createCampaign(Campaign campaign);
	List<Campaign> getCampaigns();
	Campaign findCampaignById(Long id);
	boolean deleteCampaign(Long id);
	boolean updateCampaign(Campaign campaign);
}
