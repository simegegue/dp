package services;

import utilities.AbstractTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import domain.Administrator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class AdministratorTest extends AbstractTest{
	// Service under test
	@Autowired
	private AdministratorService administratorService;
	//Tests
	/*
	@Test
	public void create(){
		Administrator administrator1=administratorService.create();
		administrator1.setName("Dante");
		administrator1.getUserAccount().setUsername("adminTest");
		administrator1.getUserAccount().setPassword("passTest");
		administrator1.setPhone("+34 (12) 967545333");
		administrator1.setSurnames("Torres Ballesteros");
		administrator1.setEmail("danteTorres@gmail.com");
		administratorService.save(administrator1);
		
	}
	
	@Test
	public void findAdministrator(){
		Administrator result = administratorService.findOne(7);
		System.out.println(result.getName());
	}
	*/
	@Test
	public void principalAdmin(){
		authenticate("administrator");
		Administrator result = administratorService.findByPrincipal();
		System.out.println(result.getName());
		authenticate(null);
	}
	

}
