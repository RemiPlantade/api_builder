
$( document ).ready(function() {
	$('.chkbx_main_selection').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_selection:enabled').prop('checked',true);
		} else {
			$('.chkbx_selection:enabled').prop('checked',false);
		}
	});
	$('.chkbx_main_creation').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_creation:enabled').prop('checked', true);
		} else {
			$('.chkbx_creation:enabled').prop('checked', false);
		}
	});
	$('.chkbx_main_updating').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_updating:enabled').prop('checked', true);
		} else {
			$('.chkbx_updating:enabled').prop('checked', false);
		}
	});
	$('.chkbx_main_deletion').click(function() {
		if ($(this).is(':checked')) {
			$('.chkbx_deletion:enabled').prop('checked', true);
		} else {
			$('.chkbx_deletion:enabled').prop('checked', false);
		}
	});
});