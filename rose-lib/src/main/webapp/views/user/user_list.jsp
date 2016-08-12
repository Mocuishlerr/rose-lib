<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/func.js"></script>
<% String path=request.getContextPath(); %>
<title>所有用户</title>
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
          <a class="navbar-brand">所有用户</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
            <li><a href="<%=path %>/user/add"><span class="glyphicon glyphicon-plus-sign">增加一个新用户</span></a></li> 
          </ul>
        </div>
      </div>
 </div><br><br><br><br>
	<div align="center">
	<table border="1" cellpadding="0" cellspacing="0" width="70%" class="altrowstable" id="alternatecolor">
			<tr><th>用户ID</th><th>登录名</th><th>姓名</th><th>用户组别</th><th>创建时间</th>
			</tr>
			<c:forEach var="item" items="${users}">
				<tr>
					<td>${item.id }</td>
					<td><a href="<%=path %>/user/${item.id }">${item.loginName }</a></td>
					<td>${item.name }</td>
					<td>
					<c:choose>
						<c:when test="${item.groups == 0 }">普通用户</c:when>
						<c:otherwise>管理用户</c:otherwise>
					</c:choose></td>
					<td>${item.createTime }</td>
				</tr>
			</c:forEach>
	</table>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>