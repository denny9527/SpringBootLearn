$(document).ready(function() {
	$('#correctHomeworkForm').bootstrapValidator({
		feedbackIcons : {/* input状态样式图片 */
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			mark : {
				message : '评语无效',
				validators : {
					notEmpty : {// 非空验证：提示消息
						message : '请输入评语'
					},
                    stringLength: {
                    	max: 1,
                        max: 200,
                        message: '评语只能输入200字'
                    }
				}
			}
		}
	});
});

function homeworkFeedback() {
	var bootstrapValidator = $("#correctHomeworkForm").data("bootstrapValidator");
	bootstrapValidator.validate();
	if (bootstrapValidator.isValid()) {
		$.ajax({
			cache : false,
			dataType : "json",
			type : "POST",
			url : "/ldhomeworkFB/correct",
			async : false,
			data : $("#correctHomeworkForm").serialize(),
			success : function(data) {
				if (data.resultCode == "0") {
					bootbox.alert(data.info);
					return false;
				} else {
					bootbox.alert(data.info, function() {
						navi2page(data.url);
					});
				}
			}
		});
		return true;
	}else{
		return false;
	}
}