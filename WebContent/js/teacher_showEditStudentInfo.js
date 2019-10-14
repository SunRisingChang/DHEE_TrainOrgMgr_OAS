//空验证
function nullyz(obj) {
	if ($.trim(obj.val()) === "") {
		layer.tips("不可为空!", obj, {
			tips: [1, '#78BA32'],
			tipsMore: true
		});
		obj.attr("is", "false");
	} else {
		if ($.trim(obj.val()).length > 25) {
			layer.tips("不可超过15位!", obj, {
				tips: [1, '#78BA32'],
				tipsMore: true
			});
			obj.attr("is", "false");
		} else {
			obj.attr("is", "true");
		}
	}
};


//分数验证
function numberyz(obj) {
	var scogs = /^([0-9])*[0-9]$/;
	if ($.trim(obj.val()) === "") {
		layer.tips("不可为空!", obj, {
			tips: [1, '#78BA32'],
			tipsMore: true
		});
		obj.attr("is", "false");
	} else {
		if ($.trim(obj.val()).length > 15) {
			layer.tips("不可超过15位!", obj, {
				tips: [1, '#78BA32'],
				tipsMore: true
			});
			obj.attr("is", "false");
		} else {
			if (scogs.test($.trim(obj.val()))) {
				obj.attr("is", "true");
			} else {
				layer.tips("请输入数字!", obj, {
					tips: [1, '#78BA32'],
					tipsMore: true
				});
				obj.attr("is", "false");
			}
		}
	}
}

//手机验证
function ihone(obj) {
	var phogs = /^(13+\d{9})|(15+\d{9})$/;
	if ($.trim(obj.val()) === "") {
		layer.tips("不可为空!", obj, {
			tips: [1, '#78BA32'],
			tipsMore: true
		});
		obj.attr("is", "false");
	} else {
		if ($.trim(obj.val()).length > 20) {
			layer.tips("不可超过20位!", obj, {
				tips: [1, '#78BA32'],
				tipsMore: true
			});
			obj.attr("is", "false");
		} else {
			if (phogs.test($.trim(obj.val()))) {
				obj.attr("is", "true");
			} else {
				layer.tips("请输入15或13位手机号码!", obj, {
					tips: [1, '#78BA32'],
					tipsMore: true
				});
				obj.attr("is", "false");
			}
		}
	}
}


//邮箱验证
function emaliyz(obj) {
	var emags = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if ($.trim(obj.val()) === "") {
		layer.tips("不可为空!", obj, {
			tips: [1, '#78BA32'],
			tipsMore: true
		});
		obj.attr("is", "false");
	} else {
		if ($.trim(obj.val()).length > 50) {
			layer.tips("不可超过50位!", obj, {
				tips: [1, '#78BA32'],
				tipsMore: true
			});
			obj.attr("is", "false");
		} else {
			if (emags.test($.trim(obj.val()))) {
				obj.attr("is", "true");
			} else {
				layer.tips("格式错误!例如：123@123.com", obj, {
					tips: [1, '#78BA32'],
					tipsMore: true
				});
				obj.attr("is", "false");
			}
		}
	}
}

//家庭电话验证
function hihone(obj) {
	var scogs = /^([0-9])*[0-9]$/;
	if ($.trim(obj.val()) === "") {
		layer.tips("不可为空!", obj, {
			tips: [1, '#78BA32'],
			tipsMore: true
		});
		obj.attr("is", "false");
	} else {
		if ($.trim(obj.val()).length > 15) {
			layer.tips("不可超过15位!", obj, {
				tips: [1, '#78BA32'],
				tipsMore: true
			});
			obj.attr("is", "false");
		} else {
			if (scogs.test($.trim(obj.val()))) {
				obj.attr("is", "true");
			} else {
				layer.tips("请输入数字！", obj, {
					tips: [1, '#78BA32'],
					tipsMore: true
				});
				obj.attr("is", "false");
			}
		}
	}
}


