package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	// add req handling method to display home page
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("in show hm page");
		return "/index";//forward view : logical view name ---D.S --V.R : /WEB-INF/views/index.jsp
	}

}
