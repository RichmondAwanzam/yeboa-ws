package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="security_groups")
@NamedQueries({
	@NamedQuery(name="Security_Group.findAllAdminGroups", query="SELECT grp FROM Security_Group grp WHERE grp.role.roleName='ADMIN'"),
	@NamedQuery(name="Security_Group.findAllViewerGroups", query="SELECT grp FROM Security_Group grp WHERE grp.role.roleName='VIEWER'"),
	@NamedQuery(name="Security_Group.findGroupByName", query="SELECT grp FROM Security_Group grp WHERE grp.groupName=?1"),
	@NamedQuery(name="Security_Group.findGroupByType", query="SELECT grp FROM Security_Group grp WHERE grp.sysGroup=?1")
})
public class Security_Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6346410420584085673L;
	
	public static String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name ="description" )
	private String description;
	
	@Column(name="sys_group")
	private boolean sysGroup;
	
	@OneToOne
	@JoinColumn(name="role", referencedColumnName="id")
	private Security_Role role;
	
	@OneToMany(mappedBy="group", cascade=CascadeType.ALL, targetEntity=Security_UserGroupAssociation.class, fetch=FetchType.LAZY)
	private List<Security_UserGroupAssociation> userGroupAssociations;
	

//	Getters & Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Security_Role getRole() {
		return role;
	}

	public void setRole(Security_Role role) {
		this.role = role;
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
		Security_Group other = (Security_Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isSysGroup() {
		return sysGroup;
	}

	public void setSysGroup(boolean sysGroup) {
		this.sysGroup = sysGroup;
	}

	public List<Security_UserGroupAssociation> getUserGroupAssociations() {
		return userGroupAssociations;
	}

	public void setUserGroupAssociations(
			List<Security_UserGroupAssociation> userGroupAssociations) {
		this.userGroupAssociations = userGroupAssociations;
	}
	
	
	
	
}
