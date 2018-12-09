package cn.imooc.dao;

import java.util.List;

import cn.imooc.pojo.Employee;

public interface IEmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int beginPage, int pageSize);

	Employee findById(int eid);

	void update(Employee employee);

	void save(Employee employee);
	

	
}
