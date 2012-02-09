$(document).ready(function() {
	
	
	$("#objectFormHeaderControllButtonMinMax_tableForm01").click(function(){
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
		//if (str)

		/*$("#tbody_" + tableForm).animate({opacity : 0}, 300,function(){
			$("#tbody_" + tableForm).hide();
		});
		$("#tfoot_" + tableForm).animate({opacity : 0}, 300,function(){
			$("#tfoot_" + tableForm).hide();
		});
		*/
	});
});

