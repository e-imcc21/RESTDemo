package dao;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/applicationContext.xml"})
@Transactional
@Rollback(true)
public class DepartmentDAOTest {
	@Autowired 
	private DepartmentDAO departmentDAO;
	@Test
	public void getAllTest(){
		assertEquals(3,departmentDAO.findAll().size());
	}
	@Test
	public void getByIdTest(){
		Department obj = departmentDAO.findById(1);
		assertNotNull(obj);
		assertTrue(obj.getId() == 1);
		
		obj = departmentDAO.findById(-1);
		assertNull(obj);
		
	}
	@Test
	public void findByParentDeptIdTest(){
		List<Department> list = departmentDAO.findByParentDeptId(1);
		assertEquals(list.size(),2);
		list = departmentDAO.findByParentDeptId(2);
		assertEquals(list.size(),0);
	}
	@Test
	public void UpdateTest(){
		Department obj = departmentDAO.findById(1);
		obj.setLocation("temp位置");
		departmentDAO.saveOrUpdate(obj);
	}

	@Test
	@Rollback(true)
	public void saveTest(){
		Department obj = new Department();
		obj.setName("tempName");
		obj.setLocation("temp位置2");
		departmentDAO.saveOrUpdate(obj);
		assertEquals(4,departmentDAO.findAll().size());
	}
}
