package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import pojo.Employee;
/**
 * 
 * @author yuqq
 * 2016-7-8
 */
@Repository
public class EmployeeDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private static final Log log = LogFactory.getLog(EmployeeDAO.class);

	public void saveOrUpdate(Employee employee) {
		log.debug("saving Employee instance");
		try {
			hibernateTemplate.saveOrUpdate(employee);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Employee employee) {
		log.debug("deleting Employee ");
		try {
			hibernateTemplate.delete(employee);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Employee findById(int id) {
		log.debug("getting Employee instance with id: " + id);
		try {
			Employee instance = (Employee) hibernateTemplate.get(Employee.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Employee> findByDepartmentId(int departmentId) {
		log.debug("getting Employees with departmentId: " + departmentId);
		List<Employee> results;
		try {
			results = (List<Employee>) hibernateTemplate.find(
					"from pojo.Employee as model where model.departmentId=?", departmentId);
			return results;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
   /** 
    * retrieve all the employees
    * @return
    */
	public List<Employee> findAll() {
		log.debug("finding all Employee instances");
		try {
			String queryString = "from pojo.Employee";
			return (List<Employee>) hibernateTemplate.find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
}