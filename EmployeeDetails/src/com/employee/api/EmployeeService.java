package com.employee.api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import com.employee.model.Employee;

public class EmployeeService {
	
    private static Map<String, Employee> employeeMap = new ConcurrentHashMap<>();
    
    static {
    		employeeMap.put("1", new Employee("1", "Alex", "Titan", "U.S."));
    		employeeMap.put("2", new Employee("2", "Love", "Dove", "India"));
    		employeeMap.put("3", new Employee("3", "Ricky", "Picky", "U.K."));
    		employeeMap.put("4", new Employee("4", "Tina", "Mina", "China"));
    }
	
    @CircuitBreaker(requestVolumeThreshold=2)
    @Retry(maxRetries=2)
    @Timeout(200)
	public List<Employee> getEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployee(String id) {
        return employeeMap.get(id);
    }
    
    public boolean addEmployee(Employee employee) {
    		try {
    			employeeMap.put(employee.getId(), employee);
    		} catch (Exception e) {
    			// addition failed 
    			return false;
    		}
    		return true;
    }
}
