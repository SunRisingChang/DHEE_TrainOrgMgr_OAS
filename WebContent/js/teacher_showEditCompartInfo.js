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
	$("input[name='com_name']").val(parent.src_json[0].pagelist[parent.src_show_page].comName);
	$("input[name='com_man']").val(parent.src_json[0].pagelist[parent.src_show_page].comMan);
	$("input[name='zhi_wu']").val(parent.src_json[0].pagelist[parent.src_show_page].zhiWu);
	$("input[name='zuo_ji']").val(parent.src_json[0].pagelist[parent.src_show_page].zuoJi);
	$("input[name='shou_ji']").val(parent.src_json[0].pagelist[parent.src_show_page].shouJi);
	$("input[name='qq']").val(parent.src_json[0].pagelist[parent.src_show_page].qq);
	$("input[name='wei_xin']").val(parent.src_json[0].pagelist[parent.src_show_page].weiXin);
	$("input[name='email']").val(parent.src_json[0].pagelist[parent.src_show_page].email);
	$("input[name='di_zhi']").val(parent.src_json[0].pagelist[parent.src_show_page].diZhi);
	$("input[name='fa_piao']").val(parent.src_json[0].pagelist[parent.src_show_page].faPiao);
	$("textarea[name='bei_zhu']").val(parent.src_json[0].pagelist[parent.src_show_page].beiZhu);
	var edit_OPEN = true;
	$("input,textarea").attr("disabled", "disabled");

	$(".bottom").click(function () {
		if (edit_OPEN) {
			$("input,textarea").removeAttr("disabled");
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
					url: 'admin_updateComparyInfo.action',
					type: 'POST',
					data: {
						"id": parent.src_json[0].pagelist[parent.src_show_page].id,
						"comName": $("input[name='com_name']").val(),
						"comMan": $("input[name='com_man']").val(),
						"zhiWu": $("input[name='zhi_wu']").val(),
						"zuoJi": $("input[name='zuo_ji']").val(),
						"shouJi": $("input[name='shou_ji']").val(),
						"qq": $("input[name='qq']").val(),
						"weiXin": $("input[name='wei_xin']").val(),
						"email": $("input[name='email']").val(),
						"diZhi": $("input[name='di_zhi']").val(),
						"faPiao": $("input[name='fa_piao']").val(),
						"beiZhu": $("textarea[name='bei_zhu']").val(),
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