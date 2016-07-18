package services;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Message;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class MessageTest extends AbstractTest{
	
	// Service under test
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FolderService folderService;
	
	// Tests
	
	@Test
	public void findMessage(){
		int idMessage = 50;
		Message result = messageService.findOne(idMessage);
		System.out.println(result.getBody());
	}
	/*
	@Test
	public void createMessage(){
		Message result = messageService.create();
		result.setSubject("Mensaje Test");
		result.setBody("Esto es un mensaje de prueba");
		Date d = new Date();
		d.setTime(d.getTime()+100000);
		result.setMoment(d);
		result.setPriority("low");
		result.setStarred("false");
		result.setTrash("false");
		result.setSpam("false");
		result.setSenderUser(userService.findOne(10));
		result.setRecipientUser(userService.findOne(11));
		result.setFolder(folderService.findOne(22));
		messageService.save(result);
	}
	
	@Test
	public void editMessage(){
		authenticate("user4");
		Message result = messageService.findOne(50);
		result.setBody("Cuerpo del mensaje modificado correctamente");
		messageService.edit(result);
		authenticate(null);
	}
	
	@Test
	public void deleteMessage(){
		authenticate("manager");
		messageService.delete(52);
		authenticate(null);
	}
*/

}
