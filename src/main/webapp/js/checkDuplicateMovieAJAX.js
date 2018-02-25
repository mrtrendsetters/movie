function checkDuplicate(movieName, operation) {
	
	var request;
	var requestURL;
	var ajaxData = "movieName=" + movieName;
	if(operation == "add") {
		requestURL = "checkDuplicate";
	} else if(operation == "update") {
		requestURL = "../checkDuplicate";
	}
	
	
	request = $.ajax({
		url: requestURL,
		type: "post",
		data: ajaxData,
		cache: false,
		success: function(result){
			if(result == "true") {
				$("#dupMovie").html("");
				$('#submit').attr('disabled',false);
			} else {
				$("#dupMovie").html("Movie already exists.");
				$('#submit').attr('disabled',true);
			}
		},
		error: function(result){
			$("#dupMovie").html("Error executing AJAX.");
			console.log(result);
		}
	});
	
}