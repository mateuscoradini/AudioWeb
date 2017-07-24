<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layouts/taglib.jsp"%>

<style>
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

.redColor{

	color: red;

}
</style>


<div class="col-lg-12">
	<div id="sucessMsgDiv" class="alert alert-success fade"
		style="display: none">
		<strong>Success!</strong>
	</div>
	<h3 class="page-header">Registered User's</h3>
	<!-- Page Heading -->
	<div class="row">
		<div class="col-sm-12">

			<form:form id="userTableForm" commandName="user" method="post"
				class="form-horizontal">

				<div class="table-responsive">
					<table id="tableUsers"
						class="table table-bordered dataTable no-footer" cellspacing="0"
						width="100%" role="grid" aria-describedby="example_info"
						style="width: 100%;">
						<thead>
							<tr>
								<th>Username</th>
								<th>Name</th>
								<th>Email</th>
								<th>Del</th>
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

<div class="col-lg-6">
	<div align="center" class="embed-responsive embed-responsive-16by9">

	</div>

	
</div>


<script type="text/javascript">
	jQuery(document).ready(function($) {
		loadUserTable();

		$('.tdUserName').click(function() {
			$.get('/path/to server/', {
				id : $(this).data('emp_id')
			}, function(response) {
				/* do something with response be it html, xml or JSON response*/
			}, dataType)
		});

	});

	$(document).on(
			'change',
			'.btn-file :file',
			function() {
				var input = $(this), numFiles = input.get(0).files ? input
						.get(0).files.length : 1, label = input.val().replace(
						/\\/g, '/').replace(/.*\//, '');
				input.trigger('fileselect', [ numFiles, label ]);
			});

	$(document).ready(
			function() {
				$('.btn-file :file').on(
						'fileselect',
						function(event, numFiles, label) {

							var input = $(this).parents('.input-group').find(
									':text'), log = numFiles > 1 ? numFiles
									+ ' files selected' : label;

							if (input.length) {
								input.val(log);
							} else {
								if (log)
									alert(log);
							}

						});
			});

	function tableDym() {
		var table = $('#tableUsers').DataTable();

		$('#tableUsers tbody').on('click', 'tr', function() {
			if ($(this).hasClass('active')) {
				$(this).removeClass('active');				
			} else {
				table.$('tr.active').removeClass('active');
				$(this).addClass('active');
				var child = $(this);
				var userName = child.children('#tdUserName').text();

				$('#userInformation').html("");
				/*loadInformation(userName);
				console.log(userName);*/
			}

			/*loadInformation();*/

		});

	};

	/*Remove User*/
	function removeByAjax(userId) {

		var json = {
			"username" : $('#username').val(),
			"email" : $('#email').val(),
			"name" : $('#name').val(),
			"password" : $('#password').val()
		};
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}removeUserAjax",
			data : JSON.stringify(userId),
			mimeType : 'application/json',
			contentType : 'application/json',
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				loadUserTable();
				$("#sucessMsgDiv").addClass("in")
				$("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);
			},
			error : function(e) {
			},
			done : function(e) {

			}
		});

	}

	/* LIST USER */
	function loadUserTable() {

		var json = {
			"string" : 'a'
		};
		$
				.ajax({
					type : "POST",
					contentType : "application/json",
					url : "${home}findAllUsers",
					data : JSON.stringify(json),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						/*console.log("SUCCESS: ", data);
						display(data);*/
						var htmlrows = "<thead>	<tr><th>Username</th><th>Name</th><th>Email</th><th>Del</th></tr></thead><tbody>";

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
													+ user.email
													+ "</td>"
													+ "<td style='text-align: center'><a onclick=removeByAjax('"
													+ user.id
													+ "')  class='imageAnchor' href='#'><i class='glyphicon glyphicon-remove redColor'></i></td></tr>";

											htmlrows += htmlrow;

										})
						htmlrows += "</tbody>";

						$('#tableUsers').html(htmlrows);
						tableDym();

					},
					error : function(e) {
					},
					done : function(e) {
						tableDym();

					}
				});

	}
</script>