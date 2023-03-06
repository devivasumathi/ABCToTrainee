package com.infy.validator;

import com.infy.model.TeamMember;

public class Validator {
		
	public static void validate(TeamMember teamMember) throws Exception {
		boolean validateEmployeeData=validateEmployeeId(teamMember.getEmployeeId());
		if(validateEmployeeData==false) {
			throw new Exception("validator.INVALID_EMPLOYEEID");
         }
	  }

	public static Boolean validateEmployeeId(Integer employeeId) throws Exception {
		if(employeeId> 100000 && employeeId< 999999) {
			return true;
		}
			return false;
		}
		
	}


