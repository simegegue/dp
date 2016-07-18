package services;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repositories.TripRepository;
import domain.Comment;
import domain.DailyPlan;
import domain.Subscription;
import domain.Trip;

@Service
@Transactional
public class TripService {

			// Managed Repository---------------------------------------------------
			@Autowired
			private TripRepository tripRepository;

			
			// Supporting Services---------------------------------------------------

			@Autowired
			private UserService userService;
			
			/*@Autowired
			private SubscriptionService subscriptionService;
			
			@Autowired
			private DailyPlanService dailyPlanService;*/
			
			
			// Constructors---------------------------------------------------------
			public TripService() {
				super();
			}

			// Simple CRUD Methods---------------------------------------------------

			public Trip findOne(int tripId) {
				Assert.isTrue(tripId != 0);
				Trip result;
				result = tripRepository.findOne(tripId);
				Assert.notNull(result);
				return result;
			}

			public void save(Trip trip) {
				Assert.notNull(trip);
				trip.setUser(userService.findByPrincipal());
				tripRepository.saveAndFlush(trip);
			}
			
			public void edit(Trip trip){
				Assert.notNull(trip);
				//Trip beforedit = tripRepository.findOne(trip.getId());
				tripRepository.saveAndFlush(trip);
			}

			public void delete(int tripId) {
				Assert.notNull(tripId);
				tripRepository.delete(tripId);
			}
			
			public Trip create(){
				Trip trip = new Trip();
				trip.setUser(userService.findByPrincipal());
				trip.setSubscriptions(new HashSet<Subscription>());
				trip.setDailyPlans(new HashSet<DailyPlan>());
				trip.setComments(new HashSet<Comment>());
				return trip;
			}

			
			
			// Other business methods -------------------------------------------------
		
			public Collection<Trip> findAll() {
				Collection<Trip> result = tripRepository.findAll();
				return result;
			}
		
			public Trip searchByKey(String key){
				Trip result;
				result = tripRepository.findByKeyword(key);
				Assert.notNull(result);
				return result;
			}
			
			public void copyTrip(Trip tripCopy){
				Trip trip = new Trip();
				trip.setUser(userService.findByPrincipal());
				trip.setSubscriptions(tripCopy.getSubscriptions());
				trip.setDailyPlans(tripCopy.getDailyPlans());
				trip.setComments(new HashSet<Comment>());
			}
			
			public Collection<Trip> listTripsByUser(int userId){
				Collection<Trip> result = tripRepository.finbByUserID(userId);
				Assert.notNull(result);
				return result;
			}
}
