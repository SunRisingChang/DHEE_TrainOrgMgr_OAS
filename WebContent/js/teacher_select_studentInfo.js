var src_json
var src_show_page
$(document).ready(function () {
	var a = $("#div1>#top>#top1_1>.top1_3>.lay1");
	var b = $("#div1>#top>#top1_1>.top1_3>.lay2");
	var but1 = $("#div1>#top>#top1_1 .top1_4");
	var but2 = $("#div1>#top>#top1_1 .add");
	var but3 = $("#div1>#top>#top1_1 .exl");
	var table = $("#table1");
	var tablecenter = $("#center");
	var tablefoot = $("#tablefoot");
	var uppage = $("#btn2>.page_up");
	var downpage = $("#btn1>.page_up");
	var sumpage = $("#tablefoot>ul>li").eq(2);
	var sumrow = $("#tablefoot>ul>li").eq(3);
	var nowpage = $("#tablefoot>ul>li").eq(4).find(".bage");
	var hrefpag = $("#tablefoot .page_up1");

	//点击查询
	but1.click(function () {
		if (a.val() === "" && b.val() === "") {
			layer.tips("请输入项目或班次!", a, {
				tips: [1, '#78BA32']
			});
		} else {
			$.ajax({
				url: 'admin_selectStudentInfo.action',
				type: 'POST',
				data: {
					"className": a.val(),
					"studentName": b.val(),
					"newPag": 0,
				},
				timeout: 5000,
				dataType: 'json',
				success: function (data, textStatus, jqXHR) {
					if (data == 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else if (data[0].allrow == 0) {
						layer.msg('您查找的信息不存在！');
					} else {
						tablecenter.stop().fadeOut(100);
						tablefoot.stop().fadeOut(100);
						a.attr("name", data[0].pj);
						b.attr("name", data[0].classTimes);
						uppage.attr("is", data[0].isup);
						downpage.attr("is", data[0].isdown);
						sumpage.html("共" + data[0].allpage + "页");
						sumpage.attr("sumpage", data[0].allpage);
						sumrow.html("共" + data[0].allrow + "条记录");
						nowpage.val(data[0].nowpage + 1);
						table.attr("pages", data[0].nowpage + 1);
						$("#table1 tbody").children().remove();
						$.each(data[0].pagelist, function (index, value) {
							$("#table1 tbody").append('<tr><td style="text-align: center;width: 8px;">' + (data[0].nowpage * 10 + 1 + index) + '</td><td style="text-align: center;width: 140px;">' + value.pj + '</td><td style="text-align: center;width: 40px;">' + value.classTimes + '</td><td style="text-align: center;width: 190px;">' + value.openTime + '</td><td style="text-align: center;width: 75px;">' + value.comName + '</td><td style="text-align: center;width: 55px;">' + value.studentName + '</td><td style="text-align: center;width: 8px;">' + value.card + '</td><td style="text-align: center;width: 8px;">' + value.phone + '</td><td style="text-align:center;width: 71px;"><q id="xiangqing" class="q1" rowid="' + index + '">详情</q><q id="shanchu" class="q2" rowid="' + value.id + '">删除</q></td></tr>');
						})
						src_json = data;
						tablecenter.stop().fadeIn(100);
						tablefoot.stop().fadeIn(100);
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

	//点击下一页
	downpage.click(function () {
		if ($(this).attr("is") === "true") {
			$.ajax({
				url: 'admin_selectStudentInfo.action',
				type: 'POST',
				data: {
					"className": a.attr("name"),
					"studentName": b.attr("name"),
					"newPag": table.attr("pages"),
				},
				timeout: 5000,
				dataType: 'json',
				success: function (data, textStatus, jqXHR) {
					if (data == 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else if (data[0].allrow == 0) {
						layer.msg('您查找的信息不存在！');
					} else {
						tablecenter.stop().fadeOut(100);
						tablefoot.stop().fadeOut(100);
						a.attr("name", data[0].pj);
						b.attr("name", data[0].classTimes);
						uppage.attr("is", data[0].isup);
						downpage.attr("is", data[0].isdown);
						sumpage.html("共" + data[0].allpage + "页");
						sumpage.attr("sumpage", data[0].allpage);
						sumrow.html("共" + data[0].allrow + "条记录");
						nowpage.val(data[0].nowpage + 1);
						table.attr("pages", data[0].nowpage + 1);
						$("#table1 tbody").children().remove();
						$.each(data[0].pagelist, function (index, value) {
							$("#table1 tbody").append('<tr><td style="text-align: center;width: 8px;">' + (data[0].nowpage * 10 + 1 + index) + '</td><td style="text-align: center;width: 140px;">' + value.pj + '</td><td style="text-align: center;width: 40px;">' + value.classTimes + '</td><td style="text-align: center;width: 190px;">' + value.openTime + '</td><td style="text-align: center;width: 75px;">' + value.comName + '</td><td style="text-align: center;width: 55px;">' + value.studentName + '</td><td style="text-align: center;width: 8px;">' + value.card + '</td><td style="text-align: center;width: 8px;">' + value.phone + '</td><td style="text-align:center;width: 71px;"><q id="xiangqing" class="q1" rowid="' + index + '">详情</q><q id="shanchu" class="q2" rowid="' + value.id + '">删除</q></td></tr>');
						})
						src_json = data;
						tablecenter.stop().fadeIn(100);
						tablefoot.stop().fadeIn(100);
					}
				},
				error: function (xhr, textStatus) {
					layer.msg('服务器错误，请稍后再试！', {
						icon: 5
					});
				}
			});
		} else {
			layer.msg('亲！已经没有下一页啦！');
		}
	});

	//点击上一页
	uppage.click(function () {
		if ($(this).attr("is") === "true") {
			$.ajax({
				url: 'admin_selectStudentInfo.action',
				type: 'POST',
				data: {
					"className": a.attr("name"),
					"studentName": b.attr("name"),
					"newPag": table.attr("pages") - 2,
				},
				timeout: 5000,
				dataType: 'json',
				success: function (data, textStatus, jqXHR) {
					if (data == 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else if (data[0].allrow == 0) {
						layer.msg('您查找的信息不存在！');
					} else {
						tablecenter.stop().fadeOut(100);
						tablefoot.stop().fadeOut(100);
						a.attr("name", data[0].pj);
						b.attr("name", data[0].classTimes);
						uppage.attr("is", data[0].isup);
						downpage.attr("is", data[0].isdown);
						sumpage.html("共" + data[0].allpage + "页");
						sumpage.attr("sumpage", data[0].allpage);
						sumrow.html("共" + data[0].allrow + "条记录");
						nowpage.val(data[0].nowpage + 1);
						table.attr("pages", data[0].nowpage + 1);
						$("#table1 tbody").children().remove();
						$.each(data[0].pagelist, function (index, value) {
							$("#table1 tbody").append('<tr><td style="text-align: center;width: 8px;">' + (data[0].nowpage * 10 + 1 + index) + '</td><td style="text-align: center;width: 140px;">' + value.pj + '</td><td style="text-align: center;width: 40px;">' + value.classTimes + '</td><td style="text-align: center;width: 190px;">' + value.openTime + '</td><td style="text-align: center;width: 75px;">' + value.comName + '</td><td style="text-align: center;width: 55px;">' + value.studentName + '</td><td style="text-align: center;width: 8px;">' + value.card + '</td><td style="text-align: center;width: 8px;">' + value.phone + '</td><td style="text-align:center;width: 71px;"><q id="xiangqing" class="q1" rowid="' + index + '">详情</q><q id="shanchu" class="q2" rowid="' + value.id + '">删除</q></td></tr>');
						})
						src_json = data;
						tablecenter.stop().fadeIn(100);
						tablefoot.stop().fadeIn(100);
					}
				},
				error: function (xhr, textStatus) {
					layer.msg('服务器错误，请稍后再试！', {
						icon: 5
					});
				}
			});
		} else {
			layer.msg('亲！已经没有上一页啦！');
		}
	});

	//跳转到指定页
	hrefpag.click(function () {
		if (Number($.trim(nowpage.val())) <= Number(sumpage.attr("sumpage")) && Number($.trim(nowpage.val())) > 0) {
			$.ajax({
				url: 'admin_selectStudentInfo.action',
				type: 'POST',
				data: {
					"className": a.attr("name"),
					"studentName": b.attr("name"),
					"newPag": Number($.trim(nowpage.val())) - 1,
				},
				timeout: 5000,
				dataType: 'json',
				success: function (data, textStatus, jqXHR) {
					if (data == 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else if (data[0].allrow == 0) {
						layer.msg('您查找的信息不存在！');
					} else {
						tablecenter.stop().fadeOut(100);
						tablefoot.stop().fadeOut(100);
						a.attr("name", data[0].pj);
						b.attr("name", data[0].classTimes);
						uppage.attr("is", data[0].isup);
						downpage.attr("is", data[0].isdown);
						sumpage.html("共" + data[0].allpage + "页");
						sumrow.html("共" + data[0].allrow + "条记录");
						sumpage.attr("sumpage", data[0].allpage);
						nowpage.val(data[0].nowpage + 1);
						table.attr("pages", data[0].nowpage + 1);
						$("#table1 tbody").children().remove();
						$.each(data[0].pagelist, function (index, value) {
							$("#table1 tbody").append('<tr><td style="text-align: center;width: 8px;">' + (data[0].nowpage * 10 + 1 + index) + '</td><td style="text-align: center;width: 140px;">' + value.pj + '</td><td style="text-align: center;width: 40px;">' + value.classTimes + '</td><td style="text-align: center;width: 190px;">' + value.openTime + '</td><td style="text-align: center;width: 75px;">' + value.comName + '</td><td style="text-align: center;width: 55px;">' + value.studentName + '</td><td style="text-align: center;width: 8px;">' + value.card + '</td><td style="text-align: center;width: 8px;">' + value.phone + '</td><td style="text-align:center;width: 71px;"><q id="xiangqing" class="q1" rowid="' + index + '">详情</q><q id="shanchu" class="q2" rowid="' + value.id + '">删除</q></td></tr>');
						})
						src_json = data;
						tablecenter.stop().fadeIn(100);
						tablefoot.stop().fadeIn(100);
					}
				},
				error: function (xhr, textStatus) {
					layer.msg('服务器错误，请稍后再试！', {
						icon: 5
					});
				}
			});
		} else {
			layer.msg('没有该页！');
		}

	});

	//添加按钮
	but2.click(function () {
		layer.open({
			type: 2,
			area: ['100%', '660px'],
			id: "99",
			title: '添加学员信息',
			fixed: true, //不固定
			maxmin: false,
			content: 'jsp/teacher/teacher_addStudentInfo.jsp'
		});
	});

	//删除学生信息
	$("#table1").on("click", "#shanchu", function () {
		var deletdom = $(this);
		layer.confirm('您确认要删除该条记录？', {
			btn: ['是的', '不是'] //按钮
		}, function () {
			$.ajax({
				url: 'admin_deleteStudentInfo.action',
				type: 'POST',
				data: {
					"deletRow": deletdom.attr("rowid")
				},
				timeout: 5000,
				dataType: 'text',
				success: function (data, textStatus, jqXHR) {
					if (data == 1) {
						deletdom.closest("tr").remove();
						layer.msg('删除成功！');
					} else if (data == 110) {
						layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
							icon: 5,
							shade: 0.3
						});
						setTimeout(function () {
							location.href = $("base").attr("href") + "login.jsp";
						}, 3000);
					} else {
						layer.msg('删除失败！');
					}
				},
				error: function (xhr, textStatus) {
					layer.msg('服务器错误，请稍后再试！', {
						icon: 5
					});
				}
			});
		}, function () {});
	});

	//查看学生详情
	$("#table1").on("click", "#xiangqing", function () {
		src_show_page = $(this).attr("rowid");
		layer.open({
			type: 2,
			area: ['100%', '100%'],
			id: "99",
			title: '学员详细信息',
			fixed: true, //不固定
			maxmin: false,
			content: 'jsp/teacher/teacher_showEditStudentInfo.jsp'
		});

	});

	//导出exl
	but3.click(function () {
		if (a.attr("name") === "" && b.attr("name") === "") {
			layer.tips("请先查询再进行此操作!", but3, {
				tips: [1, '#78BA32']
			});
		} else {
			var form = $("<form>");
			form.attr("style", "display:none");
			form.attr("target", "");
			form.attr("method", "post");
			form.attr("action", "adminInit_outStudentExl.action");
			var input1 = $("<input>");
			input1.attr("type", "hidden");
			input1.attr("name", "className");
			input1.attr("value", a.attr("name"));
			var input2 = $("<input>");
			input2.attr("type", "hidden");
			input2.attr("name", "studentName");
			input2.attr("value", b.attr("name"));
			$("body").append(form);
			form.append(input1);
			form.append(input2);
			form.submit();
			form.remove();
		}
	});

});