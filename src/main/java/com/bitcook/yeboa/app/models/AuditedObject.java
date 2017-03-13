package com.bitcook.yeboa.app.models;
import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: AuditedObject
 *
 */

public class AuditedObject implements Serializable {
	

	@Column(name="created_by")
	protected String createdBy;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	
	
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedDate;
	
	@Column(name="updated_by")
	protected String updatedBy;
	
	private static final long serialVersionUID = 1L;

	public AuditedObject() {
		
	}   
	
	

	  public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	@PrePersist
	  public void create() {
//		UserBean userBean = new UserBean();
//		if(userBean.getUserDetails() != null) {
//			setCreatedBy(userBean.getUserDetails().getUsername());
//		} else {
//			setCreatedBy("SYSTEM");
//		}
//		
	  
	  }
	  
	  @PreUpdate
	  public void update() {
//		  UserBean userBean = new UserBean();
//		  if(userBean.getUserDetails() != null) {
//			  setUpdatedBy(userBean.getUserDetails().getUsername());
//		  } else {
//			  setUpdatedBy("SYSTEM");
//		  }
		  
		  setUpdatedDate(new Date());
	  }
   
}
