<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<% String path=request.getContextPath(); %>
<title>修改用户信息</title>
<style type="text/css">
a{
	text-decoration: none;
	color: blue;
}
.btn{
        padding:8px;
 		border:0;
		border-radius:5px;
        font-family:'方正静蕾简体';
		font-size:18px;
		cursor:pointer;
		margin-top: 10px;
		margin-bottom: 10px;
}
.inputTxt{
	     text-align:center;
         height: 25px;
         widows: 200px;
         margin-bottom: 5px;
	 }
</style>
</head>
<body>
  <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">修改用户详细信息</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
             <li><a href="<%=path %>/user"><span class="glyphicon glyphicon-headphones">所有用户</span></a></li>  
          </ul>
        </div>
      </div>
 </div><br><br><br><br>
	<div align="center">
	<form action="<%=path %>/user/${user.id }/info/update" method="post">
		ID：${user.id }<br>
		<input type="hidden" value="${user.id }" name="id"/>
		登录名：<input type="text" value="${user.loginName }" name="loginName" class="inputTxt"/><br>
		姓名：<input type="text" value="${user.name }" name="name" class="inputTxt"/><br>
		用户组别：
		<c:choose>
			<c:when test="${user.groups == 0 }">普通用户</c:when>
			<c:otherwise>管理用户</c:otherwise>
		</c:choose>	<br>
		创建时间：${user.createTime }<br>
		<input type="submit" value="提交修改" class="btn"/><br>
	</form><br><br><br>
	
	<form action="<%=path %>/user/${user.id }/password/update" method="post">
		<input type="hidden" value="${user.id }" name="id"/>
		旧密码： <input type="password" value="" name="old_password" class="inputTxt"/><br>
		密码： <input type="password" value="" name="password" class="inputTxt"/><br>
		确认密码：<input type="password" value="" name="password2" class="inputTxt"/><br>
		<input type="submit" value="提交修改" class="btn"/><br>
	</form>
	<br><font color=red>${error }</font>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>