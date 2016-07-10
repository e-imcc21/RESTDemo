package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import pojo.Department;
@Repository
public class DepartmentDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private static final Log log = LogFactory.getLog(DepartmentDAO.class);

	public void saveOrUpdate(Department department) {
		log.debug("saving Department instance");
		try {
			hibernateTemplate.saveOrUpdate(department);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Department department) {
		log.debug("deleting Department instance");
		try {
			hibernateTemplate.delete(department);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Department findById(int id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) hibernateTemplate.get(Department.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	
	public List<Department> findByParentDeptId(int parentDeptId) {
		log.debug("getting Department instance with parentDeptId: " + parentDeptId);
		try {
			String qryString = "from pojo.Department as model where model.parentDeptId = ?";
			return (List<Department>) hibernateTemplate.find(qryString,parentDeptId);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Department> findAll() {
		log.debug("finding all Department instances");
		try {
			String qryString = "from Department";
			return (List<Department>) hibernateTemplate.find(qryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}