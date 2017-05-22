package com.bitcook.yeboa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcook.yeboa.app.dao.impl.CampaignDAOImpl;
import com.bitcook.yeboa.app.models.Campaign;

public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignDAOImpl campaignDao;
	
	
	@Override
	@Transactional("transactionManager")
	public Campaign createCampaign(Campaign campaign) {
		return campaignDao.save(campaign);
	}

	@Override
	@Transactional("transactionManager")
	public List<Campaign> getCampaigns() {
		return campaignDao.findAll();
	}

	@Override
	public Campaign findCampaignById(Long id) {
		return campaignDao.findById(id);
	}

	@Override
	@Transactional("transactionManager")
	public boolean deleteCampaign(Long id) {
		return campaignDao.delete(campaignDao.findById(id));
	}

	@Override
	@Transactional("transactionManager")
	public boolean updateCampaign(Campaign campaign) {
		return campaignDao.update(campaign);
	}
	
	public void setCampaignDao(CampaignDAOImpl campaignDao) {
		this.campaignDao = campaignDao;
	}

}
