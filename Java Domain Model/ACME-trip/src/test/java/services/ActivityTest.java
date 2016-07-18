package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.Activity;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ActivityTest extends AbstractTest {
	
		// Service under test
		
		@Autowired
		private ActivityService activityService;
		
		@Autowired
		private UserService userService;

		// Tests
		
		/*@Test
		public void create(){
			authenticate("user1");
			Activity activity = activityService.create();
			activity.setDescription("Descripcion de prueba");
			activity.setInappropiate(true);
			activity.setTitle("Titulo de prueba");
			activity.setType("Poner tipo");
			System.out.print(activity.getUser().getName() + "," + activity.getTitle());
			activityService.save(activity);
			authenticate(null);
		}*/
		
		@Test
		public void findOne(){
			int activityId = 18;
			Activity activity = activityService.findOne(activityId);
			System.out.println(activity.getTitle());
		}
		
		@Test
		public void editActivity(){
			int activityId = 18;
			Activity activity = activityService.findOne(activityId);
			activity.setTitle("nombreModificado");
			activityService.edit(activity);
			Activity activity2 = activityService.findOne(activity.getId());
			System.out.println(activity2.getTitle());
		}
		
		//Acordar funcionamiento de activity
		/*@Test
		public void deleteActivity(){
			int activityId = 18;
			Activity activity = activityService.findOne(activityId);
			activityService.delete(activity.getId());
			
			
		}*/
		
		@Test
		public void findAllActivities(){
			Collection<Activity> result;
			result = activityService.findAll();
			for(Activity aux:result){
			System.out.println(aux.getTitle() + " "  + aux.getDescription());
			}
		}

}
