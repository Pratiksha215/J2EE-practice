package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //mandatory
@RequestMapping("/test")//optional but recommended

public class HelloController {
	public HelloController() {
		System.out.println("in ctor of " +getClass().getName());
	}
	//req handling method
	@RequestMapping("/hello1") //mandatory
	//Entry in HandlerMapping bean
	//key : /hello1
	//value : com.app.controller.HelloController.sayHello
	public String sayHello1()
	{
		System.out.println("in say hello1");
		return "/test1/welcome"; //Req handling controller rets logical view name to D.S
	}
	@RequestMapping("/hello2")
	public ModelAndView sayHello2()
	{
		System.out.println("in say hello2");
		//Req handling Controller rets : ModelAndView object to D.S
		// /welcome : logical view name
		// server_dt : model attribute name
		// LocalDateTime.now() : model attr value
		return new ModelAndView("/test/welcome", "server_dt", LocalDateTime.now());
	}
	
	@RequestMapping("/hello3")
	public String sayHello3(Model map) //map of model attributes
	{
		System.out.println("in say hello3" +map);//empty Map {}
		map.addAttribute("server_dt", LocalDateTime.now());
		map.addAttribute("number_list", Arrays.asList(10,20,30,40));
		System.out.println("map after"+map);
		return "/test/welcome";
	}
}
