package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user") // get , post , put ,delete .... can intercept ANY request method
public class UserController {
	// dependent obj : user controller
	// dependency obj : service i/f
	@Autowired //byType
	//SC searches if is there any spring bean : which has implemented IUserService
	//YES : => IUserService service
	private IUserService service;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add req handling method to respond to get method : to show login form
	// H.M bean : key : /user/login + method=get
	// value : UserController:showLoginForm()
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";// actual view name : /WEB-INF/views/user/login.jsp
	}

	// add B.L method for processing the form. method =post
	@PostMapping("/login")
	//@RequestParam String em => String em = request.getParameter("em")...
	//Model map=> map of model attrs (hold results of action : request scope only): SC injects empty Map
	public String processLoginForm(@RequestParam String em, @RequestParam String pass, Model map,HttpSession hs) {
		System.out.println("in process login form");
		try {
			//invokes service layer method for auth
			User authenticateUser = service.authenticateUser(em, pass);
			//login successful : valid user login
		hs.setAttribute("user_dtls", authenticateUser);
		hs.setAttribute("mesg","Login Successful");
			//check role of the logged in user 
			if(authenticateUser.getRole().equals(Role.ADMIN))
				return "redirect:/admin/list";//create AdminController : add req mapping
			//vendor : logged in
			return "redirect:/vendor/details";// create VendorController : add req mapping
		} catch (RuntimeException e) {
			//NoResultExc
			//e.printStackTrace();
			System.out.println("err in controller "+e);
			map.addAttribute("mesg","Invalid Login , Pls retry");
			return "/user/login";// def nav : RD's forward 
		}

	}
	

}
