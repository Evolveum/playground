var interval;
var showedInfoContent = 0;
var mouseover = false;
var currInfoSlider;

$(document).ready(function() {
	setMenuPosiotionWhileScroll();
	setMiddleHeight();
	
	
	$("#mailSliderArrows").css("opacity",.5);
	

	$(".tablesorter tbody tr").mouseover(function() {
		$(this).css("cursor", "pointer");
		$(this).css("background", "#bddbe4");
	});
	$(".tablesorter tbody tr").mouseout(function() {
		if ($(this).attr("class") === "odd") {
			$(this).css("background", "#F0F0F6");
		} else {
			$(this).css("background", "#FFF");
		}
		$(this).css("color", "#3D3D3D");
	});

	window.onresize = function() {
		setMenuPosiotionWhileScroll();
		setMiddleHeight();
	};
	
	
	
	/*$("#a").mouseenter(function(){
		alert($("#a").height());
		alert($("#b").height());*/
		/*$("#mailSlider").stop();
		var rowHeight = $("#mailRow").height() - 5;
		$("#mailSlider").css("height", rowHeight);
		$("#mailSlider").css("cursor","pointer");
		$("#mailSlider").css("opacity",0);
		$("#mailSlider").show();
		$("#mailSlider").animate({opacity: 1}, 200);*/
	/*});.mouseleave(function(){
		if(!showedInfoContent && !mouseover){
			$("#mailSlider").stop();
			$("#mailSlider").animate({opacity: 0}, 200, function(){
				$("#mailSlider").hide();
			});	
		}
	});*/
	/*
	$("#mailSlider").mouseenter(function(){
		$("#mailSliderArrows").stop();
		$("#mailSliderArrows").animate({opacity: 1}, 200);
		startTimerToShowInfoContent();
	}).mouseleave(function(){
		if(!showedInfoContent && !mouseover){
			//alert("tu");
			$("#mailSliderArrows").stop();
			$("#mailSliderArrows").animate({opacity: .5}, 200);
		} else {
			//alert("tam");
			hideInfoContent();
		}
	});
	
	$("#infoContent").mouseenter(function(){
		//
	}).mouseleave(function(){
	    mouseover = false;
	    hideInfoContent();
	});*/
});

function setMenuPosiotionWhileScroll() {
	$(window).scroll(function() {
		var scroll = $(window).scrollTop();
		if (scroll >= 65) {
			$("#navbar").css("position", "fixed");
			$("#navbar").css("top", "0px");
			$("#navbar").css("bottom", "auto");
		} else {
			$("#navbar").css("position", "absolute");
			$("#navbar").css("top", "auto");
			$("#navbar").css("bottom", "0px");
		}
	});
}

function setMiddleHeight(){
	var height = $(window).height();
	$("#mainTable").css("height", height - 115);
	/*$("#infoContent").css("height", $("#tableForm").height());
	$("#infoContent").css("width", $("#mainTable").width() - 574);*/
}

/*function setIntervalToShowContent(){
	interval = setInterval("showInfoContent()", 1500);
}

function showInfoContent(){
	$(".infoSlider").animate({"margin-right": "-2"}, 100);
	$(".infoSlider").css("border-right", "#F0F0F6");
	$("#infoContent").stop();
	$("#infoContent").css("opacity", 0);
	$("#infoContent").show();
	$("#infoContent").animate({opacity: 1}, 100);
	//mouseover = true;
}

function hideInfoContent(){
	//alert(mouseover);
	if(mouseover){
		showedInfoContent = 0;
		$("#infoContent").stop();
		$("#infoContent").animate({opacity: 0}, 100, function(){
			$("#infoContent").hide();
			$(".infoSlider").animate({"margin-right": "0"}, 0, function(){
				$(this).children(".infoSliderArrows").stop();
				$(this).children(".infoSliderArrows").animate({opacity: .5}, 200);
				stopTimerToShowInfoContent();
				//currInfoSlider.stop();
				$(this).animate({opacity: 0}, 200, function(){
					$(this).hide();
				});
			});
		});
	}
}

function showInfoContentTimer(){
	interval = setTimeout("showInfoContent()",1000);
}

function startTimerToShowInfoContent(){
	if (!showedInfoContent){
		showedInfoContent = 1;
		showInfoContentTimer();
	}
}

function stopTimerToShowInfoContent(){
	clearTimeout(interval);
	showedInfoContent = 0;
}*/
