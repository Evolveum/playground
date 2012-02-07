var interval;
var showedInfoContent = 0;

$(document).ready(function() {
	setMenuPosiotionWhileScroll();
	setMiddleHeight();
	
	$(".infoSliderArrows").css("opacity",.5);
	

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
	
	
	
	$(".tableRow").mouseenter(function(){
		$(this).children(".tableFormInput").children(".infoSlider").stop();
		var tableFormInputHeight = $(this).children(".tableFormInput").height() - 1;
		$(this).children(".tableFormInput").children(".infoSlider").css("height", tableFormInputHeight);
		$(this).children(".tableFormInput").children(".infoSlider").css("cursor","pointer");
		$(this).children(".tableFormInput").children(".infoSlider").css("opacity",0);
		$(this).children(".tableFormInput").children(".infoSlider").show();
		$(this).children(".tableFormInput").children(".infoSlider").animate({opacity: 1}, 200);
	});

	$(".tableRow").mouseleave(function(){
		$(this).children(".tableFormInput").children(".infoSlider").stop();
		$(this).children(".tableFormInput").children(".infoSlider").animate({opacity: 0}, 200, function(){
			$(this).children(".tableFormInput").children(".infoSlider").hide();
		});
	});
	
	$(".infoSlider").mouseenter(function(){
		$(this).children(".infoSliderArrows").stop();
		$(this).children(".infoSliderArrows").animate({opacity: 1}, 200);
		startTimerToShowInfoContent();
	});
	
	$(".infoSlider").mouseleave(function(){
		if(!showedInfoContent){
			$(this).children(".infoSliderArrows").stop();
			$(this).children(".infoSliderArrows").animate({opacity: .5}, 200);
		} else {
			hideInfoContent();
		}
	});
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
	var height = $(window).height() - 115;
	$("#mainTable").css("height", height);
}

function setIntervalToShowContent(){
	interval = setInterval("showInfoContent()", 1500);
}

function showInfoContent(){
	$(".infoSlider").animate({"margin-right": "-2"}, 100);
}

function hideInfoContent(){
	showedInfoContent = 0;
	$(".infoSlider").animate({"margin-right": "0"}, 0, function(){
		$(this).children(".infoSliderArrows").stop();
		$(this).children(".infoSliderArrows").animate({opacity: .5}, 200);
		stopTimerToShowInfoContent();
	});
}

function showInfoContentTimer(){
	interval = setTimeout("showInfoContent()",500);
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
}
