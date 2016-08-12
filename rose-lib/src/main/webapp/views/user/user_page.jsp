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
<title>查看用户信息</title>
<style type="text/css">
a{
	text-decoration: none;
	color: blue;
}
.btn{
    background: #3ba0e4;
    width: 106px;
    height: 25px;
    border: 1px;
    cursor: pointer;
    border-radius: 2px;
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
          <a class="navbar-brand">查看用户信息</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
            <li><a href="<%=path %>/user/${user.id }?edit=true"><span class="glyphicon glyphicon-edit">修改用户信息</span></a></li> 
          </ul>
        </div>
      </div>
 </div><br><br><br><br>
	<div align="center">
	ID：${user.id }<br>
	登录名：${user.loginName }<br>
	姓名：${user.name }<br>
	用户组别：
	<c:choose>
		<c:when test="${user.groups == 0 }">普通用户</c:when>
			<c:otherwise>管理用户</c:otherwise>
	</c:choose>	<br>
	创建时间：${user.createTime }<br>
	<form action="<%=path %>/user/${user.id }/delete" method="post">
		<input type="submit" value="注销此用户" class="btn"/>
	</form>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>