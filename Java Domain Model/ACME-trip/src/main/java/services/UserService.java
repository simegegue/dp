package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Folder;
import domain.Message;
import domain.Subscription;
import domain.Trip;
import domain.User;

import repositories.UserRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class UserService {

		// Managed Repository---------------------------------------------------
		@Autowired
		private UserRepository userRepository;

		// Supporting Services---------------------------------------------------
		@Autowired
		private FolderService folderService;
		
		@Autowired
		private TripService tripService;
		

		// Constructors---------------------------------------------------------
		public UserService() {
			super();
		}

		// Simple CRUD Methods---------------------------------------------------

		public User findOne(int userId) {
			Assert.isTrue(userId != 0);
			User result;
			result = userRepository.findOne(userId);
			Assert.notNull(result);
			return result;
		}

		public void save(User user) {
			Assert.notNull(user);
			UserAccount userAccount = user.getUserAccount();
			Md5PasswordEncoder encoder;
			String password = userAccount.getPassword();
			
			encoder= new Md5PasswordEncoder();
			password=encoder.encodePassword(password, null);
			userAccount.setPassword(password);
			userRepository.saveAndFlush(user);
		}
		
		public void edit(User user){
			Assert.notNull(user);
			userRepository.saveAndFlush(user);
		}

		public void delete(User user) {
			Assert.notNull(user);
			Assert.isTrue(user.getId() != 0);
			Assert.isTrue(userRepository.exists(user.getId()));
			/*Borramos sus trips*/
			for(Trip aux:user.getTrips()){
				tripService.delete(aux.getId());
			}
			/*Borramos sus folders*/
			for(Folder aux:user.getFolders()){
				folderService.delete(aux.getId());
			}
			
			userRepository.delete(user);
		}

		/*public User create() {
			User result = new User();
			
			UserAccount userAccount = new UserAccount();
			List<Authority> authorities = new ArrayList<Authority>();
			Authority a = new Authority();
			a.setAuthority(Authority.USER);
			authorities.add(a);
			userAccount.setAuthorities(authorities);

			result.setUserAccount(userAccount);

			Collection<Trip> trips = new ArrayList<Trip>();
			result.setTrips(trips);

			Collection<Subscription> subscriptions = new ArrayList<Subscription>();
			result.setSubscriptions(subscriptions);

			Collection<Activity> activities = new ArrayList<Activity>();
			result.setActivities(activities);
			


			Collection<Folder> folders = new ArrayList<Folder>();
			result.setFolders(folders);
			return result;
		}*/
		
		public User create() {
			User result = new User();
			
			UserAccount userAccount = new UserAccount();
			List<Authority> authorities = new ArrayList<Authority>();
			Authority a = new Authority();
			a.setAuthority(Authority.USER);
			authorities.add(a);
			userAccount.setAuthorities(authorities);

			result.setUserAccount(userAccount);

			Collection<Trip> trips = new ArrayList<Trip>();
			result.setTrips(trips);

			Collection<Subscription> subscriptions = new ArrayList<Subscription>();
			result.setSubscriptions(subscriptions);

			Collection<Activity> activities = new ArrayList<Activity>();
			result.setActivities(activities);
			

			Collection<Message> m1 = new ArrayList<Message>();

			Collection<Folder> folders = new ArrayList<Folder>();
			Folder folder1 = folderService.create();
			folder1.setName("IntFolder");
			folder1.setDescription("Carpeta de entrada");
			folder1.setMessages(m1);
			folder1.setUser(result);
			Folder folder2 = folderService.create();
			folder2.setName("OutFolder");
			folder2.setDescription("Carpeta de salida");
			folder2.setMessages(m1);
			folder2.setUser(result);
			Folder folder3 = folderService.create();
			folder3.setName("TrashtFolder");
			folder3.setDescription("Papelera");
			folder3.setMessages(m1);
			folder3.setUser(result);
			Folder folder4 = folderService.create();
			folder4.setName("StarredtFolder");
			folder4.setDescription("Carpeta de favoritos");
			folder4.setMessages(m1);
			folder4.setUser(result);
			Folder folder5 = folderService.create();
			folder5.setName("SpamtFolder");
			folder5.setDescription("Carpeta de spam");
			folder5.setMessages(m1);
			folder5.setUser(result);
			folders.add(folder1);
			folders.add(folder2);
			folders.add(folder3);
			folders.add(folder4);
			folders.add(folder5);
			result.setFolders(folders);
			
			return result;
		}

		// Other business methods -------------------------------------------------
		public User findByPrincipal() {
			User result;
			UserAccount userAccount;

			userAccount = LoginService.getPrincipal();
			Assert.notNull(userAccount);
			result = findByUserAccount(userAccount);
			Assert.notNull(result);

			return result;
		}

		public User findByUserAccount(UserAccount userAccount) {
			Assert.notNull(userAccount);

			User result;

			result = userRepository.findByUserAccountId(userAccount.getId());

			return result;
		}
		
		public Collection<User> findAll(){
			Collection<User> result;
			result = userRepository.findAll();
			return result;
		}
}
