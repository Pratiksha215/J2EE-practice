package com.app.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // mandatory : for telling SC that it's req handling controller 
//singleton n eager : SC creates 1 single instance @ dep time of web app
@RequestMapping("/test") // optional BUT reco. for separation
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	//how to tell SC : req handling method
	@RequestMapping(value = "/hello1") //mandatory
	//what will be the entry in HanadlerMapping bean 
	//key : /test/hello1
	//value : com.app.controller.TestController.sayHello1
	public String sayHello1()
	{
		System.out.println("in say hello1");
		return "/test/hello"; //logical view name(forward view name) : req handling controller ---> D.S
		//D.S ---> V.R ---> rets to D.S actual view
		//D.S by def : uses : server pull : RD : forward 
		//D.S invokes : RD rd=request.getRD("/WEB-INF/views/test/hello.jsp");
		//rd.forward(request,response); 
		//hello.jsp : can generate dyn conts --control comes back to D.S ---> WC ---> WS--resp pkt is sent to clnt
		
	}
	//add a request handling method to handle req params
	//nm=pen&qty=10&price=40.5&manuDate=2020-1-1
	@RequestMapping("/product")
	public String addProduct(@RequestParam String nm,@RequestParam int qty,
			@RequestParam("price") double productPrice, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate manuDate,Model map)
	{
		System.out.println("in add product "+nm+" "+ qty +" "+productPrice+" "+manuDate);
		map.addAttribute("product_dtls", nm+":"+productPrice+" @ "+manuDate);
		return "/product/add";//actual view name : /WEB-INF/views/product/add.jsp
	}
	
}
