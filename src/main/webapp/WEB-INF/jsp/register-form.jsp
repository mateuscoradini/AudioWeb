<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>

<link href="<c:url value="/resources/css/sb-admin.css" />"
	rel="stylesheet">

<!-- script type="text/javascript"
	src="<c:url value="/resources/js/register.js" />"></script> -->


<div class="col-lg-12">
	<!-- div id="sucessMsgDiv" class="alert alert-success fade"
		style="display: none">
		<strong>Success!</strong>
	</div> -->

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successfull!</div>
	</c:if>

	<form:form id="userRegisterForm" commandName="user" method="post"
		class="form-horizontal">
		<div id="alert"></div>
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-xs-8">
				<form:input id="username" path="username" cssClass="form-control" />
				<form:errors path="username" />
			</div>
		</div>

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Complete
				Name</label>
			<div class="col-xs-8">
				<form:input id="name" path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-xs-8">
				<form:input id="email" path="email" cssClass="form-control" />
				<form:errors path="email" />
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-xs-8">
				<form:password id="password" path="password" cssClass="form-control" />
				<form:errors path="password" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password
				again:</label>
			<div class="col-xs-8">
				<input type="password" name="password_again" id="password_again"
					class="form-control" />
			</div>
		</div>

		<center>
			<div class="form-group">
				<div class="col-sm-offset-2 col-xs-8">
					<button type="submit" class="btn btn-primary">Register</button>
					<button type="reset" class="btn btn-primary">Clear</button>
				</div>
			</div>
		</center>

	</form:form>
</div>


<script>

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


</script>
