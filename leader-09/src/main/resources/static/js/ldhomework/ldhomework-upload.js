$(document).ready(function() {
	$("#homeworkFile").fileinput({
		language : 'zh',
		uploadUrl : "/ldhomework/upload",
		autoReplace : true,
		maxFileCount : 1,
		maxFileSize : 20480,
		allowedFileExtensions : [ "pdf", "ppt","pptx" ],
		browseClass : "btn btn-primary", // 按钮样式
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
	}).on("fileuploaded", function(e, data) {
		var res = data.response;
		if (res.resultCode == "0") {
			bootbox.alert(res.info);
		} else {
			$("#homeworkFilePath").val(res.resultMap.filePath);
			$("#homeworkFileName").val(res.resultMap.fileName);
			bootbox.alert(res.info);
		}
	})
	
	$("#submitButton").click(function() {
		saveHomework();
	});
});

function saveHomework() {
	var filePath = $("#homeworkFilePath").val();
	var fileName = $("#homeworkFilePath").val();
	if(filePath == '' || fileName == ''){
		bootbox.alert("请上传文件!");
		return;
	}
	$.ajax({
		cache : false,
		dataType : "json",
		type : "POST",
		url : "/ldhomework/save",
		async : false,
		data : $("#ldhomeworkForm").serialize(),
		success : function(data) {
			if (data.resultCode == "0") {
				bootbox.alert(data.info);
			} else {
				bootbox.alert(data.info, function() {
					navi2page(data.url);
				});
			}
		}

	});
}