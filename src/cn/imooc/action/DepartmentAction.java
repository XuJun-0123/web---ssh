package cn.imooc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
/**
 * Department类action
 * @author Administrator
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	Department department=new Department();
	String number,callback;
	public void setCallback(String callback) {
		this.callback = callback;
	}
	 public void setNumber(String number) {
		this.number = number;System.out.println("number:"+number);
	}
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	private IDepartmentService departmentService;
	private int currentPage=1;
	private Set<Employee> set;
	public void setCurrentPage(int currentPage)
	{
		this.currentPage=currentPage; 
	}
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String findAll()
	{
		PageBean<Department>  pageBeans=departmentService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBeans); 
		return "findAll";
	}
	/**
	 * 添加department的方法
	 */
	public String saveUI()
	{
		return "saveUI";
	}
	public String save()
	{
		departmentService.save(department);
		return "saveSuccess";
	}
	public String edit() {
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	public String update()
	{
		departmentService.edit(department);
		return "updateSuccess";
	}

	public String delete()
	{
		department= departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	public String getJson() throws IOException
	{
		String result="[{ \r\n" + 
				"\r\n" + 
				"  \"name\": \"足球\"\r\n" + 
				"\r\n" + 
				"},{ \r\n" + 
				"\r\n" + 
				"  \"name\": \"散步\"\r\n" + 
				"\r\n" + 
				"},{ \r\n" + 
				"\r\n" + 
				"  \"name\": \"篮球\"\r\n" + 
				"\r\n" + 
				"},{ \r\n" + 
				"\r\n" + 
				"  \"name\": \"乒乓球\"\r\n" + 
				"\r\n" + 
				"},{ \r\n" + 
				"\r\n" + 
				"  \"name\": \"骑自行车\"\r\n" + 
				"\r\n" + 
				"}]";
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
	    // 指定特定域名可以访问
//	    response.setHeader("Access-Control-Allow-Origin", "http:localhost:8080/");
	    //前端传过来的回调函数名称
	    //用回调函数名称包裹返回数据，这样，返回数据就作为回调函数的参数传回去了
//	    result = callback + "(" + result + ")";
	    	
	    response.getWriter().write(result);
		return NONE;
	}
	//获取输出对象
	public static PrintWriter getInstance() throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		 PrintWriter printWriter=response.getWriter();
		 return printWriter;
	}
	public void findAllEmployee() {
	
		 set=departmentService.findAll(14);
		 try {
			getInstance().print(set);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public void findEmployeeByDid() {
		List<Employee> list=departmentService.findEmployeeByDid(14);
		try {
			getInstance().print(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
