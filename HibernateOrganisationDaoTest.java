package com.naikvarun.mykanban.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.naikvarun.mykanban.entity.Organisation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-dao.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class HibernateOrganisationDaoTest {

	@Autowired
	private OrganisationDao organisationDao;

	public OrganisationDao getOrganisationDao() {
		return organisationDao;
	}

	public void setOrganisationDao(OrganisationDao organisationDao) {
		this.organisationDao = organisationDao;
	}
	
	@Test
	public void getOrganisationByName_Org1_valid() {
		Organisation organisation = organisationDao.getOrganisationByName("Org1");
		
		//Test
		assertNotNull(organisation);
		//Assert Nothing has changed.
		assertEquals(1, organisation.getId());
		assertEquals("Org1", organisation.getName());
		
	}
}
