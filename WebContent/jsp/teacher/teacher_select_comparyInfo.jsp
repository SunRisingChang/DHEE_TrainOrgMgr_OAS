<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<title></title>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="js/layer/skin/default/layer.css" />
<link rel="stylesheet" type="text/css"
	href="css/teacher_select_CompartInfo.css" />
</head>
<body>
	<div id="div1">
		<div id="top">
			<div id="top1_1">
				<div class="top1_2">企业名称</div>
				<div class="top1_3">
					<input type="text" id="classes" name="" class="lay1" />
				</div>
				<div class="top1_2">联系人</div>
				<div class="top1_3">
					<input type="text" id="classes2" name="" class="lay2"/>
				</div>
				<div class="top1_4" id="q">查询</div>
				<div class="top1_5 add" id="q">添加</div>
				<div class="top1_5 exl" id="q">打印</div>
			</div>
		</div>
		<div id="center">
			<table class="table table-hover" id="table1" pages="0">
				<thead>
					<tr>
						<th style="text-align: center;">#</th>
						<th style="text-align: center;">企业名称</th>
						<th style="text-align: center;">企业联系人</th>
						<th style="text-align: center;">职务</th>
						<th style="text-align: center;">座机</th>
						<th style="text-align: center;">手机</th>
						<th style="text-align: center;">操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<div id="tablefoot">
			<ul>
				<li id="btn2"><div class="page_up" is="">上一页</div></li>
				<li id="btn1"><div class="page_up" is="">下一页</div></li>
				<li sumpage="">共225页</li>
				<li>共225条记录</li>
				<li>到第<input type="text" class="bage" />页
				</li>
				<li><div class="page_up1" is="">确定</div></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="js/teacher_select_CompartInfo.js"></script>
</body>
</html>