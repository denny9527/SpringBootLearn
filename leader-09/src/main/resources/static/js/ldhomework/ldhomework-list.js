function operFormatter(value, row) {
	var homeworkId = row.id;
	var operButton = "<button class='btn btn-success appraise-list'>查看评价</button>"
	return operButton;
}

function appraiseList(homeworkId) {
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

window.actionEvents = {
	'click .appraise-list' : function(e, value, row, index) {
		var homeworkId = row.id;
		appraiseList(homeworkId);
	}
}

function downloadLinkFormatter(value, row) {
	var href = "/ldhomework/download?filePath=" + row.homeworkFilePath
			+ "&fileName=" + encodeURIComponent(row.homeworkFileName);
	return "<a href='" + href + "'>" + row.homeworkFileName + "</a>";
}