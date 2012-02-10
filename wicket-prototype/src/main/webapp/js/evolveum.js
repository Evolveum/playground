var objectFormHelpButton = null;
var objectFormHelpContent = null;
var interval = 0;

$(document).ready(function() {
	
	$(".left-menu ul li").css("opacity", .8);
	$(".left-menu ul li a").css("opacity", .5);
	$(".left-menu").css("margin-top", - $(".left-menu ul").height() / 2);
	setTimeout("showLeftMenu()",500);
	
	$(".left-menu ul").mouseenter(function(){
		$(".left-menu ul").stop();
		$(".left-menu ul").animate({left: 0}, {duration: 500, easing: "easeOutQuart"});
	}).mouseleave(function(){
		$(".left-menu ul").stop();
		$(".left-menu ul").animate({left: -250}, {duration: 500, easing: "easeOutQuart"});
	});
	
	$(".left-menu ul li").mouseenter(function(){
		$(this).stop();
		$(this).find("a").stop();
		$(this).animate({opacity : 1}, 200);
		$(this).find("a").animate({opacity : 1}, 250);
	}).mouseleave(function(){
		$(this).stop();
		$(this).find("a").stop();
		$(this).animate({opacity : .8}, 200);
		$(this).find("a").animate({opacity : .5}, 250);
	});
	
	$(".objectFormHeaderControllButtonMinMax").click(function(){
		var id = $(this).attr("id");
		var tableForm = id.substring((id.length) - 11, id.length); 
		
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
	
	$(".objectFormAttribute").mouseenter(function(){
		objectFormHelpButton = $(this).find(".objectFormHelpButton");
		objectFormHelpContent = $(this).find(".objectFormHelpContent");

		interval = setTimeout("showFormHelpContent()",1000);
	}).mouseleave(function(){
		hideFormHelpContent();
	});
});

function showLeftMenu() {
	$(".left-menu ul").animate({left: -250}, {duration: 500, easing: "easeOutQuart"});
}

function showFormHelpContent(){
	objectFormHelpContent.show();
	objectFormHelpButton.show();
	clearTimeout(interval);
}

function hideFormHelpContent(){
	clearTimeout(interval);
	objectFormHelpContent.hide();
	objectFormHelpButton.hide();
}
