
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
	
	$('#linkToNewPage').click(function(){
		window.top.close();
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
		$newProtocol = "http:";
		if($("#httpsEnabled").text() == "true"){
			$newProtocol = "https:";
		}
		$port = $("#serverPort").text();
		$homeUrl = $newProtocol + '//' + location.hostname + ":" +$port;
		console.log($homeUrl);
		$.post("/restart", function(data, status){
			$(".modal").addClass("is-active");
//			$nbTest = 10;
//			tryLoadHomePage($homeUrl,$nbTest);
			//$(".modal").removeClass("is-active");
			$("#restart_redirect_modal").append('Home page will be available in few seconds on url : <a id="linkToNewPage" href="' + $homeUrl + '" target="blank">' + $homeUrl +'</a>');
		});
	});

	function tryLoadHomePage($homeUrl,$nbTest){
		if($nbTest > 0){
			$.ajax({
				url : $homeUrl,
				type : 'HEAD',
				success : function(json) {
					document.cookie = 'JSESSIONID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
					$("#restart_redirect_modal").append('The page is now available on url : <a href="' + $homeUrl + '" target="blank">' + $homeUrl +'</a>');
					//window.location = $homeUrl;
				},
				error : function(xhr, textStatus, errorThrown ) {
					if (textStatus == 'timeout') {
						console.log("timeout");
						setTimeout(function () {
							$nbTest = $nbTest-1;
							tryLoadHomePage($homeUrl,$nbTest)
						}, 1000);
					}            
					if (xhr.status == 500) {
						console.log("500");
						setTimeout(function () {
							$nbTest = $nbTest-1;
							tryLoadHomePage($homeUrl,$nbTest);
						}, 1000);

					} else {
						console.log("In else");
						setTimeout(function () {
							$nbTest = $nbTest-1;
							tryLoadHomePage($homeUrl,$nbTest);
						}, 1000);
					}
				}
			});
		}
		//window.location = $homeUrl;
	}
});