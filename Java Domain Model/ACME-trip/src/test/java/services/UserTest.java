package services;

import java.util.ArrayList;
import java.util.Collection;

import utilities.AbstractTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Folder;
import domain.Message;
import domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserTest extends AbstractTest{

	// Service under test
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FolderService folderService;
	// Tests

	@Test
	public void create(){
		User user1 = userService.create();
		user1.setName("Federico");
		user1.getUserAccount().setUsername("userTest");
		user1.getUserAccount().setPassword("passTest");
		user1.setPhone("+34 (1) 987476351");
		user1.setSurnames("Rios Vazquez");
		user1.setEmail("rivafed@gmail.com");
		userService.save(user1);
		User u2 = userService.findOne(32769);
		for(Folder f:u2.getFolders()){
			System.out.println(f.getName());
		}
		
	}
/*	
	@Test
	public void findOne(){
		int userId = 11;
		User user = userService.findOne(userId);
		System.out.println(user.getName());
	}
	
	@Test
	public void editUser(){
		int userId = 11;
		User user = userService.findOne(userId);
		user.setName("nombreModificado");
		userService.edit(user);
		User user2 = userService.findOne(user.getId());
		System.out.println(user2.getName());
	}
	
	@Test
	public void deleteUser(){
		int userId = 11;
		User user = userService.findOne(userId);
		userService.delete(user);
		
		
	}
	
	@Test
	public void userPrincipal(){
		authenticate("user3");
		User user = userService.findByPrincipal();
		System.out.println(user.getName());
		authenticate(null);
	}
	
	@Test
	public void findAllUsers(){
		Collection<User> result;
		result = userService.findAll();
		for(User aux:result){
		System.out.println(aux.getName() + " "  + aux.getSurnames());
		}
	}
	
	*/
}
