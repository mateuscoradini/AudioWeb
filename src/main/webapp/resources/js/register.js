/**
 * User Register JS
 */

$(document)
		.ready(
				function() {

					$(".userRegisterForm")
							.validate(
									{
										rules : {
											name : {
												required : true,
												minlength : 3,
												remote : {
													url : "<spring:url value='/register/available.html' />",
													type : "get",
													data : {
														username : function() {
															return $("#username")
																	.val();
														}
													}
												}
											},
											email : {
												required : true,
												email : true
											},
											password : {
												required : true,
												minlength : 5
											},
											password_again : {
												required : true,
												minlength : 5,
												equalTo : "#password"
											}
										},
										highlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-success')
													.addClass('has-error');
										},
										unhighlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-error')
													.addClass('has-success');
										},
										messages : {
											name : {
												remote : "Such username already exists!"
											}
										}
									});
				});


function addViaAjax() {
	/*
	 * var json = { "username" : $('#username').val(), "email" :
	 * $('#email').val(), "name" : $('#name').val(), "password" :
	 * $('#password').val() };
	 * 
	 * ADD USER $.ajax({ type : "POST", contentType : "application/json", url :
	 * "/addUser", data : JSON.stringify(json), mimeType : 'application/json',
	 * contentType : 'application/json', dataType : 'json', timeout : 100000,
	 * success : function(data) { console.log("SUCCESS: ", data);
	 * $("#sucessMsgDiv").addClass("in")
	 * $("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);
	 * setTimeout(function() { window.location.href = "/login.html"; }, 3000);
	 *  }, error : function(e) { console.log("ERROR: ", e); }, done :
	 * function(e) { console.log("DONE"); } });
	 */
	
	

};
