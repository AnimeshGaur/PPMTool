package com.ppm.domain.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.domain.entity.Project;
import com.ppm.domain.execption.BadRequestException;
import com.ppm.domain.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	 
	public final Logger logger = LogManager.getLogger(ProjectController.class);
	@Autowired
	private ProjectService service;

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> createNewProject(@Valid @RequestBody Project project) {

		try {
			Project project2 = service.SaveOrUpdate(project);
			return new ResponseEntity<Project>(project2, HttpStatus.CREATED);

		} catch (Exception e) {
			logger.debug("already exists" + e);
		}
		return null;
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project) {

		try {
			Project project2 = service.Update(project);
			return new ResponseEntity<Project>(service.Update(project2), HttpStatus.OK);

		} catch (Exception e) {
			logger.info("already exists" + e);
		}
		return null;
	}

	@RequestMapping(path = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> getProjectById(@Valid @PathVariable String id) {

		Project project2 = service.getProjectById(id);
		return new ResponseEntity<Project>(project2, HttpStatus.OK);

	}

	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllProject() {
		return new ResponseEntity<Object>(service.getAllProject(), HttpStatus.CREATED);

	}

	@RequestMapping(path = "/id/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteProjectById(@Valid @PathVariable String id) {

		try {
			service.deleteProjectById(id);
			return " project deleted sucessfully";
		} catch (BadRequestException e) {

			logger.info("project with id not exists " + id);
		}
		return id;

	}

}
