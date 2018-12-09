<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">员工管理</td>
		</tr>
		<tr>
			<td align="right"><a href="${pageContext.request.contextPath }/employee_saveUI.action">添加</a></td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<s:iterator value="list" var="e">
				<tr>
					<td align="center"><s:property value="list[0].ename"/></td>
					<td align="center"><s:property value="#e.password"/></td>
					<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
					<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
					<td align="center"><s:property value="#e.department.dname"/></td>
					<td align="center"><a href="${pageContext.request.contextPath }/employee_update?eid=<s:property value='#e.eid'/>"/>编辑</td>
				</tr>
			</s:iterator>

		</thead>
	</table>
	<br />

	<table table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td align="right"><span>第<s:property value="currentPage"/>/<s:property value="totalPage"/>页</span> 
			<s:if test="currentPage!=1">
			<a href="${pageContext.request.contextPath}/employee_findAll?currentPage=1">[首页]</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/employee_findAll?currentPage=<s:property value='currentPage-1'/>">[上一页]</a>&nbsp;&nbsp;
			</s:if>
			<s:if test="currentPage!=totalPage">
			 <a href="${pageContext.request.contextPath}/employee_findAll?currentPage=<s:property value='currentPage+1'/>">[下一页]</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/employee_findAll?currentPage=<s:property value='totalPage'/>">[尾页]</a>&nbsp;&nbsp; </span></td>
				</s:if>
		</tr>
	</table>
</body>
</html>