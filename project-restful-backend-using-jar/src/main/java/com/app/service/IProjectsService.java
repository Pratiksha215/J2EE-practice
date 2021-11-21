package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Projects;

public interface IProjectsService {
	// list all projects
	List<Projects> getAllProjects();

	// get projects details by name
	Optional<Projects> getProjectsDetails(String projectName);

	// add new project details
	Projects addProjectsDetails(Projects transientPOJO);

	// update existing project details
	Projects updateProjectsDetails(int projectId, Projects detachedPOJO);

}
