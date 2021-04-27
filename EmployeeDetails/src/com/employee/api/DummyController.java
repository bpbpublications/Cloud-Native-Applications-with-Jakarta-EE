package com.employee.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.employee.model.Employee;
import com.employee.utils.LoggerUtility;

@Path("bestemployee")
public class DummyController {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBestEmployees() {
		LoggerUtility.logInfo("Recieved request to fetch all employees");
		Employee employee = new Employee("99", "Top", "Employee", "U.K.");
        return Response.ok(employee).build();
    }
}
