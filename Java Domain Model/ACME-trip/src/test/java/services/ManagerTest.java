package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Administrator;
import domain.Manager;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ManagerTest extends AbstractTest{
	
	// Service under test
	
		@Autowired
		private ManagerService managerService;
		
	// Tests
		/*
		@Test
		public void create(){
			Manager manager1 = managerService.create();
			manager1.setName("Fran");
			manager1.getUserAccount().setUsername("managerTest");
			manager1.getUserAccount().setPassword("passTest");
			manager1.setPhone("+34 (1) 987876351");
			manager1.setSurnames("Perez Benitez");
			manager1.setEmail("perezManager@gmail.com");
			managerService.save(manager1);
		}
		*/
		@Test
		public void principalManager(){
			authenticate("manager");
			Manager result = managerService.findByPrincipal();
			System.out.println(result.getName());
			authenticate(null);
		}

}
