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
		<link rel="stylesheet" href="<%=path %>/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/archive.css"/>
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
				<div class="t2">Archive</div>
				<div class="t3">My Life  |  用文字记录一生</div>
			</div>
		</div>
		<div class="content">
			<ul class="u1">
				<c:forEach items="${lifes }" var="life">
					<li><span>${life.date }</span><span><a href="<%=path%>/single/getDetail.action?id=${life.id}&opt=2">${life.title }</a></span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="footer">
			© 2017 Zhx ❖ Powered by MySelf.
		</div>
	</body>
</html>
