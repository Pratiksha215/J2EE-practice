package com.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.pojos.Projects;
import com.app.service.IProjectsService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/projects")
public class ProjectsController {
	// dependency
	@Autowired
	private IProjectsService service;

	public ProjectsController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@GetMapping
	public ResponseEntity<?> listAllProjects() {
		System.out.println("in list all products");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Projects> projects = service.getAllProjects();
		if (projects.isEmpty())
			// empty product list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	// get prduct details by its name : supplied by clnt using path var
	@GetMapping("/{projectName}")
	public ResponseEntity<?> getProjectDetails(@PathVariable String projectName) {
		System.out.println("in get proj details " + projectName);
		// invoke service method
		Optional<Projects> projectDetails = service.getProjectsDetails(projectName);
		// valid name : HTTP 200 , marshalled product details
		if (projectDetails.isPresent())
			return new ResponseEntity<>(projectDetails.get(), HttpStatus.OK);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to create a new product : post
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Projects p) {
		System.out.println("in add product " + p);
		try {
			Projects savedProduct = service.addProjectsDetails(p);
			return new ResponseEntity<>(savedProduct, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing projects
	@PutMapping("/{projectsId}")
	public ResponseEntity<?> updateProjectDetails(@PathVariable int projectId, @RequestBody Projects p) {
		System.out.println("in update " + projectId + " " + p);
		try {
			Projects updatedDetails = service.updateProjectsDetails(projectId, p);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
