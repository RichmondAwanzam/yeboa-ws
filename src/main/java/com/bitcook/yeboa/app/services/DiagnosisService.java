package com.bitcook.yeboa.app.services;

import java.util.List;

import com.bitcook.yeboa.app.models.Diagnosis;

public interface DiagnosisService {
	Diagnosis createDiagnosis(Diagnosis diagonosis);
	List<Diagnosis> getDiagnosis();
	Diagnosis findDiagnosisById(String diagnosisCode);
	boolean deleteDiagnosis(String diagnosisCode);
	boolean updateDiagnosis(Diagnosis diagnosis);
}
