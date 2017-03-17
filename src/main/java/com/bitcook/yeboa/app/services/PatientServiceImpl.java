package com.bitcook.yeboa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcook.yeboa.app.dao.impl.PatientDAOImpl;
import com.bitcook.yeboa.app.models.Patient;

public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAOImpl patientDao;
	
	@Override
	@Transactional("transactionManager")
	public Patient createPatient(Patient patient) {
		
		return patientDao.save(patient);
	}

	@Override
	public List<Patient> getPatients() {
		return patientDao.findAll();
	}

	@Override
	public Patient findPatientById(Long id) {
		return patientDao.findById(id);
	}

	@Override
	@Transactional("transactionManager")
	public boolean deletePatient(Long id) {
		return patientDao.delete(patientDao.findById(id));
	}

	@Override
	@Transactional("transactionManager")
	public boolean updatePatient(Patient patient) {
		return patientDao.update(patient);
	}

	public void setPatientDao(PatientDAOImpl patientDao) {
		this.patientDao = patientDao;
	}

}
