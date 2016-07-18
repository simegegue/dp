package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;

@Service
@Transactional
public class UserAccountService {

	//Managed Repository---------------------------------------------------
	@Autowired
	private UserAccountRepository userAccountRepository;
		
	//Constructors---------------------------------------------------------
		
	public UserAccountService(){
		super();
	}
		
	//Simple CRUD Methods---------------------------------------------------
	public UserAccount findByActor(Actor actor) {
		Assert.notNull(actor);  
		UserAccount result;
		result = userAccountRepository.findByActorId(actor.getId());  
		return result;
	}
		
}
