var infoBut = {
	ccc : function() {
		var input = $("[infoBut]");
		console.log(input);
		if (input) {
			$.ajax({
				type : "post",
				url : "/module/getInfoModule",
				success : function(data) {
					console.log(data);
					for (var i = 0; i < input.length; i++) {
						if (data.length > 0) {
							for (var j = 0; j < data.length; i++) {
								var isExist = false;
								var url = input[i].getAttribute("moduleUrl");
								if (url == data[j].moduleurl) {
									console.log(url + "," + data[j].moduleurl);
									console.log(isExist);
									isExist = true;
								}
								if (!isExist) {
									input[i].remove();
								}
							}
						}else{
							input[i].remove();
						}
					}
				}
			});
		}
	}
}
