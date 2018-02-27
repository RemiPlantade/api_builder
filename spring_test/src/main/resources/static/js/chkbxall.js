
$( document ).ready(function() {
	$('.chkbx_main_selection').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_selection').attr('checked', true);
		} else {
			$('.chkbx_selection').attr('checked', false);
		}
	});
	$('.chkbx_main_creation').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_creation').attr('checked', true);
		} else {
			$('.chkbx_creation').attr('checked', false);
		}
	});
	$('.chkbx_main_updating').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_updating').attr('checked', true);
		} else {
			$('.chkbx_updating').attr('checked', false);
		}
	});
	$('.chkbx_main_deletion').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_deletion').attr('checked', true);
		} else {
			$('.chkbx_deletion').attr('checked', false);
		}
	});
});