package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.User;

import services.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{
	
	public UserController(){
		super();
	}
	
	// Managed service --------------------------------------------------------
	
	@Autowired
	private UserService userService;
	
	// Register ---------------------------------------------------------------
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		User user;
			
		user = userService.create();
			
		result= createEditModelAndView(user);

		return result;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST,params="save")
	public ModelAndView save(@Valid User user, BindingResult binding) {
		
		ModelAndView result;
		if(binding.hasErrors()){
			result=createEditModelAndView(user);
		}else{
			try{
				userService.save(user);
				result=new ModelAndView("redirect:../");
			}catch (Throwable oops) {
				result = createEditModelAndView(user,"user.commit.error");
			}
		}
		return result;
	}
	
	// List -------------------------------------------------------------------
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView result;
		Collection<User> users = userService.findAll(); 
		
		result = new ModelAndView("user/list");
		result.addObject("users", users);
		result.addObject("requestURI", "user/list.do");
		return result;

	}
	// Ancillary methods
	
	protected ModelAndView createEditModelAndView(User user){
		ModelAndView result;
		result=createEditModelAndView(user,null);
		return result;
	}
	protected ModelAndView createEditModelAndView(User user, String message){
		ModelAndView result;
			
		result=new ModelAndView("user/register");
		result.addObject("user",user);
		result.addObject("message",message);
		return result;
	}

}
