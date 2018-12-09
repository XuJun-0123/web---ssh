<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<sx:head />
<head></head>

<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/> 

<s:form id="saveForm" method="post" action="employee_save.action" namespace="/" theme="simple" >

<table border='0' cellpadding="0"  cellspacing="10">
<tr>

<td>姓名：</td>
<td><s:textfield name="ename"/></td>
<td>性别：</td>
<td><s:radio list="{'男','女'}" name="sex"/></td>
</tr>
<tr>
<td>出生日期：</td>
<td><sx:datetimepicker value="%{'today'}" name="birthday"/>
</td>
<td>入职时间：</td>
<td><sx:datetimepicker value="%{'today'}" name="joinDate"/>
</tr>

<tr>
<td>所属部门：</td>
<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="请选择"></s:select></td>
<td>编号：</td>
<td><s:textfield   name="eno"/></td>
</tr>
</table>

</s:form>
</body>
</html>