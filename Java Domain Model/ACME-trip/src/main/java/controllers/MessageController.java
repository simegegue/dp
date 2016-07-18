package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Message;

import services.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController extends AbstractController{
	
	// Constructors -----------------------------------------------------------
			public MessageController(){
				super();
			}
			
	// Managed service ---------------------------------------------------------
			@Autowired
			private MessageService messageService;
			
	// View --------------------------------------------------------------------
			@RequestMapping(value = "/view", method = RequestMethod.GET)
			public ModelAndView view(@RequestParam int messageId) {
				ModelAndView result;
				Message message;
				message = messageService.findOne(messageId);
				Assert.notNull(message);
				
				result = createEditModelAndView(message);
				
				return result;
			}
	// New --------------------------------------------------------------------
			@RequestMapping("/new")
			public ModelAndView respond() {
				ModelAndView result;
						
				result = new ModelAndView("message/new");
				
				return result;
			}
			
			// Ancillary methods ------------------------------------------------------
			protected ModelAndView createEditModelAndView(Message messag) {
				ModelAndView result;

				result = createEditModelAndView(messag, null);

				return result;
			}

			protected ModelAndView createEditModelAndView(Message messag,
					String message) {
				ModelAndView result;
				result = new ModelAndView("message/view");
				result.addObject("messag", messag);
				result.addObject("message", message);
				return result;
			}
}
