function getXMLObject() // XML OBJECT
{
	var xmlHttp = false;
	try {
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft
		// Browsers
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // For Microsoft
			// IE 6.0+
		} catch (e2) {
			xmlHttp = false; // No Browser accepts the XMLHTTP Object then
			// false
		}
	}
	if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
		xmlHttp = new XMLHttpRequest(); // For Mozilla, Opera Browsers
	}
	return xmlHttp; // Mandatory Statement returning the ajax object created

}
var xmlhttp = new getXMLObject();

function reqAjax(url, responseFunction) {
	if (xmlhttp) {
		xmlhttp.open("GET", url, false);
		xmlhttp.onreadystatechange = function() {
			responseAjax(responseFunction);
		};
		xmlhttp.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
		xmlhttp.send();
	}
}

function responseAjax(responseFunction) {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var content = xmlhttp.responseText;
		if (content == null || content == undefined || content == '') {
			alert("Chyba spojenia!");
			return;
		}
		if (content.indexOf("OK") != -1) {
			return;
		}

		try {
			obj = jQuery.parseJSON(content);

		} catch (e) {
			alert(e);

			return;
		}
		if (obj.errorMessage != undefined) {
			alert(obj.errorMessage + " " + obj.errorDetails);
		}
		responseFunction.call(null, obj);

	}
}