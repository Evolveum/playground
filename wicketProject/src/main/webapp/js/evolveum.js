$(document).ready(function() {
	setMenuWhileScroll();
	
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
		setMenuWhileScroll();
	};
});

function setMenuWhileScroll() {
	$(window).scroll(function() {
		var scroll = $(window).scrollTop();
		if (scroll >= 67) {
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