package services;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import domain.DailyPlan;
import domain.Trip;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class DailyPlanTest extends AbstractTest{

	// Service under test
	
	@Autowired
	private DailyPlanService dailyPlanService;
			
	@Autowired
	private TripService tripService;
	
	/*@Autowired
	private SlotService slotService;*/
		
	// Tests
		
	@Test
	public void create(){
		DailyPlan result = dailyPlanService.create(13);
		result.setTitle("Because I'm happy");
		result.setDescription("Clap along if you feel like a room without a roof");
		Date day = new Date();
		day.setTime(day.getTime()+100000);
		result.setDay(day);
		System.out.print(result.getTitle() + "," + result.getTrip().getTitle());
		dailyPlanService.save(result);			
	}
			
	@Test
	public void findOne(){
		int dailyPlanId = 16;
		DailyPlan da = dailyPlanService.findOne(dailyPlanId);
		System.out.println(da.getTitle() + ","+ da.getTrip().getTitle());
	}
			
	@Test
	public void deleteDailyPlan(){
		int dailyPlanId = 16;
		DailyPlan da = dailyPlanService.findOne(dailyPlanId);
		dailyPlanService.delete(da);
		Collection<Trip> result = tripService.findAll();
		for(Trip t: result){
			System.out.println(t.getTitle() + "," + t.getDailyPlans().size());
		}
	}
	
	@Test
	public void findAllDailyPlan(){
		Collection<DailyPlan> result;
		result = dailyPlanService.findAll();
		for(DailyPlan aux:result){
			System.out.println(aux.getTitle() + ", "  + aux.getTrip().getTitle());
		}
	}
	
}
