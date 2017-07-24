<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@	taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>

.whiteColor{color: white}

.paddingZero{padding: 8px}



</style>


<!-- Brand and toggle get grouped for better mobile display -->
<div style="color: white" class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-ex1-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar">	</span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand paddingZero" rel="home" href="#" title="Buy Sell Rent Everyting">
      <img src="<c:url value="/resources/images/private-logo.png" />"  width="50" height="100" class="img-circle img-responsive" alt="Cinque Terre"/>      
    </a>
	<security:authorize access="isAuthenticated()">
	
		<a class="navbar-brand" href="/logged.html">Privates Audio Web</a>
	</security:authorize>
	<security:authorize access="!isAuthenticated()">
			
		<a class="navbar-brand" href="index.html">Privates Audio Web</a>
	</security:authorize>
</div>
<ul class="nav navbar-right top-nav">
	<li class="dropdown">
	
		<security:authorize	access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-left">
				<li style="padding-top: 20px; padding-right: 400px;"class="active whiteColor">Welcome: <%=request.getUserPrincipal().getName()%> your last login is 21:00 12/01/2016.</li>			

			</ul>
		</security:authorize>

		<ul class="nav navbar-nav navbar-left">
			<security:authorize access="isAuthenticated()">
				<li class="active"><a
					href='<spring:url value="/logged.html" />'>Home</a></li>
			</security:authorize>
								
			<li class="${current == 'register' ? 'active' : ''}"><a
				href='<spring:url value="/register.html" />'>Register</a></li> 

		


		</ul>

		<ul class="nav navbar-nav navbar-right" style="margin-right: 10px">


			<security:authorize access="!isAuthenticated()">
				<li class="${current == 'login' ? 'active' : ''}"><a
					href='<spring:url value="/login.html" />'>Login</a></li>
			</security:authorize>


			<security:authorize access="isAuthenticated()">
				<li class="dropdown"><a style="color: white" href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="glyphicon glyphicon-user"></i> <%=request.getUserPrincipal().getName()%>
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<spring:url value="/account.html" />"><i
								class="fa fa-fw fa-user"></i> Profile</a></li>
						<li class="divider"></li>
						<li><a href="<spring:url value="/logout" />"><i
								class="fa fa-fw fa-power-off"></i> Log Out</a></li>
					</ul></li>
			</security:authorize>
		</ul></li>
</ul>





