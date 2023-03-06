package com.infy.service;

import java.util.List;

import com.infy.model.Project;



public interface ProjectService {
	
	public Integer addProject(Project project) throws Exception;	
	public List<Project> getProjectDetails(String technology) throws Exception;
}