$(document).ready(function () {
	$("input[name='pj']").val(parent.src_json[0].pagelist[parent.src_show_page].pj);
	$("input[name='class_times']").val(parent.src_json[0].pagelist[parent.src_show_page].classTimes);
	$("input[name='open_time']").val(parent.src_json[0].pagelist[parent.src_show_page].openTime.split("至")[0]);
	$("input[name='open_time2']").val(parent.src_json[0].pagelist[parent.src_show_page].openTime.split("至")[1]);
	$('input[name="com_name"]').val(parent.src_json[0].pagelist[parent.src_show_page].comName);
	$("input[name='man']").val(parent.src_json[0].pagelist[parent.src_show_page].man.split("/")[0]);
	$("input[name='man2']").val(parent.src_json[0].pagelist[parent.src_show_page].man.split("/")[1]);
	$("input[name='student_name']").val(parent.src_json[0].pagelist[parent.src_show_page].studentName);
	$('input:radio[name="sex"]').eq(parent.src_json[0].pagelist[parent.src_show_page].sex == 'girl' ? 1 : 0).attr("checked", 'checked');
	$("input[name='card']").val(parent.src_json[0].pagelist[parent.src_show_page].card);
	$("input[name='xue_li']").val(parent.src_json[0].pagelist[parent.src_show_page].xueLi);
	$("input[name='zhuan_ye']").val(parent.src_json[0].pagelist[parent.src_show_page].zhuanYe);
	$("input[name='biye_time']").val(parent.src_json[0].pagelist[parent.src_show_page].biyeTime);
	$("input[name='zhi_cheng']").val(parent.src_json[0].pagelist[parent.src_show_page].zhiCheng);
	$("input[name='zhi_wu']").val(parent.src_json[0].pagelist[parent.src_show_page].zhiWu);
	$("input[name='phone']").val(parent.src_json[0].pagelist[parent.src_show_page].phone);
	$("input[name='mail']").val(parent.src_json[0].pagelist[parent.src_show_page].mail);
	$('input:radio[name="is_acee"]').eq(parent.src_json[0].pagelist[parent.src_show_page].isAcee == 'false' ? 1 : 0).attr("checked", 'checked');
	$("input[name='bukao_time']").val(parent.src_json[0].pagelist[parent.src_show_page].bukaoTime);
	$('input:radio[name="bukao_is"]').eq(parent.src_json[0].pagelist[parent.src_show_page].bukaoIs == 'false' ? 1 : 0).attr("checked", 'checked');
	var edit_OPEN = true;
	$("input,select").attr("disabled", "disabled");

	$(".bottom").click(function () {
		if (edit_OPEN) {
			$("input,select").removeAttr("disabled");
			$(this).html("提交修改");
			edit_OPEN = false;
		} else {
			$("input[is='false']").each(function (index, value) {
				$(value).change();
			})
			if ($("input[is='false']").length > 0) {
				$("input[is='false']").each(function (index, value) {
					$(value).change();
				})
			} else {
				$.ajax({
					url: 'admin_updateStudentInfo.action',
					type: 'POST',
					data: {
						"id": parent.src_json[0].pagelist[parent.src_show_page].id,
						"pj": $("input[name='pj']").val(),
						"class_times": $("input[name='class_times']").val(),
						"open_time": $("input[name='open_time']").val() + "至" + $("input[name='open_time2']").val(),
						"com_name": $('input[name="com_name"]').val(),
						"man": $("input[name='man']").val() + "/" + $("input[name='man2']").val(),
						"student_name": $("input[name='student_name']").val(),
						"sex": $('input:radio[name="sex"]:checked').val(),
						"card": $("input[name='card']").val(),
						"xue_li": $("input[name='xue_li']").val(),
						"zhuan_ye": $("input[name='zhuan_ye']").val(),
						"biye_time": $("input[name='biye_time']").val(),
						"zhi_cheng": $("input[name='zhi_cheng']").val(),
						"zhi_wu": $("input[name='zhi_wu']").val(),
						"phone": $("input[name='phone']").val(),
						"mail": $("input[name='mail']").val(),
						"is_acee": $('input:radio[name="is_acee"]:checked').val(),
						"bukao_time": $("input[name='bukao_time']").val(),
						"bukao_is": $('input:radio[name="bukao_is"]:checked').val(),
					},
					timeout: 5000,
					dataType: 'text',
					success: function (data, textStatus, jqXHR) {
						if (data == 1) {
							$(".bottom").html("修改信息");
							parent.layer.msg('修改成功！', {
								shade: 0.3
							});
							$("input,select").attr("disabled", "disabled");
							edit_OPEN = true;
						} else if (data == 110) {
							layer.msg('检测到异常访问，3秒后跳转到登陆页！', {
								icon: 5,
								shade: 0.3
							});
							setTimeout(function () {
								location.href = $("base").attr("href") + "login.jsp";
							}, 3000);
						} else {
							parent.layer.msg('服务器异常，修改失败', {
								icon: 5,
								shade: 0.3
							});
						}
					},
					error: function (xhr, textStatus) {
						layer.msg('服务器错误，请稍后再试！', {
							icon: 5
						});
					}
				});
			}
		}
	});

});