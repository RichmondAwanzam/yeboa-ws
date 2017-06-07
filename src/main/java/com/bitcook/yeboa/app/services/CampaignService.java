package com.bitcook.yeboa.app.services;

import java.util.List;

import com.bitcook.yeboa.app.models.Campaign;
import com.bitcook.yeboa.app.models.CampaignComments;
import com.bitcook.yeboa.app.models.CampaignMedia;

public interface CampaignService {

	Campaign createCampaign(Campaign campaign);
	CampaignMedia createMedia(CampaignMedia medias);
	List<Campaign> getCampaigns();
	Campaign findCampaignById(Long id);
	boolean deleteCampaign(Long id);
	boolean updateCampaign(Campaign campaign);
	List<CampaignMedia> getCampaignMedias(Campaign camp);
	
	//get comments
	List<CampaignComments> getComments();
	CampaignComments saveComment(CampaignComments comment);
}
