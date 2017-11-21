function downloadLinkFormatter(value, row) {
	var href = "/ldhomework/download?filePath=" + row.homeworkFilePath
			+ "&fileName=" + encodeURIComponent(row.homeworkFileName);
	return "<a href='" + href + "'>" + row.homeworkFileName + "</a>";
}

function appraiseFormatter(value, row) {
	var appraiseFlag = row.appraiseFlag;
	var result = "";
	if (appraiseFlag == '1') {
		result = "您已批改";
	} else {
		result = "您未批改";
	}
	return result;
}

function correctHomework(homeworkId, appraiseFlag, userId) {
	if (appraiseFlag == '1') {
		bootbox.alert("该作业您已批改");
	} else {
	    $.get("ldhomeworkFB/correct_page?homeworkId="+homeworkId+"&userId="+userId, function(data){
			var ldhomeworkFBPage;
	    	ldhomeworkFBPage = data;
			var dialog = bootbox.dialog({
				title : '批改作业',
				message : ldhomeworkFBPage,
				size : 'large',
				buttons : {
					ok : {
						label : "提交",
						className : 'btn-info',
						callback : function() {
							var result = homeworkFeedback();
							return result;
						}
					},
					cancel : {
						label : "关闭",
						className : 'btn-danger',
						callback : function() {
						}
					}
				}
			});
	    });
//		dialog.on('hidden.bs.modal', function () {
//			  alert("hello world");
//		});
	}
}

function appraiseList(homeworkId) {
//	$('#appraiseTable').bootstrapTable('destroy').bootstrapTable({
//		method : "get",
//		url : "ldhomeworkFB/appraise_list?homeworkId=" + homeworkId,
//		columns : [ {
//			field : 'appraiseUserAccount',
//			title : '学员账号'
//		}, {
//			field : 'appraiseUserName',
//			title : '学员姓名'
//		}, {
//			field : 'appraise',
//			title : '评价'
//		}, {
//			field : 'level',
//			title : '作业等级'
//		}, {
//			field : 'mark',
//			title : '评语'
//		}, {
//			field : 'createDateStr',
//			title : '提交时间'
//		} ]
//	});
    $.get("ldhomeworkFB/appraise_list_page?homeworkId="+homeworkId, function(data){
    	bootbox.dialog({
				title : '评价列表',
				message : data,
				size : 'large',
				buttons : {
					cancel : {
						label : "关闭",
						className : 'btn-danger',
						callback : function() {
						}
					}
				}
			});
    	});
}

function operFormatter(value, row) {
	var homeworkId = row.id;
	var appraiseFlag = row.appraiseFlag;
	var operButton = "<div class='btn-group'><button class='btn btn-success correct'>批改作业</button><button class='btn btn-success appraise-list'>查看评价</button></div>"
	//var operButton = "<div class='btn-group'><button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>选择操作<span class='caret'></span></button><ul class='dropdown-menu' role='menu'><li><a class='correct' href='#'>批改作业</a></li><li class='divider'></li><li><a class='appraise-list' href='#'>查看评价</a></li></ul></div>"
	return operButton;
}

window.actionEvents = {
	'click .correct' : function(e, value, row, index) {
		var homeworkId = row.id;
		var appraiseFlag = row.appraiseFlag;
		var userId = row.userId;
		correctHomework(homeworkId, appraiseFlag, userId);
	},
	'click .appraise-list' : function(e, value, row, index) {
		var homeworkId = row.id;
		appraiseList(homeworkId);
	}
}
