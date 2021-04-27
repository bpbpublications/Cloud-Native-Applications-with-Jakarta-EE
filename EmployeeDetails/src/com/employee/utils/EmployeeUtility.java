package com.employee.utils;

import java.util.Calendar;
import java.util.Date;

public class EmployeeUtility {
	
	public int getEmployeeAge(Date dateOfBirth)
	{
		Date today = Calendar.getInstance().getTime();
		return today.getYear()-dateOfBirth.getYear();
	}

}
