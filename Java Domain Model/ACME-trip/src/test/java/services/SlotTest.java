package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import utilities.AbstractTest;
import domain.Slot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class SlotTest extends AbstractTest{
	// Service under test
	@Autowired
	private SlotService slotService;
	
	@Autowired
	private DailyPlanService dailyPlanService;
	
	/*@Test
	public void create(){
		DailyPlan dailyPlan=dailyPlanService.create();
		Slot slot=slotService.create(dailyPlan.getId());
		slot.setTitle("Salida");
		slot.setDescription("Salida desde la estacion");
		Date start=new Date();
		start.setTime(start.getTime()+100000);
		slot.setStart(start);
		Date end=new Date();
		end.setTime(end.getTime()+100000);
		slot.setEnd(end);
	}*/
	@Test
	public void findOne(){
		int slotId=19;
		Slot slot=slotService.findOne(slotId);
		System.out.println(slot.getTitle());
		
	}
	@Test 
	public void findAll(){
		Collection<Slot>result;
		result=slotService.findAll();
		for(Slot aux:result){
			System.out.println(aux.getTitle());
		}
	}
	@Test
	public void edit(){
		int slotId=19;
		Slot slot=slotService.findOne(slotId);
		slot.setTitle("Salida cambiada");
		slotService.edit(slot);
	}
	@Test
	public void delete(){
		int slotId=19;
		Slot slot=slotService.findOne(slotId);
		slotService.delete(slot.getId());
	}

}
