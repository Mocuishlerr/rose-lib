<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<% String path=request.getContextPath(); %>
<title>登陆</title>
<style type="text/css">
   body{font-family:'方正静蕾简体';
	      font-size:25px;}
     .form{
	    width:500px;
		/*块元素居中*/
		margin:0 auto;
		border:4px solid #FFBBFF;
		background:#FF8247;
		/* css3 圆角 */
        border-radius:10px;
	 }

	 .form p input{
	    width:120px;
	 }
	 .form input:focus{
	    background:#FFEC8B;
	 }
	 .form div{
	    padding:10px;
		background:#FF6347;
		text-align:center;
		border-radius:0 0 6px 6px;
	 }
</style>
</head>
<body>
	<h1 style="text-align:center">请先登录</h1>
	<div align="center" class="form">
	<form action="<%=path %>/login" method="post">
		登录名：<input type="text" value="${loginName }" name="loginName" class="inputTxt"/><br>
&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" value="" name="password" class="inputTxt"/><br>
		<input type="submit" value="登陆" class="btn"/><br>
		<font color=red>${error }</font>
	</form>
	</div>
</body>
</html>