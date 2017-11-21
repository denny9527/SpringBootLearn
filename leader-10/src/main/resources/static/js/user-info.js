$(document).ready(function() {
	$("#saveButton").click(function() {
		saveUserInfo();
	});
});

function saveUserInfo() {
	$("#ageError").html("");
	$("#nameError").html("");
	$.ajax({
		cache : false,
		dataType : "json",
		type : "POST",
		url : $("#userInfoForm").attr("action"),
		async : false,
		data : $("#userInfoForm").serialize(),
		success : function(data) {
			if (data.resultCode == "1") {
				window.location.href = data.url;
			} else {
				$("#ageError").html(data.resultMap.age);
				$("#nameError").html(data.resultMap.name);
			}
		}

	});
}