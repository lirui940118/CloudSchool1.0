var infoBut = {
		fadeOut:function(){
			count++;
			if(count==sumCount){
				$("#hezi").fadeOut();
			}
		},
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
							var zz = false;
							for (var j = 0; j < data.length; j++) {
								console.log(j)
								var url = input[i].getAttribute("moduleUrl");
								if (url == data[j].moduleurl) {
									console.log(url + "," + data[j].moduleurl);
									zz = true;
								}
							}
							if (!zz) {
								console.log(zz);
								input[i].remove();
							}
						}else{
							console.log("删除")
							input[i].remove();
						}
					}
				}
			});
		}
		infoBut.fadeOut();
	}
}
