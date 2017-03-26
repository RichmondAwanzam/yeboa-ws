package com.bitcook.yeboa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcook.yeboa.app.dao.impl.DiagnosisDAOImpl;
import com.bitcook.yeboa.app.models.Diagnosis;

public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisDAOImpl DiagnosisDao;
	
	@Override
	@Transactional("transactionManager")
	public Diagnosis createDiagnosis(Diagnosis Diagnosis) {
		
		return DiagnosisDao.save(Diagnosis);
	}

	@Override
	public List<Diagnosis> getDiagnosis() {
		return DiagnosisDao.findAll();
	}

	@Override
	public Diagnosis findDiagnosisById(String diagnosisCode) {
		return DiagnosisDao.findById(diagnosisCode);
	}

	@Override
	@Transactional("transactionManager")
	public boolean deleteDiagnosis(String diagnosisCode) {
		return DiagnosisDao.delete(DiagnosisDao.findById(diagnosisCode));
	}

	@Override
	@Transactional("transactionManager")
	public boolean updateDiagnosis(Diagnosis Diagnosis) {
		return DiagnosisDao.update(Diagnosis);
	}

	public void setDiagnosisDao(DiagnosisDAOImpl DiagnosisDao) {
		this.DiagnosisDao = DiagnosisDao;
	}

}
