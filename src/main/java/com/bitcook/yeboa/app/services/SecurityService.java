package com.bitcook.yeboa.app.services;

import java.util.List;

import com.bitcook.yeboa.app.models.Security_Group;
import com.bitcook.yeboa.app.models.Security_LogonAudit;
import com.bitcook.yeboa.app.models.Security_Role;
import com.bitcook.yeboa.app.models.User;



public interface SecurityService {

	void saveUser(User user);
	
	boolean updateUser(User user);
	
	void deleteUser(User user);
	
	List<User> findAllUsers();
	
	User findUserById(Long id);
	

	
	void saveGroup(Security_Group group);
	
	boolean updateGroup(Security_Group group);
	
	void deleteGroup(Security_Group group);
	
	List<Security_Group> findAllGroups();
	
	Security_Group findGroupById(Long id);
	
	List<Security_Group> findAdminGroups();

	Security_Group findGroupByName(String name);

	User findUserByName(String name);
	
	void saveRole(Security_Role role);
	
	boolean updateRole(Security_Role role);
	
	void deleteRole(Security_Role role);
	
	List<Security_Role> findAllRoles();
	
	Security_Role findRoleById(Integer id);
	
	Security_Role findRoleByName(String name);

	void saveLoggedOnUser(Security_LogonAudit logonAudit);

	List<Security_LogonAudit> findAllLoggedOnUsers();

	Security_LogonAudit findLoggedOnUserById(Long id);

	Security_LogonAudit findLoggedOnUserByName(String username);

	Integer countAllLoggedOnUsers();
	
	
	void deleteUserGroupAssocationByUserId(Integer userId);

	List<Security_LogonAudit> findAllLoggedOnUsersPaginated(Integer offset, Integer numberToGet, String userNameToFilterBy);

	Integer countAllLoggedOnUsers(String userNameToSearchFor);
	
	public List<Security_Group> findGroupsByType(boolean sysGroup);
	
	void authenticate(String login, String password) throws Exception;
	
	
}
