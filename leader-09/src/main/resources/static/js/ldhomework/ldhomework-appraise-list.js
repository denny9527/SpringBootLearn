$(document).ready(function() {
	$('#appraiseTable').bootstrapTable('destroy').bootstrapTable({
		method : "get",
		url : "ldhomeworkFB/appraise_list?homeworkId=" + homeworkId,
		columns : [ {
			field : 'appraiseUserAccount',
			title : '学员账号'
		}, {
			field : 'appraiseUserName',
			title : '学员姓名'
		}, {
			field : 'appraise',
			title : '评价'
		}, {
			field : 'level',
			title : '作业等级'
		}, {
			field : 'mark',
			title : '评语'
		}, {
			field : 'createDateStr',
			title : '提交时间'
		} ]
	});
});
