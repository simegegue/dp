package controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.UserService;

import controllers.AbstractController;
import domain.User;


@Controller
@RequestMapping("/user/profile")
public class UserProfileController extends AbstractController{
	
	// Constructors -----------------------------------------------------------
	public UserProfileController(){
		super();
	}
	
	// Managed service --------------------------------------------------------
	@Autowired
	private UserService userService;
	
	// Methods ---------------------------------------------------------------
	/*@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		User user = userService.findByPrincipal();
		result = new ModelAndView("user/list");
		result.addObject("customer", customer);	
		result.addObject("requestURI", "customer/list.do");
		return result;
	}*/
	
}
