package com.ppm.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ppm.domain.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Query(value = "FROM Project WHERE projectIdentifier = ?1")
	Project findAllByProjectIdentifier(String id);
	
	@Override
	List<Project> findAll();

	
}
