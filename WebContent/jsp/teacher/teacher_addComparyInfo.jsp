<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title></title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="js/layer/skin/default/layer.css" />
<link rel="stylesheet" type="text/css" href="css/teacher_addCompartInfo.css">
</head>
<body>
<div id="gold1">
  <div class="left">
    <ul>
      <li><span class="sp">企业名称</span>
        <input type="text" name="com_name" class=" text1" id="c1" onchange="nullyz($(this))" is="false"/>
      </li>
      <li><span class="sp">企业联系人</span>
        <input type="text" name="com_man" class=" text1" id="c2" onchange="nullyz($(this))" is="false"/>
      </li>
      <li><span class="sp">职务</span>
        <input type="text" name="zhi_wu" class=" text1" id="c4" />
      </li>
       <li><span class="sp">座机</span>
        <input type="text" name="zuo_ji" class=" text1" id="c3" />
      </li>
      <li><span class="sp">手机</span>
        <input type="text" name="shou_ji" class=" text1" id="c5"/>
      </li>
      <li><span class="sp">QQ</span>
       <input type="text" name="qq" class=" text1" id="c33"/>
      </li>
    </ul>
  </div>
  <div class="right">
    <ul>
    <li><span class="sp">微信</span>
        <input type="text" name="wei_xin" class=" text2" id="c6" />
      </li>
      <li><span class="sp">邮箱</span>
        <input type="text" name="email" class=" text2" id="a7" />
      </li>
      <li><span class="sp">地址</span>
        <input type="text" name="di_zhi" class=" text2" id="c7"/>
      </li>
      <li><span class="sp">发票信息</span>
        <input type="text" name="fa_piao" class=" text2" id="a1" />
      </li>
      <li><span class="sp">备注</span>
      <textarea class=" text2 text22" name="bei_zhu"></textarea>
      </li>
    </ul>
  </div>
  <div class="bottom">确认添加</div>
</div>
<script src="js/teacher_addCompartInfo.js"></script>
</body>
</html>