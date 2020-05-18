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
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/single.css"/>
		
		<style>
			
		</style>
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
			
			<div class="ti">
				<div class="title">
					<c:if test="${article!=null }">	${article.title }</c:if>
					<c:if test="${life!=null }">	${life.title }</c:if>
					<c:if test="${mystory!=null }">	${mystory.title }</c:if>
					<c:if test="${codestory!=null }">	${codestory.title }</c:if>
					<c:if test="${study!=null }">	${study.title }</c:if>
					<c:if test="${work!=null }">	${work.title }</c:if>
				</div>
				<div class="date">Posted on 
					<c:if test="${article!=null }">	${article.date }</c:if>
					<c:if test="${life!=null }">	${life.date }</c:if>
					<c:if test="${mystory!=null }">	${mystory.date }</c:if>
					<c:if test="${codestory!=null }">	${codestory.date }</c:if>
					<c:if test="${study!=null }">	${study.date }</c:if>
					<c:if test="${work!=null }">	${work.date }</c:if>
				</div>
			</div>
		</div>
		<div class="content">
			 <c:if test="${article!=null }">	${article.content }</c:if>
			 <c:if test="${life!=null }">	${life.content }</c:if>
			 <c:if test="${mystory!=null }">	${mystory.content }</c:if>
			 <c:if test="${codestory!=null }">	${codestory.content }</c:if>
			 <c:if test="${study!=null }">	${study.content }</c:if>
			 <c:if test="${work!=null }">	${work.content }</c:if>
		</div>
		<div class="footer">
			© 2017 Zhx ❖ Powered by MySelf.
		</div>
	</body>
</html>

