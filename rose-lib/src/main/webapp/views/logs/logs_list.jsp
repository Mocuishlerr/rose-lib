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
<script type="text/javascript" src="js/func.js"></script>
<script type="text/javascript" src="js/pager.js"></script>
<link href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<% String path=request.getContextPath(); %>
<title>操作记录</title>
<style type="text/css">

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
          <a class="navbar-brand">操作记录</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path %>/book?p=1"><span class="glyphicon glyphicon-list">书籍列表</span></a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
 </div><br><br>
	<div align="center">
	<table cellpadding="0" cellspacing="0" border="1" width="100%" class="altrowstable" id="alternatecolor">
			<tr><th>操作ID</th><th>操作人</th><th>资源模式</th><th>资源地址</th><th>是否成功</th><th>额外说明</th><th>创建时间</th>
			</tr>
			<c:forEach var="item" items="${operLogs}">
				<tr>
					<td>${item.id }</td>
					<td>${item.userName }</td>
					<td>${item.resourcePattern }</td>
					<td>${item.resourceId }</td>
					<td>${item.success }</td>
					<td>${item.remarks }</td>
					<td>${item.createTime }</td>
				</tr>
			</c:forEach>
	</table>
	</div>
	<div class="mod_page" style="text-align: center;">
        <script type="text/javascript">pagerUtil.init(4,1,<%=request.getAttribute("count")%>);</script>  
    </div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>