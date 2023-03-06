package com.infy.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.ProjectDAO;
import com.infy.model.Project;
import com.infy.model.TeamMember;
import com.infy.validator.Validator;


@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectDAO projectDAO;
	

	@Override
	public Integer addProject(Project project) throws Exception {
		List<TeamMember> teamMemberList=project.getMemberList();
		int addProjectoutput=0;
		for(TeamMember teamlist:teamMemberList) {
			if(Validator.validateEmployeeId(teamlist.getEmployeeId())==true) {
				addProjectoutput=projectDAO.addProject(project);
			}
		}
			return addProjectoutput;
	}

	@Override
	public List<Project> getProjectDetails(String technology) throws Exception {
		List<Project> projectList=projectDAO.getProjectDetails();
		List<Project> filteredList=new ArrayList();
		for(Project flist:projectList) {
			if(flist.getTechnologyUsed().equals(technology)) {
				filteredList.add(flist);
			}
		}
		if(filteredList.equals(null)) {
			throw new Exception("Service.PROJECTS_NOT_FOUND");
		}
	return filteredList;
	}

}
