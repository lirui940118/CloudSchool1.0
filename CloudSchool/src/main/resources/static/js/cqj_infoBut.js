var infoBut = {
		fadeOut:function(){
			count++;
			if(count==sumCount){
				$("#hezi").fadeOut();
			}
		},
	ccc : function() {
		var input = $("[infoBut]");
		if (input) {
			$.ajax({
				type : "post",
				url : "/module/getInfoModule",
				success : function(data) {
					for (var i = 0; i < input.length; i++) {
						if (data.length > 0) {
							var zz = false;
							for (var j = 0; j < data.length; j++) {
								var url = input[i].getAttribute("moduleUrl");
								if (url == data[j].moduleurl) {
									console.log(url + "," + data[j].moduleurl);
									zz = true;
								}
							}
							if (!zz) {
								input[i].remove();
							}
						}else{
							input[i].remove();
						}
					}
					infoBut.fadeOut();
					console.log(sumCount+":"+count);
				}
			});
		}
		
	}
}
