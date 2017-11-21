$(document).ready(function() {
	$('#userRegForm').bootstrapValidator({
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
					},
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名长度必须在6到30之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名由数字字母下划线和.组成'
                    }
				}
			},
			userName : {
				message : '姓名无效',
				validators : {
					notEmpty : {// 非空验证：提示消息
						message : '姓名不能为空'
					}
				}
			},
			password : {
				message : '密码无效',
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
                    regexp:{
                        regexp:/^[a-zA-Z0-9]+$/,
                        message:'密码由数字字母组成'
                    }
				}
			},
			phoneNumber:{
                validators:{
                    notEmpty:{
                        message:'手机号码不能为空'
                    },
                    stringlength:{
                        min:11,
                        max:11,
                        message:'请输入11位手机号码'
                    },
                    regexp:{
                        regexp:/^1[3|5|8]{1}[0-9]{9}$/,
                        message:'请输入正确的手机号码'
                    }
                }
            }
		}
	});
	$("#registButton").click(function() {
		var bootstrapValidator = $("#userRegForm").data("bootstrapValidator");
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
				regist();
		}
	});
	
	$("#resetButton").click(function() {
		$("#userRegForm").data('bootstrapValidator').resetForm(true);
		//$('#userRegForm').bootstrapValidator('resetForm', true)
	});
});

function regist() {
	$.ajax({
		cache : false,
		dataType : "json",
		type : "POST",
		url : "/user/regist",
		async : false,
		data : $("#userRegForm").serialize(),
		success : function(data) {
			if (data.resultCode == "0") {
				bootbox.alert(data.info);
			} else {
				bootbox.alert(data.info, function() {
					window.location.href = data.url;
				});
			}
		}

	});
}