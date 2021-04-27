package com.employee.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.employee.model.Employee;
import com.employee.utils.LoggerUtility;

@Path("employees")
public class EmployeeController extends Application{
	 
	private EmployeeService employeeService = new EmployeeService();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
		LoggerUtility.logInfo("Recieved request to fetch all employees");
        return Response.ok(employeeService.getEmployees()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") String id) {
    		LoggerUtility.logInfo("Recieved request to fetch employee:"+id);
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(employee).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmployee(Employee employee) {
    		LoggerUtility.logInfo("Recieved request to create new Employee");
    		boolean success = employeeService.addEmployee(employee);
    		if(success) {
    			return Response.ok().build();
    		} else { 
    			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    		}
    }
    
}
