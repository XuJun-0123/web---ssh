package cn.imooc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.imooc.pojo.Department;
import cn.imooc.pojo.Employee;
import cn.imooc.pojo.PageBean;
import cn.imooc.service.IDepartmentService;
import cn.imooc.service.IEmployeeService;
import cn.imooc.service.impl.EmployeeServiceImpl;

/**
 * 管理员工的action
 * 
 * @author Administrator
 *
 */

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	private Employee employee = new Employee();
	// 1. 定义list变量
    private List<Employee> list = new ArrayList<Employee>();
    
    // 2. 生成get方法

	public List<Employee> getList() {
		return list;
	}

	
    public String execute2() {
        //3 向list中设置值
        Employee employee = new Employee();
        employee.setEname("小奥");
        employee.setPassword("123");
 
        
        Employee employee2 = new Employee();
        employee2.setEname("小王");
        employee2.setPassword("250");
 
        
        list.add(employee);
        list.add(employee2);
        return "findAll";
    }
  //1. 声明变量
    public String name;

    //2. 生成变量的get方法
    public String getName(){
        return name;
    }
 
 

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}

	private IEmployeeService employeeService;
	private int currentPage=1;
	private IDepartmentService departmentService;
	private Set<Department> set;
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService; 
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Set<Department> getSet() {
		return set;
	}


	public String login() {
		Employee existEmployee = employeeService.findByUsernameAndPassword(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码错误！！！");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}

	}
	//获取输出对象
	public static PrintWriter getInstance() throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		 PrintWriter printWriter=response.getWriter();
		 return printWriter;
	}
	public String findAll()
	{
		Employee employee=(Employee) ActionContext.getContext().getSession().get("existEmployee");
		set=employee.getDepartments();
		
		return "findAll";
//		PageBean<Employee> pageBean=employeeService.findByPage(currentPage);
//		ActionContext.getContext().getValueStack().push(pageBean);
//		return "findAll";
	}
	public String saveUI()
	{
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	public String save()
	{
		employeeService.add(employee);
		return "saveSuccess";
	}
	public String update()
	{
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "update";
	}
	public String updateSuccess()
	{
		employeeService.update(employee);
		return "updateSuccess";
	}
	
}
