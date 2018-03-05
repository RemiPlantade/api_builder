
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

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		if (options.type == "POST") {
			xhr.setRequestHeader(header, token);
		}
	});

	$('#restart_button').click(function(){
		$port = $(".serverPort").text();
		$homeUrl = location.protocol+'//'+location.hostname + ":" +$port;
		$.post("/restart", function(data, status){
			console.log($(".modal"));
			$(".modal").addClass("is-active");
			tryLoadHomePage($homeUrl);
		});
	});

	function tryLoadHomePage($homeUrl){
		$.ajax({
			url : $homeUrl,
			type : 'HEAD',
			success : function(json) {
				window.location = $homeUrl;
			},
			error : function(xhr, textStatus, errorThrown ) {
				if (textStatus == 'timeout') {
					console.log("timeout");
					setTimeout(function () {
						tryLoadHomePage($homeUrl)
					}, 1000);
				}            
				if (xhr.status == 500) {
					console.log("500");
					setTimeout(function () {
						tryLoadHomePage($homeUrl);
					}, 1000);

				} else {
					console.log("In else");
					setTimeout(function () {
						tryLoadHomePage($homeUrl);
					}, 1000);
				}
			}
		});
	}
});