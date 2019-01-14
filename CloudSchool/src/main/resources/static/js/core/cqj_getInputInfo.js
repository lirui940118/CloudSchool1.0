var info = {
	getParam: function(selector) {
		var inputs = document.querySelector(selector).querySelectorAll("input");
		var textareas = document.querySelector(selector).querySelectorAll("textarea");
		var paramValue = {};
		for(var i = 0; i < inputs.length; i++) {
			var name = inputs[i].getAttribute("name");
			if(name) {
				paramValue[name] = inputs[i].value;
			}
		}
		for(var j = 0; textareas && j < textareas.length; j++) {
			var name = textareas[j].getAttribute("name");
			if(name) {
				paramValue[name] = inputs[j].value;
			}
		}
		return paramValue;
	},
	get
};
