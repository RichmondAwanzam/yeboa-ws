package com.bitcook.yeboa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.dao.impl.PatientDAOImpl;
import com.bitcook.yeboa.app.models.Patient;

public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAOImpl patientDao;
	
	@Override
	public Patient createPatient(Patient patient) {
		patientDao.save(patient);
		return patient;
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
	public boolean deletePatient(Long id) {
		return false;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		return false;
	}

	public void setPatientDao(PatientDAOImpl patientDao) {
		this.patientDao = patientDao;
	}

}
