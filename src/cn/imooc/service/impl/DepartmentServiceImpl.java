package cn.imooc.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import cn.imooc.dao.IDepartmentDao;
import cn.imooc.dao.impl.DepartmentDaoImpl;
import cn.imooc.pojo.Department;
import cn.imooc.pojo.Employee;
import cn.imooc.pojo.PageBean;
import cn.imooc.service.IDepartmentService;
/**
 * Department类service实现类
 * @author Administrator
 *
 */
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	private IDepartmentDao departmentDao;
	//分页查询方法
	@Override
	public PageBean<Department> findByPage(Integer currentPage) {
		PageBean<Department> pageBean=new PageBean<>();
		pageBean.setCurrentPage(currentPage);
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		int totalCount=departmentDao.findCount(); 
		pageBean.setTotalCount(totalCount);
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin=(currentPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
		
	}
	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	@Override
	//保存部门的方法
	public void save(Department department) {
		departmentDao.save(department);
	}
	@Override
	//编辑部门的方法
	public void edit(Department department) {
		departmentDao.edit(department);
	}
	@Override
	public void delete(Department department) {
		
		departmentDao.delete(department);
	}
	@Override
	public Department findById(int did) {
		Department department=departmentDao.findById(did);
		return department;
	}
	@Override
	public List<Department> findAll() {
		List<Department> list=departmentDao.findAll();
		return list;
	}
	@Override
	public Set<Employee> findAll(int i) {
		Department department=departmentDao.findById(i);
		return department.getEmployees();
		
	}
	@Override
	public List<Employee> findEmployeeByDid(int did) {
			List<Employee> list=departmentDao.findEmployeeByDid(did);
			return list;
	}

 
}
