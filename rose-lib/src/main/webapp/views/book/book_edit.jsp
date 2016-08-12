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
<title>修改书籍信息</title>
<style type="text/css">
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
          <a class="navbar-brand">修改书的详细信息</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
 </div><br><br><br><br>
	<div align="center">
	<form action="<%=path %>/book/${book.id }/update" method="post">
		书的ID：${book.id }<br><input type="hidden" value="${book.id }" name="id"/>
		书的序号：<input type="text" value="${book.bookId }" name="name" class="inputTxt"/><br>
		书的名称：<input type="text" value="${book.name }" name="name" class="inputTxt"/><br>
		书的价格：<input type="text" value="${book.price }" name="price" class="inputTxt"/><br>
		书的作者：<input type="text" value="${book.author }" name="author" class="inputTxt"/><br>
		书的类型：<input type="text" value="${book.bookType }" name="bookType" class="inputTxt"/><br>
		书的创建时间：${book.createTime }<br>
		<input type="submit" value="提交修改"/><br>
		<font color=red>${error }</font>
	</form>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>