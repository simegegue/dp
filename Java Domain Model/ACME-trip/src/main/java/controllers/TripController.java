package controllers;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Trip;
import domain.User;

import services.TripService;
import services.UserService;

@Controller
@RequestMapping("/trip")
public class TripController  extends AbstractController{
	
		public TripController(){
		
		}
	
	// Managed service --------------------------------------------------------
		@Autowired
		private TripService tripService;
		
		@Autowired
		private UserService userService;
		
	// Methods ---------------------------------------------------------------
		
	// ListAllTrips ----------------------------------------------------------
		
		@RequestMapping(value="/list", method=RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Trip> trips = tripService.findAll();
					
			result= new ModelAndView("trip/list");
			result.addObject("trips", trips);
			result.addObject("requestURI", "trip/list.do");

			return result;
		}
	// ListTripsByUser -------------------------------------------------------
		@RequestMapping(value="/listRegisteredByUser", method=RequestMethod.GET)
		public ModelAndView listRegisteredByUser(@RequestParam int userId) {
			ModelAndView result;
			User user = userService.findOne(userId);
			Collection<Trip> trips = new HashSet<Trip>();
					
			result= new ModelAndView("trip/list");
			trips = tripService.listTripsByUser(user.getId());
			result.addObject("trips", trips);
			result.addObject("requestURI", "trip/RegisteredByUser.do");

			return result;
		}
		
	// SearchByKeyword -------------------------------------------------------
		
		@RequestMapping(value="/searchByKeyword", method=RequestMethod.GET)
		public ModelAndView searchByKeyword(@RequestParam String key) {
			ModelAndView result;
			String requestUri="trip/searchByKeyword.do?key="+key;
			try{
			

				Trip trip = tripService.searchByKey(key);
			
				result= new ModelAndView("trip/list");
				result.addObject("trips", trip);
				result.addObject("requestURI", requestUri);
			}catch(Throwable oops){
				result= new ModelAndView("trip/list");
				result.addObject("requestURI", requestUri);
			}
			return result;
		}
	
}
