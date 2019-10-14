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
<link rel="stylesheet" type="text/css" href="css/teacher_addStudentInfo.css">
</head>
<body>
<div id="gold1">
  <div class="left">
    <ul>
      <li><span class="sp">项目</span>
        <input type="text" name="pj" class=" text1" id="c1" onchange="nullyz($(this))" is="false"/>
      </li>
      <li><span class="sp">开班班次</span>
        <input type="text" name="class_times" class=" text1" id="c2" onchange="nullyz($(this))" is="false"/>
      </li>
      <li><span class="sp">开班时间</span>
        <input type="text" name="open_time" class=" text1" id="c4" is="false" onClick="WdatePicker()" onchange="nullyz($(this))"/>至<input type="text" name="open_time2" class=" text1" id="c44" is="false" onClick="WdatePicker()" onchange="nullyz($(this))"/>
      </li>
       <li><span class="sp">企业名称</span>
        <input type="text" name="com_name" class=" text1" id="c3" onchange="nullyz($(this))" is="false"/>
      </li>
      <li><span class="sp">企业联系人</span>
        <input type="text" name="man" class=" text1" id="c5"/>
      </li>
      <li><span class="sp">电话</span>
       <input type="text" name="man2" class=" text1" id="c33"/>
      </li>
      <li><span class="sp">学员姓名</span>
        <input type="text" name="student_name" class=" text1" id="c6" onchange="isStudentInfoName($(this))" is="false"/>
      </li>
      <li><span class="sp">性别</span>
        <div class="div_text">
          <input type="radio" name="sex" value="boy" checked="checked" is="true"/>
          男
          <input type="radio" name="sex" value="girl" class="radio2" is="true"/>
          女 </div>
      </li>
      <li><span class="sp">身份证</span>
        <input type="text" name="card" class=" text1" id="c7" onchange="nullyz($(this))" is="false"/>
      </li>
      <li><span class="sp">学历</span>
        <input type="text" name="xue_li" class=" text1" id="a1" />
      </li>
    </ul>
  </div>
  <div class="right">
    <ul>
      <li><span class="sp">专业</span>
        <input type="text" name="zhuan_ye" class=" text2" id="a2" />
      </li>
      <li><span class="sp">毕业时间</span>
        <input type="text" name="biye_time" class=" text2" id="a3" onClick="WdatePicker()"/>
      </li>
      <li><span class="sp">职称</span>
        <input type="text" name="zhi_cheng" class=" text2" id="a4" />
      </li>
      <li><span class="sp">职务</span>
        <input type="text" name="zhi_wu" class=" text2" id="a5" />
      </li>
      <li><span class="sp">手机号码</span>
        <input type="text" name="phone" class=" text2" id="a6" onchange="ihone($(this))" is="false"/>
      </li>
      <li><span class="sp">邮箱</span>
        <input type="text" name="mail" class=" text2" id="a7" />
      </li>
      <li><span class="sp">是否通过</span>
        <div class="div_text2">
          <input type="radio" name="is_acee" value="true" checked="checked" is="true"/>
          是
          <input type="radio" name="is_acee" value="false" class="radio2" is="true"/>
          否 </div>
      </li>
      <li><span class="sp">补考时间</span>
        <input type="text" name="bukao_time" class=" text2" id="c444" onClick="WdatePicker()"/>
      </li>
       <li><span class="sp">补考通过</span>
        <div class="div_text2">
          <input type="radio" name="bukao_is" value="true" checked="checked" is="true"/>
          是
          <input type="radio" name="bukao_is" value="false" class="radio2" is="true"/>
          否</div>
      </li>
    </ul>
  </div>
  <div class="bottom">确认添加</div>
</div>
<script src="js/teacher_addStudentInfo.js"></script>
</body>
</html>