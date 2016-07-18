package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ActivityRepository;
import domain.Activity;


@Service
@Transactional
public class ActivityService {

		// Managed Repository---------------------------------------------------
			@Autowired
			private ActivityRepository activityRepository;

				
		// Supporting Services---------------------------------------------------

			@Autowired
			private UserService userService;
				
		// Constructors---------------------------------------------------------
			public ActivityService() {
				super();
			}

		// Simple CRUD Methods---------------------------------------------------

			public Activity findOne(int activityId) {
					Assert.isTrue(activityId != 0);
					Activity  result;
					result = activityRepository.findOne(activityId);
					Assert.notNull(result);
					return result;
				}

				public void save(Activity  activity) {
					Assert.notNull(activity);
					activity.setUser(userService.findByPrincipal());
					activityRepository.saveAndFlush(activity);
				}
				
				public void edit(Activity  activity){
					Assert.notNull(activity);
					activityRepository.saveAndFlush(activity);
				}

				public void delete(int activityId) {
					Assert.notNull(activityId);
					activityRepository.delete(activityId);
				}
				
				public Activity create(){
					Activity  activity = new Activity();
					activity.setUser(userService.findByPrincipal());
					return activity;
				}

				
				
				// Other business methods -------------------------------------------------
			
				public Collection<Activity > findAll() {
					Collection<Activity > result = activityRepository.findAll();
					return result;
				}
			
}
