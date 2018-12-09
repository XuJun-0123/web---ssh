<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>员工管理系统</title>
</head>
<html>
<frameset rows="80,*" frameBorder="no">
   <frame  src="${pageContext.request.contextPath }/frame/top.jsp" scrolling="no"/ >
   <frameset cols="150,*" id="main" frameborder="no">
	 
      <frame src="${pageContext.request.contextPath }/frame/left.jsp" scrolling="no" name="left" target="left"/> 
     <frame src="${pageContext.request.contextPath }/frame/right.jsp" scrolling="no"  name="right" target="right"/>
   </frameset>
</frameset>

<noframes>  <!--不支持框架-->
<body>
您的浏览器不支持框架？不过像你的浏览器，真的不太好找
</body>
</noframes>
</html>
