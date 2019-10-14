// JavaScript Document
var PcWidth;
var PcHeight;
var left_nav;
var con_head;
var con;
var logOut;

function autoHeight() {
	if (con.height() > PcHeight) {
		con.css({
			"width": PcWidth - $("#src-left-nav").width() - 17 + "px"
		});
	} else {
		con.css({
			"width": PcWidth - $("#src-left-nav").width() + "px"
		});
	}
}
$(window).resize(function () {
	"use strict";
	PcWidth = $(this).width();
	PcHeight = $(this).height();
	//动态设置内容区的宽度
	$("#src-con-head").css({
		"width": PcWidth - $("#src-left-nav").width() + "px",
		"left": $("#src-left-nav").width() + "px"
	});
	$("#con").css({
		"width": PcWidth - $("#src-left-nav").width() + "px",
		"left": $("#src-left-nav").width() + "px"
	});
});
$(document).ready(function () {
	"use strict";
	left_nav = $("#src-left-nav>ul>li");
	con_head = $("#src-con-head");
	con = $("#con");
	logOut = $("#src-nav .logout");

	//**************************初始化*************************
	$("html").niceScroll({
		cursorcolor: "#ccc", //#CC0071 光标颜色 
		cursoropacitymax: 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0 
		touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备 
		cursorwidth: "5px", //像素光标的宽度 
		cursorborder: "0", //     游标边框css定义 
		cursorborderradius: "5px", //以像素为光标边界半径 
		autohidemode: true //是否隐藏滚动条 
	});

	//手动触发resize事件
	$(window).trigger("resize");
	switch (left_nav.eq(0).attr("id")) {
		case "seditInfo":
			con.load($("base").attr("href") + "jsp/teacher/teacher_select_studentInfo.jsp", function () {
				autoHeight();
				con.fadeIn(100);
			});
			break;
	}

	left_nav.click(function () {
		con_head.find("h1").html($(this).text());
		con_head.find("zi").html($(this).text());
		var temp = $(this);
		con.fadeOut(100, function () {
			switch (temp.attr("id")) {
				case "seditInfo":
					con.load($("base").attr("href") + "jsp/teacher/teacher_select_studentInfo.jsp", function () {
						autoHeight();
						con.fadeIn(100);
					});
					break;
				case "seditPassword":
					con.load($("base").attr("href") + "jsp/teacher/teacher_select_comparyInfo.jsp", function () {
						autoHeight();
						con.fadeIn(100);
					});
					break;
			}
		});
	});

	logOut.click(function () {
		if ($(this).attr("loginType") === "0") {
			$.ajax({
				url: 'admin_loginOut.action',
				type: 'POST',
				data: {},
				timeout: 5000,
				dataType: 'text',
				success: function (data, textStatus, jqXHR) {
					if (data === 0) {
						layer.msg('注销失败，请关闭浏览器直接退出！', {
							icon: 5
						});
					} else if (data === 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else {
						location.href = $("base").attr("href") + "login.jsp";
					}
				},
				error: function (xhr, textStatus) {
					layer.msg('服务器错误，请稍后再试！', {
						icon: 5
					});
				}
			});
		} else {
			$.ajax({
				url: 'admin_loginOut.action',
				type: 'POST',
				data: {},
				timeout: 5000,
				dataType: 'text',
				success: function (data, textStatus, jqXHR) {
					if (data === 0) {
						layer.msg('注销失败，请关闭浏览器直接退出！', {
							icon: 5
						});
					} else if (data === 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else {
						location.href = $("base").attr("href") + "login.jsp";
					}
				},
				error: function (xhr, textStatus) {
					layer.msg('服务器错误，请稍后再试！', {
						icon: 5
					});
				}
			});
		}
	});

});