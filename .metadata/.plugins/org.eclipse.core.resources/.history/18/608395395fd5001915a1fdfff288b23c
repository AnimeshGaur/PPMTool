package com.ppm.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppm.domain.Project;
import com.ppm.domain.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project SaveOrUpdate(Project project) {
		
		return projectRepository.save(project);
	}
}
