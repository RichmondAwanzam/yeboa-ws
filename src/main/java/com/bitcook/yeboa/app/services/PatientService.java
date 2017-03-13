package com.bitcook.yeboa.app.services;

import java.util.List;

import com.bitcook.yeboa.app.models.Patient;

public interface PatientService {
	Patient createPatient(Patient patient);
	List<Patient> getPatients();
	Patient findPatientById(Long id);
	boolean deletePatient(Long id);
	boolean updatePatient(Patient patient);
}
