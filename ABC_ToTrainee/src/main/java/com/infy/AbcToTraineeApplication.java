package com.infy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.model.Project;
import com.infy.model.TeamMember;
import com.infy.service.ProjectServiceImpl;


@SpringBootApplication
public class AbcToTraineeApplication implements CommandLineRunner {

	@Autowired
	ProjectServiceImpl projectServiceImpl;
	
	@Autowired
	Environment environment;

	
	public static void main(String[] args) {
		SpringApplication.run(AbcToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		addProject();
		getProjectDetails();
	}

	public void addProject() throws Exception {
		List<Project> projectList = new ArrayList<>();
		Project project = new Project();
		project.setProjectId(5000);
		project.setCost(200000);
		project.setProjectName("FSADM1");
		project.setTeamSize(20);
		project.setTechnologyUsed("Java");

		List<TeamMember> listofMembers = new ArrayList<>();
		TeamMember member1 = new TeamMember();
		member1.setEmployeeId(119037);
		member1.setEmployeeName("Ron");
		member1.setSkills("Java,BI");
		member1.setDesignation("SC");
		
		/*TeamMember member2 = new TeamMember();
		member2.setEmployeeId(722667);
		member2.setEmployeeName("Jack");
		member2.setSkills("Java,BI");
		member2.setDesignation("SC");*/

		listofMembers.add(member1);
		//listofMembers.add(member2);

		project.setMemberList(listofMembers);
		
		/*Project project1 = new Project();
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

		project1.setMemberList(listofMembers1);*/
		
		projectList.add(project);
		//projectList.add(project1);
		int output=projectServiceImpl.addProject(project);
		if(output==0) {
			//throw new Exception("Employee id is not valid");
			System.out.println("Employee id is not valid");
	
		}
		else {
			String message=environment.getProperty("UserInterface.PROJECT_ADDED_SUCCESS");
		     System.out.println(message+":"+output);
		}

	}

	public void getProjectDetails() throws Exception {
		/*Project project=new Project();
		project.setTechnologyUsed("Java");*/
		String technologyUsed="Java";
		List<Project> projectList = projectServiceImpl.getProjectDetails(technologyUsed);
		//projectList.get(0);
		for(Project flist:projectList) {
			if(flist.getTechnologyUsed().equals(technologyUsed)) {
				System.out.println();
				System.out.print("Project Id"+flist.getProjectId()+","+"Technology Used"+flist.getTechnologyUsed());
				List<TeamMember> teamList = flist.getMemberList();
				for(TeamMember tlist:teamList) {
					System.out.println();
					System.out.print("MemberId"+tlist.getEmployeeId()+" "+"MemberName"+tlist.getEmployeeName()+" "+"Skills"+tlist.getSkills());
				}
			}
			
			else if(!flist.getTechnologyUsed().equals(technologyUsed)){
				//System.out.println("No projects found for the specified technology");
				String message=environment.getProperty("Service.PROJECTS_NOT_FOUND");
			     System.out.println(message);
			}
		
			
			}
		}

	}

