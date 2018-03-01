
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
	
	function selectGroup() {
		$("select.groupSelect > option").each(function() {
			if($(this).parent().hasClass("nogroup")){
				if($(this).hasClass("nogroup")){
					$(this).prop('selected',true);
				}else{
					$(this).prop('selected',false);
				}
			}else{
				if($(this).hasClass($(this).parent().attr('class').split(' ')[1])){
					$(this).prop('selected',true);
				}else{
					$(this).prop('selected',false);
				}
			}
		    
		});
	}
	
	selectGroup();
	
});