package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infy.model.Project;
import com.infy.model.TeamMember;


@Repository(value="projectDAO")
public class ProjectDAOImpl implements ProjectDAO {
	
	public List<Project> projectList = new ArrayList<>();
	public static Integer projectId = 5004;
	
	public ProjectDAOImpl() {
		projectId++;
		
		Project project = new Project();
		project.setProjectId(5001);
		project.setCost(200000);
		project.setProjectName("FSADM1");
		project.setTeamSize(20);
		project.setTechnologyUsed("Java");

		List<TeamMember> listofMembers = new ArrayList<>();
		TeamMember member1 = new TeamMember();
		member1.setEmployeeId(722666);
		member1.setEmployeeName("Ron");
		member1.setSkills("Java,BI");
		member1.setDesignation("SC");
		
		TeamMember member2 = new TeamMember();
		member2.setEmployeeId(722667);
		member2.setEmployeeName("Jack");
		member2.setSkills("Java,BI");
		member2.setDesignation("SC");

		listofMembers.add(member1);
		listofMembers.add(member2);

		project.setMemberList(listofMembers);
		
		Project project1 = new Project();
		project1.setProjectId(5002);
		project1.setCost(200000);
		project1.setProjectName("FSADM2");
		project1.setTeamSize(15);
		project1.setTechnologyUsed("BI");

		List<TeamMember> listofMembers1 = new ArrayList<>();
		TeamMember member3 = new TeamMember();
		member3.setEmployeeId(722668);
		member3.setEmployeeName("Andrews");
		member3.setSkills("BI");
		member3.setDesignation("SC");
		TeamMember member4 = new TeamMember();
		member4.setEmployeeId(722669);
		member4.setEmployeeName("John");
		member4.setSkills("BI");
		member4.setDesignation("SC");
		TeamMember member5 = new TeamMember();
		member5.setEmployeeId(722670);
		member5.setEmployeeName("Steve");
		member5.setSkills("BI");
		member5.setDesignation("SC");

		listofMembers1.add(member3);
		listofMembers1.add(member4);
		listofMembers1.add(member5);

		project1.setMemberList(listofMembers1);
		
		projectList.add(project);
		projectList.add(project1);

	}

	


	public Integer addProject(Project project) throws Exception {
		project.setProjectId(projectId);
		projectList.add(project);
		return project.getProjectId();
	}

	public List<Project> getProjectDetails() throws Exception {
		
		return projectList;
	}

}
