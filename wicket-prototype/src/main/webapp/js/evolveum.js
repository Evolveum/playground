var objectFormHelpContainer = null;
var interval = 0;

window.onresize = function() {
	//setMenuPositionWhileScroll();
	setFooterPos();
}; 

$(document).ready(function() {
	
	setMenuPositionWhileScroll();
	setFooterPos();
	
	$(".left-menu ul li").css("opacity", .8);
	$(".left-menu ul li a").css("opacity", .5);
	$(".left-menu ul").css("margin-top", - $(".left-menu ul").height() / 2);
	setTimeout("showLeftMenu()",500);
	$(".left-menu .selected-left").css("opacity", 1);
	$(".left-menu .selected-left").append("<img class='leftNavArrow' src='../../img/leftNavArrow.png' alt='' />");
	$(".left-menu .selected-left").parent().css("opacity", 1);
	$(".left-menu .selected-left").parent().css("background", "#333333");
	
	$(".left-menu ul").mouseenter(function(){
		$(".left-menu ul").stop();
		$(".left-menu ul").animate({left: 0}, {duration: 500, easing: "easeOutQuart"});
	}).mouseleave(function(){
		$(".left-menu ul").stop();
		$(".left-menu ul").animate({left: -252}, {duration: 500, easing: "easeOutQuart"});
	});
	
	$(".left-menu ul li").mouseenter(function(){
		$(this).stop();
		$(this).find("a").stop();
		if($(this).attr("class") != "leftMenuTopClear" && $(this).attr("class") != "leftMenuBottomClear"){
			$(this).animate({opacity : 1}, 200);
			$(this).find("a").animate({opacity : 1}, 250);
		}
		
	}).mouseleave(function(){
		$(this).stop();
		$(this).find("a").stop();
		if($(this).find("a").attr("class") != "selected-left"){
			$(this).animate({opacity : .8}, 200);
			$(this).find("a").animate({opacity : .5}, 250);
		}
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
		objectFormHelpContainer = $(this).find(".objectFormHelpContainer");

		interval = setTimeout("showFormHelpContainer()",1000);
	}).mouseleave(function(){
		hideFormHelpContainer();
	});
});

function showLeftMenu() {
	if($(".left-menu ul").find(".leftMenuRow").html() != null){
		$(".left-menu ul").animate({left: -252}, {duration: 500, easing: "easeOutQuart"});
	}
}

function showFormHelpContainer(){
	objectFormHelpContainer.show();
	clearTimeout(interval);
}

function hideFormHelpContainer(){
	clearTimeout(interval);
	objectFormHelpContainer.hide();
}

function setMenuPositionWhileScroll() {
	if (($.browser.msie && $.browser.version >= 9.0) || (!$.browser.msie)) {
		$(window).scroll(function() {
			var scroll = $(window).scrollTop();
			if (scroll >= 60) {
				$(".top-menu").css("position", "fixed");
				$(".top-menu").css("top", "0px");
			} else {
				$(".top-menu").css("position", "absolute");
				$(".top-menu").css("top", "60px");
			}
		}); 
	 } 
}

function setFooterPos(){
	var winHeight = $(window).height();
	var contentHeight = $(".content").height() + 200;
	//alert(height);
	if(winHeight > contentHeight){
		$("#footer").css("position", "absolute");
		$("#footer").css("bottom", 0);
	} else {
		$("#footer").css("position", "relative");
		$("#footer").css("bottom", 0);
	}
}
