package com.bitcook.yeboa.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="security_user_group_association")
@NamedQueries(value = {
		
		@NamedQuery(name = "findAllByUserId", query ="SELECT u from Security_UserGroupAssociation u where u.user.id=?1"),
		@NamedQuery(name = "securityUserGroupAssociation.findAccountManagerUsers", query ="SELECT s from Security_UserGroupAssociation s where s.group.role=?1")
})

public class Security_UserGroupAssociation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4350842778354041619L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="group_id", referencedColumnName="id")
	private Security_Group group;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;

//	Getters & Setters
	
	public String getGroupName() {
		
		if (group != null) {
			return group.getGroupName();
		} else {
			return "";
		}
	}
	
	public String getUsername() {
		
		if (user != null) {
			return user.getUsername();
		} else {
			return "";
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Security_Group getGroup() {
		return group;
	}

	public void setGroup(Security_Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Security_UserGroupAssociation other = (Security_UserGroupAssociation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
