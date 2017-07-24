<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<style>


.glyphicon {

    font-size: 20px;
}

.blueColor{

	color: #2B60DE;
}

.blueMidNight{
	color: #151B54;
}

.greenColor{

	color: green;
}

.yellowColor{

	color: yellow;

}
</style>
<security:authorize access="isAuthenticated()">
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li class="${current == 'users' ? 'active' : ''}"><a href="/users/usersDetails.html"><i class="glyphicon glyphicon-user blueColor"></i><i
					class="glyphicon glyphicon-user blueMidNight"></i>&nbsp;&nbsp; Users / Permissions</a></li>
			<li><a href="/projects/projectsDetails.html"><i
					class="glyphicon glyphicon-folder-open blueColor"></i> &nbsp;&nbsp;Projects / Audio Files</a></li>
			<li class="active"><a href="/users/userRequests.html"><i
					class="glyphicon glyphicon-list-alt blueColor"></i>&nbsp;&nbsp; User's requests</a></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->

</security:authorize>