package cn.imooc.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.imooc.dao.IEmployeeDao;
import cn.imooc.pojo.Employee;
import cn.imooc.pojo.PageBean;
import cn.imooc.service.IEmployeeService;
@Transactional 
public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao employeeDao;

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public Employee findByUsernameAndPassword(Employee employee) {
	Employee employee2=	employeeDao.findByUsernameAndPassword(employee);
		return employee2;
	}
	@Override
	public PageBean<Employee> findByPage(int currentPage) {
		 PageBean<Employee> pageBean=new PageBean<>();
		 pageBean.setCurrentPage(currentPage);
		 int totalCount=employeeDao.findCount();
		 int pageSize=3;
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		double tc=totalCount;
		Double totalPage=Math.ceil(tc/pageSize); 
		pageBean.setTotalPage(totalPage.intValue());
		int beginPage=(currentPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(beginPage,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Employee findById(int eid) {
		Employee employee= employeeDao.findById(eid);
		
		return employee;
	}
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	@Override
	public void add(Employee employee) {
		employeeDao.save(employee);
	} 
 

}
