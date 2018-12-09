package cn.imooc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.thoughtworks.xstream.core.util.ThreadSafeSimpleDateFormat;

import cn.imooc.dao.IEmployeeDao;
import cn.imooc.pojo.Employee;
/**
 * 
 * @author Administrator
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements IEmployeeDao  {

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql="from Employee where username= :username and password= :password";
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		List<Employee> list=session.createQuery(hql)
				.setParameter("username", employee.getUsername())
				.setParameter("password", employee.getPassword())
				.getResultList();
		if (list.size()>0) {
			return list.get(0);
		}
		session.close();
		return null;
	}

	@Override
	//查询所有员工的数量
	public int findCount() {
		String hql="select count(*) from Employee";
		 List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		 if (list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	//根据页数查询员工
	public List<Employee> findByPage(int beginPage, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> list=(List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, beginPage, pageSize);
		 return list;
	}

	@Override
	public Employee findById(int eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

}
