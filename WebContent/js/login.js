$(document).ready(function () {
	"use strict";
	var UandP = $("#login_student>.login>.login_con>input");
	var confirm = $("#login_student>.login>.login_con>.loginin");
	var username = UandP.eq(0);
	var password = UandP.eq(1);

	UandP.focus(function () {
		if (this.value === this.defaultValue) {
			if (this.defaultValue === "Password") {
				$(this).attr("type", "password");
			}
			this.value = "";
			$(this).css("color", "#000");
		}
	});

	UandP.blur(function () {
		if (this.value === "") {
			if (this.defaultValue === "Password") {
				$(this).attr("type", "text");
			}
			this.value = this.defaultValue;
			$(this).css("color", "#999");
		} else {
			if (this.value.length > 15) {
				layer.tips("不能超过15位！", this, {
					tips: [1, '#78BA32']
				});
			} else {
				if (this.defaultValue === "Username") {
					$.ajax({
						url: 'adminInit_isTeacherName.action',
						type: 'POST',
						data: {
							"teacherName": this.value
						},
						timeout: 5000,
						dataType: 'text',
						success: function (data, textStatus, jqXHR) {
							if (data === 0) {
								layer.tips("不存在该用户名！", username, {
									tips: [1, '#78BA32']
								});
								username.attr("is", "false");
							} else {
								username.attr("is", "true");
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
		}
	});

	confirm.click(function () {
		if (username.val() === "Username") {
			layer.tips("用户名不能为空！", username, {
				tips: [1, '#78BA32']
			});
		} else {
			if (username.val().length > 15) {
				layer.tips("不能超过15位！", username, {
					tips: [1, '#78BA32']
				});
			} else {
				if (password.val() === "Password") {
					layer.tips("密码不能为空！", password, {
						tips: [1, '#78BA32']
					});
				} else {
					if (password.val().length > 15) {
						layer.tips("不能超过15位！", password, {
							tips: [1, '#78BA32']
						});
					} else {
						if (username.attr("is") === "false") {
							layer.tips("该用户不存在，请更改用户名！", username, {
								tips: [1, '#78BA32']
							});
						} else {
							$.ajax({
								url: 'adminInit_isTeacherUser.action',
								type: 'POST',
								data: {
									"teacherName": username.val(),
									"teacherPassword": password.val()
								},
								timeout: 5000,
								dataType: 'text',
								success: function (data, textStatus, jqXHR) {
									if (data === 0) {
										layer.msg('您输入的密码错误！', {
											icon: 5
										});
									} else {
										location.href = "jsp/TS_success.jsp";
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
				}
			}
		}
	});

});