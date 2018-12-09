<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/style/sys.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
 <s:form id="saveForm" method="post" action="department_save" namespace="/" theme="simple">
<table style="font-size::16px">
<tr>
  <td>部门名称：</td>
  <td><s:textfield name="dname"></s:textfield></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td></td>
  <td>
    <s:textarea rows="5" cols="50" name="ddesc"></s:textarea>
  </td>
</tr>
</table>
</s:form>
</body>
</html> 