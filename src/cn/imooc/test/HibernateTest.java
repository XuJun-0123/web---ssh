package cn.imooc.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.imooc.pojo.Department;
import cn.imooc.pojo.Employee;
import cn.imooc.service.IDepartmentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

/**
 * 级联保存
 */
	@Test
	public void test() {
		
		Department department=new Department(5, "运营部"	, "搞运营");
		Employee employee=new Employee(7, "邓超", "男", new Date(), new Date(), "7", "我是超哥", "123456");
		department.getEmployees().add(employee);
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		IDepartmentService departmentService= act.getBean(IDepartmentService.class);
		departmentService.save(department);
	}
/**
 * 只更新一个表
 */
	@Test
	public void testModifyOne() {
		
		 
	}
	/**
	 * 更新两个表
	 */
	@Test
	public void testModifyTwo() {
		
		 
	}
 
}
