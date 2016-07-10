package controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.Department;
import pojo.Employee;
import service.EmployeeService;

@RestController
public class EmployeeController {
	private final Log log = LogFactory.getLog(this.getClass());
	@Autowired 
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employees/{id}",method=RequestMethod.GET)
	    public Employee getEmployeeById(@PathVariable int id){
		Employee employee = employeeService.findById(id); 
		return employee;
	}

	@RequestMapping(value = "/employees/{id}",method=RequestMethod.PUT)
	public void Update(@PathVariable int id,Employee employee) {
		employeeService.Update(employee);
	}
	
	@RequestMapping(value = "/employees/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		employeeService.delete(id);
	}

	@RequestMapping(value = "/employees",method=RequestMethod.POST)
	public void save(Employee employee) {
		employeeService.save(employee);
	}
	
	@RequestMapping(value = "/employees",method=RequestMethod.GET)
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@RequestMapping(value = "/employees/{employeeId}/department",method=RequestMethod.GET)
    public Department getDepartmentOfAnEmployee(@PathVariable int employeeId){
		Department department = employeeService.findDepartmentOfAnEmployee(employeeId); 
	return department;
}
	public void setemployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
