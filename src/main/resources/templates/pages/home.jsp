<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=path%>/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/home.css"/>
	</head>
	<body>
		<div class="head fix">
			<div class="t1 fix">
				<div class="tl"><a href="<%=path%>/home/toHome.action">Keep Coding</a></div>
				<div class="tr">
					<ul class="ur">
						<li><a href="<%=path%>/home/toHome.action">HOME</a></li>
						<li><a href="<%=path%>/home/toAbout.action">ABOUT</a></li>
						<li><a href="<%=path%>/home/toArchive.action">ARCHIVE</a></li>
						<li><a href="<%=path%>/home/toTags.action">TAGS</a></li>
						<li><a href="<%=path%>/home/toWorks.action">WORKS</a></li>
					</ul>
				</div>
			</div>
			
			<div class="tt">
				<div class="t2">千锤百炼</div>
				<div class="t3">邹洪学</div>
			</div>
		</div>
		<div class="content">
			<c:forEach items="${articles }" var="article">
				<div class="item">
					<div class="h2"><a class="h2" href="<%=path%>/single/getDetail.action?id=${article.id}&opt=1">${article.title }</a></div>
					<div class="text">	
						<a class="text" href="<%=path%>/single/getDetail.action?id=${article.id}&opt=1"><pre>${article.content }</pre></a>
					</div> 
					<div class="text_en">Posted on ${article.date }</div>
				</div>
			</c:forEach>
		</div>
		<div class="footer">
			© 2017 Zhx ❖ Powered by MySelf.
		</div>
	</body>
</html>
