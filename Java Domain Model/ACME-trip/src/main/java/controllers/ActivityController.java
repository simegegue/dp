package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ActivityService;
import services.TripService;
import domain.Activity;
import domain.Trip;


@Controller
@RequestMapping("/activity")
public class ActivityController extends AbstractController{
	
	// Constructors -----------------------------------------------------------
		public ActivityController(){
			super();
		}
	
	// Managed service --------------------------------------------------------
		@Autowired
		private ActivityService activityService;
		@Autowired
		private TripService tripService;
	
	// Methods ---------------------------------------------------------------
			
		@RequestMapping(value="/list", method=RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Activity> activities = activityService.findAll();
					
			result= new ModelAndView("activity/list");
			result.addObject("activities", activities);
			result.addObject("requestURI", "activity/list.do");

			return result;
		}

}
