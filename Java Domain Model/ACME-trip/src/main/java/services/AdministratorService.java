package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AdministratorRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Administrator;
import domain.Folder;
import domain.Message;
import domain.User;

@Service
@Transactional
public class AdministratorService {
	// Managed Repository----------------------------------------------------
	@Autowired
	private AdministratorRepository administratorRepository;
	// Supporting Services---------------------------------------------------
	@Autowired
	private FolderService folderService;
	// Constructors----------------------------------------------------------
	public AdministratorService(){
		super();
	}
	// Simple CRUD Methods---------------------------------------------------
	public Administrator findOne(int administratorId){
		Assert.isTrue(administratorId !=0);
		Administrator result;
		result=administratorRepository.findOne(administratorId);
		Assert.notNull(result);
		return result;
	}
	public Collection<Administrator>findAll(){
		Collection<Administrator> result;
		Assert.notNull(administratorRepository);
		result=administratorRepository.findAll();
		return result;
	}
	public void save(Administrator administrator){
		Assert.notNull(administrator);
		UserAccount userAccount=administrator.getUserAccount();
		Md5PasswordEncoder encoder;
		String password=userAccount.getPassword();
		
		encoder= new Md5PasswordEncoder();
		password=encoder.encodePassword(password, null);
		userAccount.setPassword(password);
		administratorRepository.saveAndFlush(administrator);
		}
	public void edit(Administrator administrator){
		Assert.notNull(administrator);
		administratorRepository.saveAndFlush(administrator);
		}
	public void delete(Administrator administrator){
		Assert.notNull(administrator);
		Assert.isTrue(administrator.getId() !=0);
		Assert.isTrue(administratorRepository.exists(administrator.getId()));
		administratorRepository.delete(administrator);
	}
	public Administrator create(){
		Administrator result = new Administrator();
		
		UserAccount userAccount = new UserAccount();
		List<Authority> authorities = new ArrayList<Authority>();
		Authority a = new Authority();
		a.setAuthority(Authority.ADMINISTRATOR);
		authorities.add(a);
		userAccount.setAuthorities(authorities);

		result.setUserAccount(userAccount);
		
		Collection<Message> m1 = new ArrayList<Message>();
		
		Collection<Folder> folders = new ArrayList<Folder>();
		Folder folder1 = folderService.create();
		folder1.setName("In Folder");
		folder1.setDescription("Carpeta de entrada");
		folder1.setMessages(m1);
		folder1.setAdministrator(result);
		Folder folder2 = folderService.create();
		folder2.setName("Out Folder");
		folder2.setDescription("Carpeta de salida");
		folder2.setMessages(m1);
		folder2.setAdministrator(result);
		Folder folder3 = folderService.create();
		folder3.setName("Trash Folder");
		folder3.setDescription("Papelera");
		folder3.setMessages(m1);
		folder3.setAdministrator(result);
		Folder folder4 = folderService.create();
		folder4.setName("Starred Folder");
		folder4.setDescription("Carpeta de favoritos");
		folder4.setMessages(m1);
		folder4.setAdministrator(result);
		Folder folder5 = folderService.create();
		folder5.setName("Spam Folder");
		folder5.setDescription("Carpeta de spam");
		folder5.setMessages(m1);
		folder5.setAdministrator(result);
		folders.add(folder1);
		folders.add(folder2);
		folders.add(folder3);
		folders.add(folder4);
		folders.add(folder5);
		result.setFolders(folders);

		return result;
	}
	
	// Other business methods -------------------------------------------------
	public Administrator findByPrincipal() {
		Administrator result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
	
	public Administrator findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Administrator result;

		result = administratorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}
}
