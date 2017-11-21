$(document).ready(
		function() {
			$('#userLoginForm').bootstrapValidator({
				feedbackIcons : {/* input状态样式图片 */
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					userAccount : {
						message : '用户名无效',
						validators : {
							notEmpty : {// 非空验证：提示消息
								message : '用户名不能为空'
							}
						}
					},
					password : {
						message : '密码无效',
						validators : {
							notEmpty : {
								message : '密码不能为空'
							}
						}
					}
				}
			});
			$("#loginButton").click(
					function() {
						var bootstrapValidator = $("#userLoginForm").data(
								"bootstrapValidator");
						bootstrapValidator.validate();
						if (bootstrapValidator.isValid()) {
							login();
						}
					});
		});

function login() {
	$.ajax({
		cache : false,
		dataType : "json",
		type : "POST",
		url : "/user/login",
		async : false,
		data : $("#userLoginForm").serialize(),
		success : function(data) {
			if (data.resultCode == "0") {
				bootbox.alert(data.info);
			} else {
				bootbox.alert(data.info, function() {
					navi2page(data.url)
				});
			}
		}

	});
}