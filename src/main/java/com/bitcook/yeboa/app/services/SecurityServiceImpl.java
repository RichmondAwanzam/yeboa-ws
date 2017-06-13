package com.bitcook.yeboa.app.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.dao.impl.RoleDaoImpl;
import com.bitcook.yeboa.app.dao.impl.SecurityGroupDAOImpl;
import com.bitcook.yeboa.app.dao.impl.SecurityLogonAuditDAOImpl;
import com.bitcook.yeboa.app.dao.impl.UserDaoImpl;
import com.bitcook.yeboa.app.dao.impl.UserGroupAssociationDaoImpl;
import com.bitcook.yeboa.app.models.Security_Group;
import com.bitcook.yeboa.app.models.Security_LogonAudit;
import com.bitcook.yeboa.app.models.Security_Role;
import com.bitcook.yeboa.app.models.Security_UserGroupAssociation;
import com.bitcook.yeboa.app.models.User;



public class SecurityServiceImpl implements Serializable,SecurityService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 760199157247124385L;
	
	@Autowired
	private SecurityGroupDAOImpl groupDao;
	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private RoleDaoImpl roleDao;
	@Autowired
	private SecurityLogonAuditDAOImpl logonAuditDao;
	
	@Autowired
	private UserGroupAssociationDaoImpl userGroupAssociationDao;
	
	@PersistenceContext(unitName="yeboaPersistence")
	protected EntityManager em;
	
	
	/*
	 * save logon user into db anytime a user logs in.
	 */
	@Override
	public void saveLoggedOnUser(Security_LogonAudit logonAudit) {
		
		logonAuditDao.save(logonAudit);
	}
	
	/*
	 * find all logins users in the system whose last login duration is less than a day
	 * 
	 */
	@Override
	public List<Security_LogonAudit> findAllLoggedOnUsers() {
		
		return logonAuditDao.findAll();
	}

	@Override
	public List<Security_LogonAudit> findAllLoggedOnUsersPaginated(Integer offset, Integer numberToGet, String userNameToFilterBy) {
		
	
		TypedQuery<Security_LogonAudit> loggedOnUserTypedQuery = em.createQuery(""
				+ "SELECT sl FROM Security_LogonAudit sl "
				+ "WHERE sl.userName LIKE '%" + (userNameToFilterBy == null ? "":userNameToFilterBy) + "%' "
				+ " ORDER BY sl.timeStamp DESC "
				, Security_LogonAudit.class);
		
		loggedOnUserTypedQuery.setFirstResult(offset);
		loggedOnUserTypedQuery.setMaxResults(numberToGet);
		
		List<Security_LogonAudit> loggedOnUsers = loggedOnUserTypedQuery.getResultList();
		
		return loggedOnUsers;
	}
	
	//returns a count for logon users
	@Override
	public Integer countAllLoggedOnUsers() {
		
		return logonAuditDao.countAll().intValue();
	}
	
	@Override
	public Integer countAllLoggedOnUsers(String userNameToSearchFor) {
		
		return logonAuditDao.countAllFiltered("Security_LogonAudit.countAllByUsername", userNameToSearchFor).intValue();
	}
	
	@Override
	public Security_LogonAudit findLoggedOnUserById(Long id) {
		
		return logonAuditDao.findById(id);
	}

	@Override
	public Security_LogonAudit findLoggedOnUserByName(String username) {
		
		return logonAuditDao.findSingle("Security_LogonAudit.findByUsername", username);
	}
	
	
	//save new user on registration
	@Override
	public void saveUser(User user) {
		
		userDao.save(user);
	}

	//save update user information
	@Override
	public boolean updateUser(User user) {
		
		return userDao.update(user);
	}

	//save delete user from db
	@Override
	public void deleteUser(User user) {
		
		userDao.delete(user);
	}

	//find all users in db
	@Override
	public List<User> findAllUsers() {
		
		return userDao.findAll();
	}
	
	
	@Override
	public List<User> findAllAccountManagersUsers() {
		Security_Role role = roleDao.findById(3);
		List<User> accountManagers = new ArrayList<>();
		List<Security_UserGroupAssociation> groupsAssocs = userGroupAssociationDao.findByNamedQuery("securityUserGroupAssociation.findAccountManagerUsers",role);
		
		for (Security_UserGroupAssociation sug:groupsAssocs) {
			accountManagers.add(sug.getUser());
		}
		return accountManagers;
	}

	//find user by id
	@Override
	public User findUserById(Long id) {
		
		return userDao.findById(id);
	}

	//find user by username
	@Override
	public User findUserByName(String name) {
		
		return userDao.findSingle("Security_User.findByUsername", name);
	}
	


	//save new user group
	@Override
	public void saveGroup(Security_Group group) {
		
		groupDao.save(group);
	}

	//update user group
	@Override
	public boolean updateGroup(Security_Group group) {
		
		return groupDao.update(group);
	}

	//delete user group
	@Override
	public void deleteGroup(Security_Group group) {
		
		groupDao.delete(group);
	}

	@Override
	public List<Security_Group> findAllGroups() {
		
		return groupDao.findAll();
	}

	@Override
	public Security_Group findGroupById(Long id) {
		
		return groupDao.findById(id);
	}

	@Override
	public List<Security_Group> findAdminGroups() {
		
		return groupDao.findByNamedQuery("Security_Group.findAllAdminGroups");
	}
	
	@Override
	public Security_Group findGroupByName(String name) {
		
		return groupDao.findSingle("Security_Group.findGroupByName",name);
	}
	
	@Override
	public List<Security_Group> getViewerGroups() {
		return groupDao.findByNamedQuery("Security_Group.findAllViewerGroups");
	}

	@Override
	public void saveRole(Security_Role role) {
		
		roleDao.save(role);
	}

	@Override
	public boolean updateRole(Security_Role role) {
		
		return roleDao.update(role);
	}

	@Override
	public void deleteRole(Security_Role role) {
		
		roleDao.delete(role);
	}

	@Override
	public List<Security_Role> findAllRoles() {
		
		return roleDao.findAll();
	}

	@Override
	public Security_Role findRoleById(Integer id) {
		
		return roleDao.findById(id);
	}

	@Override
	public Security_Role findRoleByName(String name) {
		
		return roleDao.findSingle("Security_Role.findRoleByName", name);
	}



	@Override
	public void deleteUserGroupAssocationByUserId(Integer userId) {
		List<Security_UserGroupAssociation> userGroupAssociations = userGroupAssociationDao.findByNamedQuery("findAllByUserId",userId);
		for(Security_UserGroupAssociation userGroupAssociation: userGroupAssociations) {
			userGroupAssociationDao.delete(userGroupAssociation);
		}
		
	}

	@Override
	public List<Security_Group> findGroupsByType(boolean sysGroup) {
		return groupDao.findByNamedQuery("Security_Group.findGroupByType", sysGroup);
	}

	
	
	
	
}
