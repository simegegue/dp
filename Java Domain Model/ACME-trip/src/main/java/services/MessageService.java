package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrator;
import domain.Manager;
import domain.Message;
import domain.User;

import repositories.MessageRepository;

@Service
@Transactional
public class MessageService {
	
	// Managed Repository----------------------------------------------------
			@Autowired
			private MessageRepository messageRepository;
			
	// Supporting Services---------------------------------------------------
			@Autowired
			private UserService userService;
			
			@Autowired
			private AdministratorService administratorService;
			
			@Autowired
			private ManagerService managerService;
	// Constructors----------------------------------------------------------
			public MessageService(){
				super();
			}
		
	// Simple CRUD Methods---------------------------------------------------
			public Message findOne(int messageId){
				Assert.isTrue(messageId != 0);
				Message result;
				result = messageRepository.findOne(messageId);
				Assert.notNull(result);
				return result;
			}
			
			public void save(Message message){
				Assert.notNull(message);
				messageRepository.saveAndFlush(message);
			}
			
			public void edit(Message message){
				Assert.notNull(message);
				
//				User user = userService.findByPrincipal();
//				Administrator administrator= administratorService.findByPrincipal();
//				Manager manager = managerService.findByPrincipal();
				
//				Assert.isTrue(message.getRecipientUser().equals(user)||message.getSenderUser().equals(user)
//						||message.getRecipientAdministrator().equals(administrator)||message.getSenderAdministrator().equals(administrator)
//						||message.getRecipientManager().equals(manager)||message.getSenderManager().equals(manager));
				
				messageRepository.saveAndFlush(message);
			}
			
			public void delete(int messageId){
				Assert.isTrue(messageId != 0);
				Message result = findOne(messageId);
//				User user = userService.findByPrincipal();
//				Administrator administrator= administratorService.findByPrincipal();
//				Manager manager = managerService.findByPrincipal();
//				
//				Assert.isTrue(result.getRecipientUser().equals(user)||result.getSenderUser().equals(user)
//						||result.getRecipientAdministrator().equals(administrator)||result.getSenderAdministrator().equals(administrator)
//						||result.getRecipientManager().equals(manager)||result.getSenderManager().equals(manager));
				
				messageRepository.delete(messageId);
			}
			
			public Message create(){
				Message result = new Message();
				return result;
			}
			
			

}
