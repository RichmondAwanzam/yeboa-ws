package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "security_logon_audit")
@NamedQueries({
	@NamedQuery(name="Security_LogonAudit.findByUsername", query="SELECT sl FROM Security_LogonAudit sl WHERE sl.userName=?1"),
	@NamedQuery(name="Security_LogonAudit.countAllByUsername", query="SELECT COUNT(sl) FROM Security_LogonAudit sl WHERE sl.userName LIKE ?1")
})
public class Security_LogonAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5172939528500122614L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String userName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_stamp")
	private Date timeStamp;

	@Column(name="ip_address")
	private String ipAddress;
	
//	Getters & Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id.intValue();
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
		Security_LogonAudit other = (Security_LogonAudit) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
