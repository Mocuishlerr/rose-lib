<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<link rel="stylesheet" type="text/css" href="css/pager.css">
		<link rel="stylesheet" type="text/css" href="css/sweetalert.css">
		<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
		<% String path=request.getContextPath(); %>
		<title>浏览书目</title>
		<style type="text/css">
		body {
             padding-top: 50px;
             padding-left: 50px;
        }
		  .delete{
		     background: #787878;
		     color:white;
             width: 76px;
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
          <a class="navbar-brand">所有书籍</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
            <li><a href="<%=path %>/book/add"><span class="glyphicon glyphicon-plus">增加一本书</span></a></li>
            <li><a href="<%=path %>/user/add"><span class="glyphicon glyphicon-plus-sign">增加一个新用户</span></a></li>
            <li><a href="<%=path %>/user/my"><span class="glyphicon glyphicon-user">用户中心</span></a></li>
            <li><a href="<%=path %>/user"><span class="glyphicon glyphicon-headphones">所有用户</span></a></li>          
            <li><a href="<%=path %>/logs?p=1"><span class="glyphicon glyphicon-eye-open">操作日志</span></a></li>
            <li><a href="<%=path %>/user/logout"><span class="glyphicon glyphicon-off">退出登录</span></a></li>
          </ul>
        </div>
      </div>
    </div>
	<div align="center">
	<div id="search">
	  <form action="<%=path %>/book?page=1" method="post">
	     <select name="search">
	       <option value="name">书名</option>
	       <option value="author">作者</option>
	     </select>
	     <input type="text" name="string">
	     <input type="submit" class="delete" value="搜索">
	  </form>
	</div>
		<table cellpadding="0" cellspacing="0" border="1" width="90%" class="altrowstable" id="alternatecolor">
			<tr><th>No.</th><th>书目序号</th><th>书名</th><th>价格</th><th>作者</th><th>分类</th><th>状态</th><th>添加时间</th><th>操作</th>
			</tr>
			<c:forEach var="item" items="${books}" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${item.bookId }</td>
					<td><a href="<%=path %>/book/${item.id }">${item.name }</a></td>
					<td>${item.price }</td>
					<td>${item.author }</td>
					<td>${item.bookType }</td>
					<td>${item.bookStatus }</td>
					<td>${item.createTime }</td>
					<td>
						<form action="<%=path %>/book/${item.id }/delete" method="post">
							<input type="hidden" value="${item.id }" name="id"/>
							<input type="submit" value="删除" class="delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="mod_page" style="text-align: center;">
        <script type="text/javascript">pagerUtil.init(4,1,<%=request.getAttribute("bookCount")%>);</script>  
<!-- 
pre 	——当前页前面标签个数
next	——当前页后面标签个数
total	——总页数 
--> 
    </div>
    <script type="text/javascript" src="js/func.js"></script>
    <script type="text/javascript" src="js/pager.js"></script>
    <script type="text/javascript" src="js/sweetalert.js"></script>
    <!-- jQuery (Bootstrap 插件需要引入) -->
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 包含了所有编译插件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</body>
</html>