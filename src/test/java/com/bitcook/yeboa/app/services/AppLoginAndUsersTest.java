package com.bitcook.yeboa.app.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.dao.impl.RoleDaoImpl;
import com.bitcook.yeboa.app.dao.impl.SecurityGroupDAOImpl;
import com.bitcook.yeboa.app.dao.impl.SecurityLogonAuditDAOImpl;
import com.bitcook.yeboa.app.dao.impl.UserDaoImpl;
import com.bitcook.yeboa.app.dao.impl.UserGroupAssociationDaoImpl;

@RunWith(MockitoJUnitRunner.class)
public class AppLoginAndUsersTest {

	SecurityServiceImpl sut;//system under test
	
	@Mock
	@Autowired
	private SecurityGroupDAOImpl groupDao;
	
	@Mock
	@Autowired
	private UserDaoImpl userDao;
	
	@Mock
	@Autowired
	private RoleDaoImpl roleDao;
	
	@Mock
	@Autowired
	private SecurityLogonAuditDAOImpl logonAuditDao;
	
	@Mock
	@Autowired
	private UserGroupAssociationDaoImpl userGroupAssociationDao;
	
	@Before
	public void setUp() throws Exception {		
		
	}
	@Test
	public void userShouldLogin(){
		
	}
	
	@Test
	public void userShouldNOtLogin(){
		
	}
}
