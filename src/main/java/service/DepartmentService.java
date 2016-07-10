package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Department;
import dao.DepartmentDAO;

import pojo.Employee;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDAO departmentDAO;
	public Department findById(int id) {
		return departmentDAO.findById(id);
	}

	public void Update(Department department) {
		departmentDAO.saveOrUpdate(department);
	}

	public void delete(int id) {
		Department department = departmentDAO.findById(id);
		if(department != null){
			departmentDAO.delete(department);			
		}

	}

	public void save(Department department) {
		departmentDAO.saveOrUpdate(department);
	}

	public List<pojo.Department> findAll() {
		return departmentDAO.findAll();
	}

	public List<Department> findByParentDeptId(int parentDeptId) {
		return departmentDAO.findByParentDeptId(parentDeptId);
	}

	public Department findParentDept(int subDeptId) {
		Department subDept  = departmentDAO.findById(subDeptId);
		if (subDept == null) return null;
		int parentDeptId = subDept.getParentDeptId();
		return departmentDAO.findById(parentDeptId);
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	 
}
