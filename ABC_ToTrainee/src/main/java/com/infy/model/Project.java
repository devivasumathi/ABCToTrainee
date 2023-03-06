package com.infy.model;

import java.util.List;




public class Project {
	
	private Integer projectId;
	private String projectName;
	private String technologyUsed;
	private Integer teamSize;
	private Integer cost;
	private List<TeamMember> memberList;
	public List<TeamMember> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<TeamMember> memberList) {
		this.memberList = memberList;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTechnologyUsed() {
		return technologyUsed;
	}
	public void setTechnologyUsed(String technologyUsed) {
		this.technologyUsed = technologyUsed;
	}
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
}
