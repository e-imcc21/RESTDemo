package service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import dao.DepartmentDAO;
import dao.EmployeeDAO;

import pojo.Department;
import pojo.Employee;

@Service
public class EmployeeService {
	private final Log log = LogFactory.getLog(EmployeeService.class);
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	DepartmentDAO departmentDAO;
	
	public Employee findById(java.lang.Integer id) {
		return employeeDAO.findById(id);
	}

	public void save(Employee employee) {
		employeeDAO.saveOrUpdate(employee);
	}

	public void Update(Employee employee) {
		employeeDAO.saveOrUpdate(employee);
	}

	public void delete(int id) {
		Employee obj = employeeDAO.findById(id);
		if(obj != null){
			employeeDAO.delete(obj);
		}
		 
	}

   /** 
    * retrieve all the employees
    * @return
    */
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
	public List<Employee> findEmployeesByDepartmentId(int id) {
		return employeeDAO.findByDepartmentId(id);
	}

	public Department findDepartmentOfAnEmployee(int employeeId) {
		Employee  employee = employeeDAO.findById(employeeId);
		if(employee == null){
			return null;
		}
		int deptId = employee.getDepartmentId();
		return departmentDAO.findById(deptId);
	}
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
}
