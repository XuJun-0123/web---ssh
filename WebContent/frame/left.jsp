<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('1','-1','员工管理系统');
    d.add('2','1','人力资源部');
    d.add('3','2','部门管理','department_findAll','','right','img/cd.gif');

    d.add('4','2','员工管理','${pageContext.request.contextPath}/employee_findAll','','right','img/cd.gif');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>
