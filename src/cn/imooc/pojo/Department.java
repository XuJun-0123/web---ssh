package cn.imooc.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门类
 * @author Administrator
 *
 */
public class Department {
	private int did;
	private String dname;
	private String ddesc;
	
	//员工的集合
	private Set<Employee> employees=new HashSet<>();
	
	public Department() {
		super();
	}
	public Department(int did, String dname, String ddesc) {
		super();
		this.did = did;
		this.dname = dname;
		this.ddesc = ddesc;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", ddesc=" + ddesc + ", employees=" + employees + "]";
	}
 
}
