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
		<link rel="stylesheet" href="<%=path %>/css/front/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/front/tags.css"/>
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
				<div class="t2">Tags</div>
				<div class="t3">文章基因库  |  KeyWords</div>
			</div>
		</div>
		<div class="content">
			<div class="c1">
				<p class="title">本页使用方法</p>
				<ol>
					<li>在下面选一个你喜欢的词</li>
					<li>点击它</li>
					<li>相关的文章会「唰」地一声跳到页面顶端</li>
					<li>马上试试？</li>
				</ol>
			</div>
			<div class="c2">
				<p class="title">基因列表</p>
				<p class="items">
					<c:forEach items="${keys }" var="key">
						<a href="<%=path%>/single/tagList.action?id=${key.id}">
							${key.key } &nbsp;&nbsp;
						</a>
					</c:forEach> 
					礼物 生活 阿十 起步者 决定 行走 试错 学习 书单 恐怖直播 故事 27岁 
					绿光 盖茨比 抽烟 喝酒 简书 女孩 爱哭 思维导图 情感 改变 总结 千字文 最好金龟换酒 
					藏地白皮书 记忆 城市 把时间当作朋友 时间 人生 编程 指南 恋爱 笔记 写作 山珍 蕨菜 
					每天一千字 回家 春分 暗时间 核心竞争力 书 机械键盘 雕爷 美食 感情 爱情 自省 旅行 
					印象 餐饮 东莞 知识 婚宴 同学 感想 美剧 知乎 历史 杂记 说话 翻译 艺术 沉思 公园 头像 
					产品经理 
				</p>
			</div>
			
		</div>
		<div class="footer">
			© 2017 Zhx ❖ Powered by MySelf.
		</div>
	</body>
</html>
