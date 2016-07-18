package services;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


import domain.DailyPlan;
import domain.Slot;
import domain.Trip;

import repositories.DailyPlanRepository;

@Service
@Transactional
public class DailyPlanService {
	
	// Managed Repository----------------------------------------------------
			
			@Autowired
			private DailyPlanRepository dailyPlanRepository;
			
			@Autowired
			private TripService tripService;

	// Supporting Services---------------------------------------------------
			
	// Constructors----------------------------------------------------------
			
			public DailyPlanService(){
				super();
			}
			
	// Simple CRUD Methods---------------------------------------------------
			
			public DailyPlan findOne(int dailyPlanId){
				Assert.isTrue(dailyPlanId != 0);
				DailyPlan result;
				result = dailyPlanRepository.findOne(dailyPlanId);
				Assert.notNull(result);
				return result;
			}
				
			public void save(DailyPlan dailyPlan){
				Assert.notNull(dailyPlan);
				dailyPlanRepository.saveAndFlush(dailyPlan);
			}
			
			public void delete(DailyPlan dailyPlan){
				Assert.notNull(dailyPlan);
				dailyPlanRepository.delete(dailyPlan);
			}
			
			public DailyPlan create(int tripId){
				
				DailyPlan plan = new DailyPlan();
				Trip trip = tripService.findOne(tripId);
				plan.setTrip(trip);
				plan.setSlots(new HashSet<Slot>());
				return plan;
				
			}
			
	// Other business methods -------------------------------------------------
			
			public Collection<DailyPlan> findAll(){
				Collection<DailyPlan> result;
				Assert.notNull(dailyPlanRepository);
				result = dailyPlanRepository.findAll();
				Assert.notNull(result);
				return result;
			}
			
}
