jQuery.noConflict()(function($) {
	$(document).ready(function() {
		$('#emergency').click(function(e) {
			window.location = '/emergency';
		});
	});
	$(document).ready(function() {
		$('#ambulance').click(function(e) {
			window.location = '/ambulance';
		});
	});
	
	
});