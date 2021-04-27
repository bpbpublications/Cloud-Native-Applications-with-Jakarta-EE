package com.employee.details.EmployeeDetailsSpring;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("employees")
public class EmployeeController {

	@GetMapping
	public List<Employee> getEmployees() {
		LoggerUtility.logInfo("Recieved request to fetch all employees");
		return new EmployeeService().getEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		LoggerUtility.logInfo("Recieved request to fetch employee:"+id);
	    Employee employee = new EmployeeService().getEmployee(id);
	    if (employee == null) {
	        return null;
	    }
	    return employee;
	}
	
	@PostMapping
	 public boolean addEmployee(@RequestBody Employee employee) {
 		LoggerUtility.logInfo("Recieved request to create new Employee:"+employee.getId());
 		//Employee employee = new Employee(1, "","","");
 		boolean success = new EmployeeService().addEmployee(employee);
 		return success;
 }
	
}
