<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layouts/taglib.jsp"%>

<style>

.greenColor{

	color: green;

}

.redColor{

	color: red;

}

.active>th {
	background-color: black;
}

.table>thead>tr>td.active, .table>tbody>tr>td.active, .table>tfoot>tr>td.active,
	.table>thead>tr>th.active, .table>tbody>tr>th.active, .table>tfoot>tr>th.active,
	.table>thead>tr.active>td, .table>tbody>tr.active>td, .table>tfoot>tr.active>td,
	.table>thead>tr.active>th, .table>tbody>tr.active>th, .table>tfoot>tr.active>th
	{
	background-color: black;
	color: #FFFFFF;
}
</style>

<div class="col-lg-12">
	<div id="sucessMsgDiv" class="alert alert-success fade"
		style="display: none">
		<strong>Success!</strong>
	</div>
	<h3 class="page-header">Request's</h3>
	<!-- Page Heading -->
	<div class="row">
		<div class="col-sm-12">

			<form:form id="userTableForm" commandName="user" method="post"
				class="form-horizontal">

				<div class="table-responsive">
					<table id="tableUsersRequests"
						class="table table-bordered dataTable no-footer" cellspacing="0"
						width="100%" role="grid" aria-describedby="example_info"
						style="width: 100%;">
						<thead>
							<tr>
								<th>Username</th>
								<th>Name</th>
								<th>Project</th>
								<th>Audio Filename</th>
							</tr>
						</thead>

						<tbody>
						</tbody>

					</table>
				</div>

			</form:form>

		</div>
	</div>
	<div id="feedback"></div>
</div>



<script type="text/javascript">
	jQuery(document).ready(function($) {
		loadUserRequestsTable();

		

	});	
	
	function tableDym() {
		var table = $('#tableUsersRequests').DataTable();

		$('#tableUsersRequests tbody').on('click', 'tr', function() {
			if ($(this).hasClass('active')) {
				$(this).removeClass('active');
				console.log($(this));
			} else {
				table.$('tr.active').removeClass('active');
				$(this).addClass('active');
				var child = $(this);
				var userName = child.children('#tdUserName').text();
				$('#userInformation').html("");
				loadInformation(userName);
				console.log(userName);
			}

			/*loadInformation();*/

		});

	};
	

	/*Remove User*/
	function acceptByAjax(audioRoleId) {

		var json = {
			"username" : $('#username').val(),
			"email" : $('#email').val(),
			"name" : $('#name').val(),
			"password" : $('#password').val()
		};
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "audioUser/acceptByAjax",
			data : JSON.stringify(audioRoleId),
			mimeType : 'application/json',
			contentType : 'application/json',
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				loadUserRequestsTable();
				$("#sucessMsgDiv").addClass("in")
				$("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);
			}
		});

	}

	/* LIST USER */
	function loadUserRequestsTable() {

		var json = {
			"string" : 'a'
		};
		$
				.ajax({
					type : "POST",
					contentType : "application/json",
					url : "${home}usersAudioRequest",
					data : JSON.stringify(json),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						/*display(data);*/
						var htmlrows = "<thead>	<tr><th>Username</th><th>Name</th><th>Project</th><th>Audio Filename</th><th>Deny</th><th>Accept</th></tr></thead><tbody>";

						$
								.each(
										data,
										function(key, user) {

											var htmlrow = "<td id='tdUserName'>"
													+ user.username
													+ "</td>"
													+ "<td> "
													+ user.name
													+ "</td>"
													+ "<td> "
													+ user.project.name
													+ "</td>"
													+ "<td> "
													+ user.audio.fileName
													+ "</td>"
													+ "<td style='text-align: center;'><a onclick=denyByAjax('"
													+ user.audioRole.id
													+ "')  class='imageAnchor' href='#'><i class='glyphicon glyphicon-remove-sign redColor'></i></td>"
													+ "<td style='text-align: center;'><a onclick=acceptByAjax('"
													+ user.audioRole.id
													+ "')  class='imageAnchor' href='#'><i class='glyphicon glyphicon-ok-sign greenColor'></i></td>"
													+"</tr>";

											htmlrows += htmlrow;

										})
						htmlrows += "</tbody>";

						$('#tableUsersRequests').html(htmlrows);
						tableDym();

					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE: ", e);
						tableDym();

					}
				});

	}
</script>