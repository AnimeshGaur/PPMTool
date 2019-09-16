package com.ppm.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppm.domain.entity.Project;
import com.ppm.domain.execption.BadRequestException;
import com.ppm.domain.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	
	public Project SaveOrUpdate(Project project) {
		
		return projectRepository.save(project);
	}

	public Project getProjectById(String id) {
		
		return projectRepository.findAllByProjectIdentifier(id);
	}

	public Object getAllProject() {
	
		return projectRepository.findAll();
	}

	public void deleteProjectById(String id) throws BadRequestException {
		
		Project project = projectRepository.findAllByProjectIdentifier(id);
		if (project == null ) {
			throw new BadRequestException("project with id not exists  == " + id);
		}
		 projectRepository.delete(project);
	}

	public Project Update(Project project) throws BadRequestException {
		Project project2 = projectRepository.findAllByProjectIdentifier(project.getProjectIdentifier()); 
		if (project2 == null) {
			throw new BadRequestException("please enter valid project Identifier");
		}
		project2.setProjectIdentifier(project.getProjectIdentifier());
		project2.setProjectName(project.getProjectName());
		project2.setEndDate(project.getEndDate());
		project2.setDesciption(project.getDesciption());
		project2.setStartdate(project.getStartdate());
		project2.setUpdatedAt(new Date());
		
		return projectRepository.save(project2);
		
	}
}
