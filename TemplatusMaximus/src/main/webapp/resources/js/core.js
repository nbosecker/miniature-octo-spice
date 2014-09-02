$(document).ready(function () {

	$('.navbar li.active').removeClass('active');
  	$('a[href="' + this.location.pathname + '"]').parent().addClass('active');

});

