package com.bitcook.yeboa.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient_needs")
public class Needs {
	public enum NeedsType{
		CASH
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="code")
	private String code="";
	@Column(name="description")
	private String description="";
	@Column(name="value")
	private int value;
	
	@ManyToOne
	@JoinColumn(name="condition_id", referencedColumnName="id")
	private PatientCondition condition;

	@Column(name="need_type")
	private NeedsType needType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public NeedsType getNeedType() {
		return needType;
	}

	public void setNeedType(NeedsType needType) {
		this.needType = needType;
	}
	
	
	
	
}
