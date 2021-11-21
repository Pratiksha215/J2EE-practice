package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.ProjectsNotFoundException;
import com.app.dao.IProjectsDao;
import com.app.pojos.Projects;

@Service
@Transactional
public class ProjectsServiceImpl implements IProjectsService {
	// dependency
	@Autowired
	private IProjectsDao dao;

	@Override
	public List<Projects> getAllProjects() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public Optional<Projects> getProjectsDetails(String projectName) {
		// TODO Auto-generated method stub
		return dao.findByName(projectName);
	}

	@Override
	public Projects addProjectsDetails(Projects transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

	@Override
	public Projects updateProjectsDetails(int projectId, Projects p1) {
		// chk if product exists : findById
		Optional<Projects> p = dao.findById(projectId);
		if (p.isPresent()) {
			// p.get() : PERSISTENT
			// p1 : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Projects projects = p.get();
			projects.setModifiedOn(p1.getModifiedOn());
			projects.setModifiedBy(p1.getModifiedBy());
			return projects;

		}
		//in case of no product found : throw custom exception
		throw new ProjectsNotFoundException("Invalid Project ID");

	}

}
