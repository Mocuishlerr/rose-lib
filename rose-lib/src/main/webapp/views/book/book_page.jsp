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
<title>查看书籍信息</title>
<style type="text/css">
a{
	text-decoration: none;
	color: blue;
}
.delete{
	background: #3ba0e4;
    height: 25px;
    border: 1px;
    cursor: pointer;
    border-radius: 2px;
}
.tab{
    border-style: solid;
	border-color: #a9c6c9;
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
          <a class="navbar-brand">查看书籍信息</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
            <li><a href="<%=path %>/book/${book.id }?edit=true"><span class="glyphicon glyphicon-edit">修改该书信息</span></a></li> 
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
 </div><br><br><br><br>
	<div align="center">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
	书的序号：<span>${book.bookId }</span><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;书的名称：<span>${book.name }</span><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
	书的价格：<span>${book.price }</span><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;书的作者：<span>${book.author }</span><br>
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;书的类型：<span>${book.bookType }</span><br>
	书的创建时间：<span>${book.createTime }</span><br>
	</div>
	<p style="color:#5B4B00;font-size:20px;">书籍的评论</p>
	<form action="<%=path %>/book/${book.id }/remark/deleteAll" method="post">
		<input type="hidden" value="${book.id }" name="bookId"/>
		<input type="submit" value="删除所有评论" class="delete"/>
	</form>
	<table width="500" border="1" cellpadding="0" cellspacing="0" class="tab">
    <c:forEach var="item" items="${remarks }">
    <tr>
        <td style="font-size: 12px;">
        	${item.id }&nbsp;&nbsp;
        	${item.userName }&nbsp;&nbsp;
        	${item.createTime }<br>
        <span style="font-size: 20px;">${item.essay }</span>	
			<form action="<%=path %>/book/${book.id }/remark/${item.id }/delete" method="post">
				<input type="hidden" value="${book.id }" name="bookId"/>
				<input type="hidden" value="${item.id }" name="remarkId"/>
				<input type="submit" value="删除此评论" class="delete"/>
			</form>
        </td>
    </tr>
    </c:forEach>
	</table><br>
	<form action="<%=path %>/book/${book.id }/remark/add" method="post">
		<input type="hidden" value="${book.id }" name="bookId"/>
		<textarea name="essay" rows="6" cols="80" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"></textarea>  
		<input type="submit" value="提交评论" class="delete"/>
	</form><br>
	<font color=red>${remark_error}</font>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>