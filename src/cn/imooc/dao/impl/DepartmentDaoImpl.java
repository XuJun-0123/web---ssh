package cn.imooc.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import cn.imooc.dao.IDepartmentDao;
import cn.imooc.pojo.Department;
import cn.imooc.pojo.Employee;
import cn.imooc.service.impl.HibernateUtil;

/**
 * Department类Dao层实现类
 * 
 * @author Administrator
 *
 */
public class DepartmentDaoImpl extends HibernateUtil<Department> implements IDepartmentDao {
 
/*	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Department.class);
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
	 
		return list.get(0).intValue();
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> list=(List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	// DAO中保存部门的方法
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	//DAO中编辑部门的方法
	public void edit(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	//DAO中删除部门的方法
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@Override
//DAO中根据did查询部门的方法
	public Department findById(int did) {
		Department department=this.getHibernateTemplate().load(Department.class, did);
		this.getHibernateTemplate().evict(department);
		Set<Employee> set=department.getEmployees();
		for (Employee employee : set) {
			employee.setEname("李云龙");
		}
		return department;
	}

	@Override
	public List<Department> findAll() {
		List<Department> list=(List<Department>) this.getHibernateTemplate().find("from Department");
		return list;
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}*/
	//内连接查询测试

	@Override
	public List<Employee> findEmployeeByDid(int did) {
		String sql="from Employee e inner join department_employee_relation d on e.eid=d.eid ";
		List<Employee> list=(List<Employee>) findBySql(sql);
		return list; 
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}
}
