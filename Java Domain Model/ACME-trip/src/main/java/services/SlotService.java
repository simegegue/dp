package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.DailyPlan;
import domain.Slot;

import repositories.SlotRepository;

@Service
@Transactional
public class SlotService {
	// Managed Repository
	@Autowired
	private SlotRepository slotRepository;
	// Supporting Services
	private DailyPlanService dailyPlanService;
	// Constructors
	public SlotService(){
		super();
	}
	//Simple CRUD Methods
	public Slot findOne(int slotId){
		Assert.isTrue(slotId !=0);
		Slot result;
		result=slotRepository.findOne(slotId);
		Assert.notNull(result);
		return result;
	}
	public Collection<Slot> findAll(){
		Collection<Slot>result;
		Assert.notNull(slotRepository);
		result=slotRepository.findAll();
		Assert.notNull(result);
		return result;
	}
	public Slot create(int dailyPlanId){
		Slot result=new Slot();
		DailyPlan aux1=dailyPlanService.findOne(dailyPlanId);
		result.setDailyPlan(aux1);
		Assert.notNull(result);
		return result;
	}
	public void save(Slot slot){
		Assert.notNull(slot);
		slotRepository.saveAndFlush(slot);
	}
	public void edit(Slot slot){
		Assert.notNull(slot);
		slotRepository.saveAndFlush(slot);
	}
	public void delete(int slotId){
		Assert.notNull(slotId);
		slotRepository.delete(slotId);
	}
}
