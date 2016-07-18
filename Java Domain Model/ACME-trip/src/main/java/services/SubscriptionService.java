package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Subscription;
import domain.Trip;
import domain.User;

import repositories.SubscriptionRepository;

@Service
@Transactional
public class SubscriptionService {
	
	// Managed Repository----------------------------------------------------
			@Autowired
			private SubscriptionRepository subscriptionRepository;
			
	// Supporting Services---------------------------------------------------
			@Autowired
			private UserService userService;
			
			@Autowired
			private TripService tripService;
			
	// Constructors----------------------------------------------------------
			public SubscriptionService(){
				super();
			}
			
	// Simple CRUD Methods---------------------------------------------------
			public Subscription findOne(int subscriptionId){
				Assert.isTrue(subscriptionId != 0);
				Subscription result;
				result = subscriptionRepository.findOne(subscriptionId);
				Assert.notNull(result);
				return result;
			}
			
			
			public void save(Subscription subscription){
				Assert.notNull(subscription);
				subscription.setUser(userService.findByPrincipal());
				subscriptionRepository.saveAndFlush(subscription);
			}
			
			public void delete(Subscription subscription){
				Assert.isTrue(subscription.getId() != 0);
				Assert.notNull(subscription);
				subscriptionRepository.delete(subscription);
				
				User u = userService.findOne(subscription.getUser().getId());
				Collection<Subscription> aux = new ArrayList<Subscription>();
				for(Subscription su : u.getSubscriptions()){
					if(su.equals(subscription)){
						aux.remove(su);
					}
				}
				u.getSubscriptions().removeAll(aux);
				userService.edit(u);
			}
			
			public Subscription create(int tripId){
				Subscription result = new Subscription();
				User aux = userService.findByPrincipal();
				Trip aux2 = tripService.findOne(tripId);
				result.setUser(aux);
				result.setTrip(aux2);
				Assert.notNull(result);
				return result;
			}
			
	// Other business methods -------------------------------------------------
			
			public Collection<Subscription> findAll(){
				Collection<Subscription> result;
				Assert.notNull(subscriptionRepository);
				result = subscriptionRepository.findAll();
				Assert.notNull(result);
				return result;
			}
}
