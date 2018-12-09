package cn.imooc.service;

import java.util.List;
import java.util.Set;

import cn.imooc.pojo.Department;
import cn.imooc.pojo.Employee;
import cn.imooc.pojo.PageBean;

/**
 * Department类业务层接口
 * @author Administrator
 *
 */
public interface IDepartmentService {

 

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	void edit(Department department);

	void delete(Department department);

	Department findById(int did);

	List<Department> findAll();

	Set<Employee> findAll(int i);

	List<Employee> findEmployeeByDid(int i);

 
}
