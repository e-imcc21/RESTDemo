package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pojo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/applicationContext.xml"})
@Transactional
@Rollback(true)
public class EmployeeDAOTest {
	@Autowired 
	private EmployeeDAO employeeDAO;
 
	@Test
	public void getAllTest(){
		assertEquals(2,employeeDAO.findAll().size());
	}
	@Test
	public void getByIdTest(){
		Employee obj = employeeDAO.findById(1);
		assertNotNull(obj);
		assertTrue(obj.getId() == 1);
		
		obj = employeeDAO.findById(-1);
		assertNull(obj);
		
	}
	@Test
	public void findByDepartmentIdTest(){
		List<Employee> list = employeeDAO.findByDepartmentId(1);
		assertEquals(list.size(),2);
		list = employeeDAO.findByDepartmentId(3);
		assertEquals(list.size(),0);
	}
	@Test
	public void UpdateTest(){
		Employee obj = employeeDAO.findById(1);
		obj.setFistName("tempFirstName");
		employeeDAO.saveOrUpdate(obj);
	}

	@Test
	@Rollback(true)
	public void saveTest(){
		Employee obj = new Employee();
		obj.setFistName("tempName");
		obj.setBirthDate("20160102");
		obj.setDepartmentId(1);
		obj.setGender("1");
		obj.setGrade("10");
		obj.setLastName("lastName");
		obj.setLdapUserName("ldapUserName");
		obj.setTitle("title");
		employeeDAO.saveOrUpdate(obj);
		assertEquals(3,employeeDAO.findAll().size());
	}
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
