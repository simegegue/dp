package controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Folder;
import domain.Message;
import domain.User;

import services.FolderService;
import services.MessageService;
import services.UserService;

@Controller
@RequestMapping("/userFolder")
public class UserFolderController extends AbstractController{
	
	// Constructors -----------------------------------------------------------
			public UserFolderController(){
				super();
			}
			
	// Managed service --------------------------------------------------------
			@Autowired
			private FolderService folderService;
			
			@Autowired
			private UserService userService;
			
			
	// InFolder ---------------------------------------------------------------
			@RequestMapping(value = "/inFolder", method=RequestMethod.GET)
			public ModelAndView inFolder(){
				ModelAndView result;
				User user = userService.findByPrincipal();
				Collection<Message>	messages = new ArrayList<Message>();
				
				if(folderService.inFolder(user) == null){
				Collection<Message> m1 = new ArrayList<Message>();

				Collection<Folder> folders = new ArrayList<Folder>();
				
				Folder folder1 = folderService.create();
				folder1.setName("InFolder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setMessages(m1);
				folder1.setUser(user);
				Folder folder2 = folderService.create();
				folder2.setName("OutFolder");
				folder2.setDescription("Carpeta de salida");
				folder2.setMessages(m1);
				folder2.setUser(user);
				Folder folder3 = folderService.create();
				folder3.setName("TrashFolder");
				folder3.setDescription("Papelera");
				folder3.setMessages(m1);
				folder3.setUser(user);
				Folder folder4 = folderService.create();
				folder4.setName("StarredFolder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setMessages(m1);
				folder4.setUser(user);
				Folder folder5 = folderService.create();
				folder5.setName("SpamFolder");
				folder5.setDescription("Carpeta de spam");
				folder5.setMessages(m1);
				folder5.setUser(user);
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				folderService.save(folder1);
				folderService.save(folder2);
				folderService.save(folder3);
				folderService.save(folder4);
				folderService.save(folder5);
				user.setFolders(folders);
				}
				
				Folder folder = folderService.inFolder(user);
				messages = folder.getMessages();
//				if(folder.getMessages() != null){
//					messages = folder.getMessages();
//				}
				result = new ModelAndView("userFolder/inFolder");
				result.addObject("inFolder", messages);
				result.addObject("requestURI", "userFolder/inFolder.do");
				
				return result;
			}
	// ------------------------------------------------------------------------
			
	// OutFolder ---------------------------------------------------------------
			@RequestMapping(value = "/outFolder", method=RequestMethod.GET)
			public ModelAndView outFolder(){
				ModelAndView result;
				User user = userService.findByPrincipal();
				Collection<Message>	messages = new ArrayList<Message>();
				
				if(folderService.outFolder(user) == null){
				Collection<Message> m1 = new ArrayList<Message>();

				Collection<Folder> folders = new ArrayList<Folder>();
				
				Folder folder1 = folderService.create();
				folder1.setName("InFolder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setMessages(m1);
				folder1.setUser(user);
				Folder folder2 = folderService.create();
				folder2.setName("OutFolder");
				folder2.setDescription("Carpeta de salida");
				folder2.setMessages(m1);
				folder2.setUser(user);
				Folder folder3 = folderService.create();
				folder3.setName("TrashFolder");
				folder3.setDescription("Papelera");
				folder3.setMessages(m1);
				folder3.setUser(user);
				Folder folder4 = folderService.create();
				folder4.setName("StarredFolder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setMessages(m1);
				folder4.setUser(user);
				Folder folder5 = folderService.create();
				folder5.setName("SpamFolder");
				folder5.setDescription("Carpeta de spam");
				folder5.setMessages(m1);
				folder5.setUser(user);
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				folderService.save(folder1);
				folderService.save(folder2);
				folderService.save(folder3);
				folderService.save(folder4);
				folderService.save(folder5);
				user.setFolders(folders);
				}
				
				Folder folder = folderService.outFolder(user);
				messages = folder.getMessages();
				
				
				result = new ModelAndView("userFolder/outFolder");
				result.addObject("outFolder", messages);
				result.addObject("requestURI", "userFolder/outFolder.do");
				
				return result;
			}
	// ------------------------------------------------------------------------
			
	// TrashFolder ---------------------------------------------------------------
			@RequestMapping(value = "/trashFolder", method=RequestMethod.GET)
			public ModelAndView trashFolder(){
				ModelAndView result;
				User user = userService.findByPrincipal();
				Collection<Message>	messages = new ArrayList<Message>();
				
				if(folderService.trashFolder(user) == null){
				Collection<Message> m1 = new ArrayList<Message>();

				Collection<Folder> folders = new ArrayList<Folder>();
				
				Folder folder1 = folderService.create();
				folder1.setName("InFolder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setMessages(m1);
				folder1.setUser(user);
				Folder folder2 = folderService.create();
				folder2.setName("OutFolder");
				folder2.setDescription("Carpeta de salida");
				folder2.setMessages(m1);
				folder2.setUser(user);
				Folder folder3 = folderService.create();
				folder3.setName("TrashFolder");
				folder3.setDescription("Papelera");
				folder3.setMessages(m1);
				folder3.setUser(user);
				Folder folder4 = folderService.create();
				folder4.setName("StarredFolder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setMessages(m1);
				folder4.setUser(user);
				Folder folder5 = folderService.create();
				folder5.setName("SpamFolder");
				folder5.setDescription("Carpeta de spam");
				folder5.setMessages(m1);
				folder5.setUser(user);
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				folderService.save(folder1);
				folderService.save(folder2);
				folderService.save(folder3);
				folderService.save(folder4);
				folderService.save(folder5);
				user.setFolders(folders);
				}
				
				Folder folder = folderService.trashFolder(user);
				messages = folder.getMessages();
				
				
				result = new ModelAndView("userFolder/trashFolder");
				result.addObject("trashFolder", messages);
				result.addObject("requestURI", "userFolder/trashFolder.do");
				
				return result;
			}
	// ------------------------------------------------------------------------
			
	// StarredFolder ---------------------------------------------------------------
			@RequestMapping(value = "/starredFolder", method=RequestMethod.GET)
			public ModelAndView starredFolder(){
				ModelAndView result;
				User user = userService.findByPrincipal();
				Collection<Message>	messages = new ArrayList<Message>();
				
				if(folderService.starredFolder(user) == null){
				Collection<Message> m1 = new ArrayList<Message>();

				Collection<Folder> folders = new ArrayList<Folder>();
				
				Folder folder1 = folderService.create();
				folder1.setName("InFolder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setMessages(m1);
				folder1.setUser(user);
				Folder folder2 = folderService.create();
				folder2.setName("OutFolder");
				folder2.setDescription("Carpeta de salida");
				folder2.setMessages(m1);
				folder2.setUser(user);
				Folder folder3 = folderService.create();
				folder3.setName("TrashFolder");
				folder3.setDescription("Papelera");
				folder3.setMessages(m1);
				folder3.setUser(user);
				Folder folder4 = folderService.create();
				folder4.setName("StarredFolder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setMessages(m1);
				folder4.setUser(user);
				Folder folder5 = folderService.create();
				folder5.setName("SpamFolder");
				folder5.setDescription("Carpeta de spam");
				folder5.setMessages(m1);
				folder5.setUser(user);
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				folderService.save(folder1);
				folderService.save(folder2);
				folderService.save(folder3);
				folderService.save(folder4);
				folderService.save(folder5);
				user.setFolders(folders);
				}
				
				Folder folder = folderService.starredFolder(user);
				messages = folder.getMessages();
				
				
				result = new ModelAndView("userFolder/starredFolder");
				result.addObject("starredFolder", messages);
				result.addObject("requestURI", "userFolder/starredFolder.do");
				
				return result;
			}
	// ------------------------------------------------------------------------
			
	// SpamFolder ---------------------------------------------------------------
			@RequestMapping(value = "/spamFolder", method=RequestMethod.GET)
			public ModelAndView spamFolder(){
				ModelAndView result;
				User user = userService.findByPrincipal();
				Collection<Message>	messages = new ArrayList<Message>();
				
				if(folderService.spamFolder(user) == null){
				Collection<Message> m1 = new ArrayList<Message>();

				Collection<Folder> folders = new ArrayList<Folder>();
				
				Folder folder1 = folderService.create();
				folder1.setName("InFolder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setMessages(m1);
				folder1.setUser(user);
				Folder folder2 = folderService.create();
				folder2.setName("OutFolder");
				folder2.setDescription("Carpeta de salida");
				folder2.setMessages(m1);
				folder2.setUser(user);
				Folder folder3 = folderService.create();
				folder3.setName("TrashFolder");
				folder3.setDescription("Papelera");
				folder3.setMessages(m1);
				folder3.setUser(user);
				Folder folder4 = folderService.create();
				folder4.setName("StarredFolder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setMessages(m1);
				folder4.setUser(user);
				Folder folder5 = folderService.create();
				folder5.setName("SpamFolder");
				folder5.setDescription("Carpeta de spam");
				folder5.setMessages(m1);
				folder5.setUser(user);
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				folderService.save(folder1);
				folderService.save(folder2);
				folderService.save(folder3);
				folderService.save(folder4);
				folderService.save(folder5);
				user.setFolders(folders);
				}
				
				Folder folder = folderService.spamFolder(user);
				messages = folder.getMessages();
				
				
				result = new ModelAndView("userFolder/spamFolder");
				result.addObject("spamFolder", messages);
				result.addObject("requestURI", "userFolder/spamFolder.do");
				
				return result;
			}
	// ------------------------------------------------------------------------
			
	// MyFolders ---------------------------------------------------------------
			@RequestMapping("/myFolder")
			public ModelAndView myFolder(){
				ModelAndView result;
				
				result = new ModelAndView("userFolder/myFolder");
				
				return result;
			}
	// ------------------------------------------------------------------------
			
	

}
