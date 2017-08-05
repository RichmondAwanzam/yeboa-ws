package com.bitcook.yeboa.app.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.bitcook.yeboa.app.models.CampaignMedia;
import com.bitcook.yeboa.app.persistence.generic.GenericDAOImpl;

public class CampaignMediaDAOImpl extends GenericDAOImpl<CampaignMedia, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<CampaignMedia> findAll() {
	

	String sqlString = null;
	
		sqlString = "SELECT m FROM CampaignMedia m";
	 
	TypedQuery<CampaignMedia> query = em.createQuery(sqlString, CampaignMedia.class);		

	return query.getResultList();
	
}
}
