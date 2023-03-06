package com.infy.dao;

import java.util.List;

import com.infy.model.Project;

public interface ProjectDAO {

	
	public Integer addProject(Project project) throws Exception;
	public List<Project>  getProjectDetails() throws Exception;
	
}
