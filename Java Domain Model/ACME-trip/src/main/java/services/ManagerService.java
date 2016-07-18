package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Folder;
import domain.Manager;
import domain.Message;
import domain.User;

import repositories.ManagerRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class ManagerService {
	
	// Managed Repository----------------------------------------------------
			@Autowired
			private ManagerRepository managerRepository;
			
			@Autowired
			private FolderService folderService;
	
	// Supporting Services---------------------------------------------------
	// Constructors----------------------------------------------------------
			public ManagerService(){
				super();
			}
			
	// Simple CRUD Methods---------------------------------------------------
			public Manager findOne(int managerId){
				Assert.isTrue(managerId != 0);
				Manager result;
				result = managerRepository.findOne(managerId);
				Assert.notNull(result);
				return result;
			}
			
			public Collection<Manager> findAll(){
				Collection<Manager> result;
				Assert.notNull(managerRepository);
				result = managerRepository.findAll();
				Assert.notNull(result);
				return result;
			}
			
			public void save(Manager manager){
				Assert.notNull(manager);
				UserAccount userAccount = manager.getUserAccount();
				Md5PasswordEncoder encoder;
				String password = userAccount.getPassword();
				
				encoder= new Md5PasswordEncoder();
				password=encoder.encodePassword(password, null);
				userAccount.setPassword(password);
				managerRepository.saveAndFlush(manager);
			}
			
			public void edit(Manager manager){
				Assert.notNull(manager);
				managerRepository.saveAndFlush(manager);
			}
			
			public void delete(Manager manager){
				Assert.notNull(manager);
				Assert.isTrue(manager.getId() != 0);
				Assert.isTrue(managerRepository.exists(manager.getId()));
				managerRepository.delete(manager);
			}
			
			public Manager create(){
				Manager result = new Manager();
				
				UserAccount userAccount = new UserAccount();
				List<Authority> authorities = new ArrayList<Authority>();
				Authority a = new Authority();
				a.setAuthority(Authority.MANAGER);
				authorities.add(a);
				userAccount.setAuthorities(authorities);

				result.setUserAccount(userAccount);
				
				Collection<Message> m1 = new ArrayList<Message>();
				
				Collection<Folder> folders = new ArrayList<Folder>();
				Folder folder1 = folderService.create();
				folder1.setName("In Folder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setMessages(m1);
				folder1.setManager(result);
				Folder folder2 = folderService.create();
				folder2.setName("Out Folder");
				folder2.setDescription("Carpeta de salida");
				folder2.setMessages(m1);
				folder2.setManager(result);
				Folder folder3 = folderService.create();
				folder3.setName("Trash Folder");
				folder3.setDescription("Papelera");
				folder3.setMessages(m1);
				folder3.setManager(result);
				Folder folder4 = folderService.create();
				folder4.setName("Starred Folder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setMessages(m1);
				folder4.setManager(result);
				Folder folder5 = folderService.create();
				folder5.setName("Spam Folder");
				folder5.setDescription("Carpeta de spam");
				folder5.setMessages(m1);
				folder5.setManager(result);
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				result.setFolders(folders);

				return result;
			}
			
			// Other business methods -------------------------------------------------
			public Manager findByPrincipal() {
				Manager result;
				UserAccount userAccount;

				userAccount = LoginService.getPrincipal();
				Assert.notNull(userAccount);
				result = findByUserAccount(userAccount);
				Assert.notNull(result);

				return result;
			}
			
			public Manager findByUserAccount(UserAccount userAccount) {
				Assert.notNull(userAccount);

				Manager result;

				result = managerRepository.findByUserAccountId(userAccount.getId());

				return result;
			}

}
