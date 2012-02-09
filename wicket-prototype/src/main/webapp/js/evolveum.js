$(document).ready(function() {
	
	
	$(".objectFormHeaderControllButtonMinMax").click(function(){
		var id = $(this).attr("id");
		var tableForm = id.substring((id.length) - 11, id.length); 
		//alert(tableForm);
		
		if($(this).attr("src").indexOf("Minimize") != -1){
			var img = $(this).attr("src").replace("Minimize","Maximize");
			$(this).attr("src", img);
			$(this).attr("title", "Maximize");
			$("#tbody_" + tableForm).hide();
			$("#tfoot_" + tableForm).hide();
			
		} else {
			var img = $(this).attr("src").replace("Maximize","Minimize");
			$(this).attr("src", img);
			$(this).attr("title", "Minimize");
			$("#tbody_" + tableForm).show();
			$("#tfoot_" + tableForm).show();
		}
	});
	
	$(".objectFormHeaderControllButtonShowEmptyFields").click(function(){
		if($(this).attr("src").indexOf("Show") != -1){
			var img = $(this).attr("src").replace("Show","Hide");
			$(this).attr("src", img);
			$(this).attr("title", "Hide empty fields");
			
		} else {
			var img = $(this).attr("src").replace("Hide","Show");
			$(this).attr("src", img);
			$(this).attr("title", "Show empty fields");
		}
	});
});

