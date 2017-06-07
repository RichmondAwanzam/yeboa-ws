package com.bitcook.yeboa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcook.yeboa.app.dao.impl.CampaignDAOImpl;
import com.bitcook.yeboa.app.dao.impl.CampaignMediaDAOImpl;
import com.bitcook.yeboa.app.dao.impl.CommentsDAOimpl;
import com.bitcook.yeboa.app.models.Campaign;
import com.bitcook.yeboa.app.models.CampaignComments;
import com.bitcook.yeboa.app.models.CampaignMedia;

public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignDAOImpl campaignDao;
	
	@Autowired
	private CampaignMediaDAOImpl mediaDao;
	
	@Autowired
	private CommentsDAOimpl commentsDao;
	
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

	@Override
	@Transactional("transactionManager")
	public CampaignMedia createMedia(CampaignMedia medias) {
		return mediaDao.save(medias);
	}

	@Override
	public List<CampaignMedia> getCampaignMedias(Campaign camp){
		return mediaDao.findByNamedQuery("Media.campaignMedia", camp);
	}

	@Override
	public List<CampaignComments> getComments() {
		return commentsDao.findAll();
	}

	@Override
	@Transactional("transactionManager")
	public CampaignComments saveComment(CampaignComments comment) {
		return commentsDao.save(comment);
	}
}
