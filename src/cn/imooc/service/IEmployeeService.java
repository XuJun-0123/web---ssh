package cn.imooc.service;

import cn.imooc.pojo.Employee;
import cn.imooc.pojo.PageBean;

/**
 * 管理员工的业务层接口
 * @author Administrator
 *
 */
public interface IEmployeeService {

	Employee findByUsernameAndPassword(Employee employee);

	PageBean<Employee> findByPage(int currentPage);

	Employee findById(int eid);

	void update(Employee employee);

	void add(Employee employee);
	
}
