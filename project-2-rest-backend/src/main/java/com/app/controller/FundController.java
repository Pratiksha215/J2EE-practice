package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Fund;
import com.app.service.IFundService;

@RestController // =@Controller at the cls level +
//@ResponseBody placed auto on ret types of all req handling methods(@RequestMapping or any of its subtype)
//@GetMapping.....
@RequestMapping("/funds") // reco : use the name of the resource :
//to be manipulated by front end web app, using URLs
public class FundController {
	// dep
	@Autowired
	private IFundService service;

	public FundController() {
		System.out.println("in ctor of" + getClass().getName());
	}

	// add req handling method to list all the resources, which will be sent
	// directly to front end webapp :
	// in marshalleddata format
	@GetMapping
	public ResponseEntity<?> getAvailableFunds() {
		System.out.println("in get avl funds");
		List<Fund> funds = service.getAllFunds();
		if (funds.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// non empty list
		return new ResponseEntity<>(funds, HttpStatus.OK);

		// Rest controller ---> @ResponseBody List -->D.S ---> D.S performs marshlling
		// application/json java obj ---> json ---sent to clnt(postman / angular or any
		// such front end)

	}

	// add req handling method to ret fund by name
	@GetMapping("/{fundName}")
	public ResponseEntity<?> getFundDetails(@PathVariable String fundName) {
		System.out.println("in get fund dtls");
		try {
			Fund fund = service.getFundByName(fundName);
			return new ResponseEntity<>(fund, HttpStatus.OK);
		} catch (RuntimeException e) {
			// resp pkt : set status code : 404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// req handling method to create new fund
	@PostMapping
	// @RequestBody=>un marshalling
	public ResponseEntity<?> createNewFund(@RequestBody Fund newFund) {
		System.out.println("in create fund" + newFund);
		try {
			Fund fund = service.createNewFund(newFund);
			return new ResponseEntity<>(fund, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			// resp pkt : set status code : 500(server internal error)
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//add a req handling method to update funds details
	@PutMapping("/{fundId}")
	public ResponseEntity<?> updateFundDetails(@PathVariable int fundId,@RequestBody Fund detachedPojo)
	{
		System.out.println("in update funds"+fundId+" "+detachedPojo);
		Fund updateFund = service.updateFund(fundId, detachedPojo);
		if(updateFund == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateFund,HttpStatus.OK);
	}
}
