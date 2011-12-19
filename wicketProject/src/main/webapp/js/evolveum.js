$(document).ready(function() {
	$(".tablesorter tbody tr").mouseover(function() {
		$(this).css("cursor", "pointer");
		$(this).css("background", "#C1CBD4");
		$(this).css("color", "white");
	});
	$(".tablesorter tbody tr").mouseout(function() {
		if ($(this).attr("class") === "odd") {
			$(this).css("background", "#F0F0F6");
		} else {
			$(this).css("background", "#FFF");
		}
		$(this).css("color", "#3D3D3D");
	});
});