package org.ramesh.controllers;

import org.ramesh.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	MyService myService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		if(myService!=null)
			myService.getService();
		else
			System.out.println("Service is not initialized");
		System.out.println("We are in home");
		return "home";
	}
}
