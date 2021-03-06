<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

<style>

.form-signin {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	padding-bottom: 150px;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
<div class="col-lg-4">
	<img src="<c:url value="/resources/images/private-logo-example2.png" />" class="img-circle img-responsive" alt="Cinque Terre">

</div>
<div class="col-lg-8">
<form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check" />" method="POST">
	<h2 class="form-signin-heading">Please log in</h2>
	<input type="text" name="j_username" class="form-control" placeholder="Username" required autofocus> 
	<input type="password" name="j_password" class="form-control" placeholder="Password" required> 
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
</div>
