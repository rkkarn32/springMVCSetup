package org.ramesh.controllers;

import org.ramesh.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	MyService myService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(RedirectAttributes red){
		if(myService!=null)
			myService.getService();
		else
			System.out.println("Service is not initialized");
		System.out.println("We are in home");
		red.addFlashAttribute("message", "This is Flash Messages");
		return "redirect:/anohter";
	}
	
	@RequestMapping(value="/anohter", method= RequestMethod.GET)
	public String redirectionTesting(ModelMap model ){
		if(model.containsAttribute("message"))
			System.out.println("Message: "+model.get("message"));
		return "home";
	}
}
