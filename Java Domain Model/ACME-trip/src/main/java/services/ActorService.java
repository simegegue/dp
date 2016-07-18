package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import security.UserAccount;
import security.UserAccountService;
import domain.Actor;

import repositories.ActorRepository;

@Service
@Transactional
public class ActorService {

		//Managed Repository---------------------------------------------------
		@Autowired
		private ActorRepository actorRepository;
			
			
		//Supporting Services---------------------------------------------------
			
		@Autowired
		private UserAccountService userAccountService;
				
		//Constructors---------------------------------------------------------
			
		public ActorService(){
			super();
		}
			
		//Simple CRUD Methods---------------------------------------------------
			
		public Collection<Actor> findAll() {
			Collection<Actor> result;
			result = actorRepository.findAll();
			Assert.notNull(result);
			return result;
		}
			
		public Actor findOne(int actorId) {
			Assert.isTrue(actorId != 0);
			Actor result;
			result = actorRepository.findOne(actorId);
			Assert.notNull(result);
			return result;
		}
			
		public void save(Actor actor) {
			Assert.notNull(actor);
			actorRepository.save(actor);
		}
			
		public void delete(Actor actor) {
			Assert.notNull(actor);
			Assert.isTrue(actor.getId() != 0);
			Assert.isTrue(actorRepository.exists(actor.getId()));  
			actorRepository.delete(actor);
		}
			
		//Other business methods-------------------------------------------------
			
		public UserAccount findUserAccount(Actor actor) {
			Assert.notNull(actor);
			UserAccount result;
			result = userAccountService.findByActor(actor);
			return result;
		}
}
