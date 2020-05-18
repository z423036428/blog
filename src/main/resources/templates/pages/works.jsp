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
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/works.css"/>
	</head>
	<body>
		<div class="head fix">
			<div class="t1 fix">
				<div class="tl">Keep Coding</div>
				<div class="tr">
					<ul class="ur">
						<li><a href="home.html">HOME</a></li>
						<li><a href="about.html">ABOUT</a></li>
						<li><a href="archive.html">ARCHIVE</a></li>
						<li><a href="tags.html">TAGS</a></li>
						<li><a href="works.html">WORKS</a></li>
					</ul>
				</div>
			</div>
			
			<div class="tt">
				<div class="t2">Works</div>
				<div class="t3">态度决定一切</div>
			</div>
		</div>
		<div class="content">
			<div class="c1">
				<p class="title">故事与人生</p>
				<ul>
					<p>说说我自己的故事:</p>
					<c:forEach items="${mystories }" var="mystory">
						<li><a href="<%=path%>/single/getDetail.action?id=${mystory.id}&opt=3">${mystory.title }</a></li>
					</c:forEach>
				</ul>
				<ul>
					<p>说说我的编程故事：</p>
					<c:forEach items="${codestories }" var="codestory">
						<li><a href="<%=path%>/single/getDetail.action?id=${codestory.id}&opt=4">${codestory.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="c2">
				<p class="title">认知与学习</p>
				<ul>
					<c:forEach items="${studies }" var="study">
						<li><a href="<%=path%>/single/getDetail.action?id=${study.id}&opt=5">${study.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="c3">
				<p class="title">工作与态度</p>
				<ul>
					<c:forEach items="${works }" var="work">
						<li><a href="<%=path%>/single/getDetail.action?id=${work.id}&opt=6">${work.title }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="footer">
			© 2017 Zhx ❖ Powered by MySelf.
		</div>
	</body>
</html>
