package com.bitcook.yeboa.app.services;

import java.util.List;

import com.bitcook.yeboa.app.models.PatientCondition;

public interface PatientConditionService {
	PatientCondition createPatientCondition(PatientCondition PatientCondition);
	List<PatientCondition> getPatientConditions();
	PatientCondition findPatientConditionById(Long id);
	boolean deletePatientCondition(Long id);
	boolean updatePatientCondition(PatientCondition PatientCondition);
}
