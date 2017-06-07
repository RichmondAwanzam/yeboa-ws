package com.bitcook.yeboa.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="security_roles")
@NamedQueries({
	@NamedQuery(name="Security_Role.findAdminRole", query="SELECT sr FROM Security_Role sr WHERE sr.roleName='ADMIN'"),
	@NamedQuery(name="Security_Role.findViewerRole", query="SELECT sr FROM Security_Role sr WHERE sr.roleName='VIEWER'"),
	@NamedQuery(name="Security_Role.findRoleByName", query="SELECT sr FROM Security_Role sr WHERE sr.roleName=?1")
})
public class Security_Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1039595751260832583L;
	
	private static String ROLE_ADMIN = "ADMIN";
	private static String ROLE_VIEWER ="VIEWER";

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String roleName;
	
	private String description;

//	Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isAdmin() {
		return this.roleName.equals(ROLE_ADMIN);
	}
	
	public boolean isViewer() {
		return this.roleName.equals(ROLE_VIEWER);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Security_Role other = (Security_Role) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
