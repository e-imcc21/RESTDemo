package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.Department;
import pojo.Employee;
import service.DepartmentService;
import service.EmployeeService;

@RestController
public class DepartmentController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/departments/{id}/employees", method = RequestMethod.GET)
	public List<Employee> findEmployeesByDepartmentId(@PathVariable int id) {
		return employeeService.findEmployeesByDepartmentId(id);
	}
	@RequestMapping(value = "/departments/{id}/employees", method = RequestMethod.POST)
	public void addEmployeesToADepartment(@PathVariable int id,Employee employee) {
		employee.setDepartmentId(id);
		employeeService.save(employee);
		return ;
	}
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
	public Department getDepartmentById(@PathVariable int id) {
		Department department = departmentService.findById(id);
		return department;
	}

	@RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
	public void Update(@PathVariable int id, Department department) {
		departmentService.Update(department);
	}

	@RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		departmentService.delete(id);
	}

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public List<Department> findAll() {
		return departmentService.findAll();
	}

	@RequestMapping(value = "/departments/{id}/subDepts", method = RequestMethod.GET)
	public List<Department> getSubDepartments(@PathVariable int id) {
		List<Department> departments = departmentService.findByParentDeptId(id);
		return departments;
	}

	@RequestMapping(value = "/departments/{id}/subDept", method = RequestMethod.POST)
	public void addSubDept(@PathVariable int id ,Department department) {
		department.setParentDeptId(id);
		departmentService.save(department);
	}
	
	@RequestMapping(value = "/departments/{id}/parentDept", method = RequestMethod.GET)
	public Department getParentDepartment(@PathVariable int id) {
		Department department = departmentService.findParentDept(id);
		return department;
	}
	
}
