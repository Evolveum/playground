$(document).ready(function() {
	//var leftMenuPosition = $(".left-menu ul").height() / 2;
	$(".left-menu ul li").css("opacity", .9);
	
	$(".left-menu").css("margin-top", - $(".left-menu ul").height() / 2);
	
	$(".left-menu ul").mouseenter(function(){
		
	});
	
	$(".left-menu ul li").mouseenter(function(){
		//alert($(".left-menu ul li").children());
		$(this).stop();
		$(this).animate({opacity : 1}, 200);
		alert($(this).children(".label").text());
		$(this).children(".label").animate({color: "#FFFFFF"}, 200);
	}).mouseleave(function(){
		$(this).stop();
		$(this).animate({opacity : .9}, 200);
		$(this).children(".label").animate({color: "#868686"}, 200);
	});
	
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

