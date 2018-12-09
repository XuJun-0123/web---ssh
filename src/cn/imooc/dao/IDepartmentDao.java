package cn.imooc.dao;

import java.util.List;

import cn.imooc.pojo.Department;
import cn.imooc.pojo.Employee;

/**
 * Department类Dao接口
 * @author Administrator
 *
 */
public interface IDepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	void edit(Department department);

	void delete(Department department);

	Department findById(int did);

	List<Department> findAll();
	
	void save(Employee employee);
	//内连接查询测试

	List<Employee> findEmployeeByDid(int did);
}
