<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>欢迎访问</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Logo.ico" media="screen" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/TS_success.css">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.nicescroll.js"></script>
</head>
<body>
	<div id="src-nav">
		<h1>DHEE华信</h1>
		<span class="nowName">欢迎<strong><s:property value="#session.nowName" /></strong>登陆！
		</span> <span class="logout"
			loginType="<s:property
					value="#session.type" />"><i
			class="fa fa-power-off"></i>注销</span>
	</div>
	<div id="src-left-nav">
		<ul>
			<s:if test="#session.type==0">
				<li id="seditInfo"><i class="fa fa-fire"></i>学员信息管理</li>
				<li id="seditPassword"><i class="fa fa-edit"></i>企业信息管理</li>
			</s:if>
		</ul>
	</div>
	<div id="src-con-head">
		<h1>
			<s:if test="#session.type==0">
				学员信息管理	
			</s:if>
		</h1>
		<span>
			<p>
				<strong><s:property value="#session.nowName" /></strong>&nbsp;/&nbsp;
				<zi>
					<s:if test="#session.type==0">
					学员信息管理
					</s:if>
				</zi>
			</p>
		</span>
	</div>
	<div id="con"></div>
	<script src="js/TS_success.js"></script>
</body>
</html>