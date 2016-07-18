package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Folder;
import domain.User;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class FolderTest extends AbstractTest{
	
	// Service under test
	
			@Autowired
			private FolderService folderService;
			
			@Autowired
			private UserService userService;
			
	// Tests
	/*		
			@Test
			public void create(){
				Folder folder = folderService.create();
				folder.setName("folderTest");
				folder.setDescription("Carpeta de test");
				
				int userId = 11;
				User user = userService.findOne(userId);
				
				folder.setUser(user);
				folderService.save(folder);
			}

			@Test
			public void createFolders(){
				User user = userService.findOne(9);
				Collection<Folder> f = folderService.createFolders(user);
				for(Folder a:f){
					folderService.save(a);
				}
				for(Folder d:user.getFolders()){
					f.add(d);
				}
				user.setFolders(f);
				userService.save(user);

			}
			
			
			@Test
			public void inFolder(){
				User user = userService.findOne(9);
				Folder folder = folderService.inFolder(user);
				System.out.println(folder.getName());
			}
			*/
			
			@Test
			public void outFolder(){
				User user = userService.findOne(10);
				Folder folder = folderService.outFolder(user);
				System.out.println(folder.getName());
			}
}
