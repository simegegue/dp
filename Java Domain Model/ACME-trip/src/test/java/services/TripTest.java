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

import domain.Trip;
import domain.User;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TripTest extends AbstractTest{

	// Service under test
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private UserService userService;

	// Tests
	/*
	@Test
	public void create(){
		authenticate("user1");
		Trip trip = tripService.create();
		trip.setDescription("Descripcion de prueba");
		trip.setTitle("Titulo de prueba");
		Date d = new Date();
		d.setTime(d.getTime()+100000);
		trip.setDate(d);
		System.out.print(trip.getUser().getName() + "," + trip.getTitle());
		tripService.save(trip);
		authenticate(null);
	}
	
	@Test
	public void findOne(){
		int tripId = 13;
		Trip trip = tripService.findOne(tripId);
		System.out.println(trip.getTitle());
	}
	
	@Test
	public void editTrip(){
		int tripId = 13;
		Trip trip = tripService.findOne(tripId);
		trip.setTitle("nombreModificado");
		tripService.edit(trip);
		Trip trip2 = tripService.findOne(trip.getId());
		System.out.println(trip2.getTitle());
	}
	
	@Test
	public void deleteTrip(){
		int tripId = 13;
		Trip trip = tripService.findOne(tripId);
		tripService.delete(trip.getId());
		
		
	}
	
	@Test
	public void findAllTrips(){
		Collection<Trip> result;
		result = tripService.findAll();
		for(Trip aux:result){
		System.out.println(aux.getTitle() + " "  + aux.getDescription());
		}
	}*/
	
	/*@Test
	public void SearchTrip(){
		Trip result = tripService.searchByKey("playa");
		System.out.println(result.getTitle() + " " + result.getDescription());
	}*/
	
	@Test
	public void listTripsByUser(){
		Collection<Trip> trips = tripService.listTripsByUser(12);
		for(Trip t:trips){
			System.out.print(t.getTitle());
		}
 	}
}
