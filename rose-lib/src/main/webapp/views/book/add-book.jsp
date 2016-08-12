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
<title>增加一本书</title>
<style type="text/css">
/*格式化按钮*/
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
	 a{
		     text-decoration: none;
		     color: blue;
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
          <a class="navbar-brand">增加一本书</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
 </div><br><br><br><br>
	<div align="center">
	<form action="<%=path %>/book/add" method="post">
		书的序号：<input type="text" value="" name="bookId" class="inputTxt"/><br>
		书的名称：<input type="text" value="" name="name" class="inputTxt"/><br>
		书的价格：<input type="text" value="" name="price" class="inputTxt"/><br>
		书的作者：<input type="text" value="" name="author" class="inputTxt"/><br>
		书的类型：<input type="text" value="" name="bookType" class="inputTxt"/><br>
		<input type="submit" value="增加" class="btn"/><br>
		<font color=red>${error }</font>
	</form>
	</div>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>