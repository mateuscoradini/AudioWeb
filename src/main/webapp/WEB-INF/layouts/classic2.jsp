<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@	taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Privates Audio Web">
<meta name="author" content="Mateus Coradini (mateuscoradini@gmail.com)">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<link href="<c:url value="/resources/css/sb-admin.css" />"
	rel="stylesheet">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript"	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
<link href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css" rel="stylesheet">	

<title><tiles:getAsString name="title"></tiles:getAsString></title>
<tilesx:useAttribute name="current" />
<style>
.noDisplaySucessMsgDiv{
	display: none;
}
</style>
</head>
<body>
	<div id="wrapper">

		<tilesx:useAttribute name="current" />
		<tilesx:useAttribute name="title" />

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<!-- Navigation -->
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu" />
		</nav>



		<div id="page-wrapper">
			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">${title}</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>
	</div>


	<center>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</center>

	</div>


</body>
</html>