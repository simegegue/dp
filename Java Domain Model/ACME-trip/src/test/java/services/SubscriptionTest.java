package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Subscription;
import domain.User;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class SubscriptionTest extends AbstractTest{
		
		// Service under test
	
		@Autowired
		private SubscriptionService subscriptionService;
		
		@Autowired
		private UserService userService;
		
		// Tests
		
		/*@Test
		public void create(){
			authenticate("user1");
			Subscription result = subscriptionService.create(13);
			System.out.print(result.getUser().getName() + "," + result.getTrip().getTitle());
			subscriptionService.save(result);
			authenticate(null);
			
		}
		
		@Test
		public void findOne(){
			int subscriptionId = 14;
			Subscription sub = subscriptionService.findOne(subscriptionId);
			System.out.println(sub.getUser() + ","+  sub.getTrip().getTitle());
		}*/
		
		@Test
		public void deleteSubscription(){
			int subscriptionId = 14;
			Subscription sub = subscriptionService.findOne(subscriptionId);
			subscriptionService.delete(sub);
			Collection<User> result = userService.findAll();
			for(User u: result){
				System.out.println(u.getName() + "," + u.getSubscriptions().size());
			}
		}
		/*
		@Test
		public void findAllSubscriptions(){
			Collection<Subscription> result;
			result = subscriptionService.findAll();
			for(Subscription aux:result){
			System.out.println(aux.getUser().getName() + " "  + aux.getTrip().getTitle());
			}
		}*/
}
