package com.bitcook.yeboa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcook.yeboa.app.dao.impl.PatientConditionDAOImpl;
import com.bitcook.yeboa.app.models.PatientCondition;

public class PatientConditionServiceImpl implements PatientConditionService {

	@Autowired
	private PatientConditionDAOImpl patientConditionDao;
	
	@Override
	@Transactional("transactionManager")
	public PatientCondition createPatientCondition(PatientCondition PatientCondition) {
		
		return patientConditionDao.save(PatientCondition);
	}

	@Override
	public List<PatientCondition> getPatientConditions() {
		return patientConditionDao.findAll();
	}

	@Override
	public PatientCondition findPatientConditionById(Long id) {
		return patientConditionDao.findById(id);
	}

	@Override
	@Transactional("transactionManager")
	public boolean deletePatientCondition(Long id) {
		return patientConditionDao.delete(patientConditionDao.findById(id));
	}

	@Override
	@Transactional("transactionManager")
	public boolean updatePatientCondition(PatientCondition PatientCondition) {
		return patientConditionDao.update(PatientCondition);
	}

	public void setPatientConditionDao(PatientConditionDAOImpl PatientConditionDao) {
		this.patientConditionDao = PatientConditionDao;
	}

}
