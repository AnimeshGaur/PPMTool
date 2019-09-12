package com.ppm.domain.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.domain.Project;
import com.ppm.domain.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	Object object;
	public final  Logger logger = LogManager.getLogger(ProjectController.class);
	@Autowired
	private ProjectService service;

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> createNewProject(@Valid @RequestBody Project project) {
		
		try {
			Project project2 = service.SaveOrUpdate(project);
			return new ResponseEntity<Project>(project2, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.debug("already exists"+e);
			
		}
		return null;
		
	}
}
