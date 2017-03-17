package com.bitcook.yeboa.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "diagnoses", uniqueConstraints={
		@UniqueConstraint(columnNames = {"diagnosis_code"})
})
public class Diagnosis {


	@Id
	@Column(name = "diagnosis_code")
	private String diagnosisCode;
	
	@Column(name ="short_description")
	private String shortDescription;
	
	@Column(name ="long_description", length = 2048)
	private String longDescription;

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diagnosisCode == null) ? 0 : diagnosisCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diagnosis other = (Diagnosis) obj;
		if (diagnosisCode == null) {
			if (other.diagnosisCode != null)
				return false;
		} else if (!diagnosisCode.equals(other.diagnosisCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\"" + shortDescription + "-"+ diagnosisCode +"\"";
	}
	
	
}
