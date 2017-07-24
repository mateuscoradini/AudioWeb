<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layouts/taglib.jsp"%>

<style>

.redColor{

	color: red;

}

.blackColor{

	color: black;

}

.active>th {
	background-color: black;
}

.hide {
	display: nome;
}

.show {
	display: inherit;
}

.table>thead>tr>td.active, .table>tbody>tr>td.active, .table>tfoot>tr>td.active,
	.table>thead>tr>th.active, .table>tbody>tr>th.active, .table>tfoot>tr>th.active,
	.table>thead>tr.active>td, .table>tbody>tr.active>td, .table>tfoot>tr.active>td,
	.table>thead>tr.active>th, .table>tbody>tr.active>th, .table>tfoot>tr.active>th
	{
	background-color: black;
	color: #FFFFFF;
}

.clearfix {
	*zoom: 1;
}

.clearfix:before, .clearfix:after {
	display: table;
	content: "";
	line-height: 0;
}

.clearfix:after {
	clear: both;
}

.hide-text {
	font: 0/0 a;
	color: transparent;
	text-shadow: none;
	background-color: transparent;
	border: 0;
}

.input-block-level {
	display: block;
	width: 100%;
	min-height: 30px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.btn-file {
	overflow: hidden;
	position: relative;
	vertical-align: middle;
}

.btn-file>input {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	opacity: 0;
	filter: alpha(opacity = 0);
	transform: translate(-300px, 0) scale(4);
	font-size: 23px;
	direction: ltr;
	cursor: pointer;
}

.fileupload {
	margin-bottom: 9px;
}

.fileupload .uneditable-input {
	display: inline-block;
	margin-bottom: 0px;
	vertical-align: middle;
	cursor: text;
}

.fileupload .thumbnail {
	overflow: hidden;
	display: inline-block;
	margin-bottom: 5px;
	vertical-align: middle;
	text-align: center;
}

.fileupload .thumbnail>img {
	display: inline-block;
	vertical-align: middle;
	max-height: 100%;
}

.fileupload .btn {
	vertical-align: middle;
}

.fileupload-exists .fileupload-new, .fileupload-new .fileupload-exists {
	display: none;
}

.fileupload-inline .fileupload-controls {
	display: inline;
}

.fileupload-new .input-append .btn-file {
	-webkit-border-radius: 0 3px 3px 0;
	-moz-border-radius: 0 3px 3px 0;
	border-radius: 0 3px 3px 0;
}

.thumbnail-borderless .thumbnail {
	border: none;
	padding: 0;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border-radius: 0;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
}

.fileupload-new.thumbnail-borderless .thumbnail {
	border: 1px solid #ddd;
}

.control-group.warning .fileupload .uneditable-input {
	color: #a47e3c;
	border-color: #a47e3c;
}

.control-group.warning .fileupload .fileupload-preview {
	color: #a47e3c;
}

.control-group.warning .fileupload .thumbnail {
	border-color: #a47e3c;
}

.control-group.error .fileupload .uneditable-input {
	color: #b94a48;
	border-color: #b94a48;
}

.control-group.error .fileupload .fileupload-preview {
	color: #b94a48;
}

.control-group.error .fileupload .thumbnail {
	border-color: #b94a48;
}

.control-group.success .fileupload .uneditable-input {
	color: #468847;
	border-color: #468847;
}

.control-group.success .fileupload .fileupload-preview {
	color: #468847;
}

.control-group.success .fileupload .thumbnail {
	border-color: #468847;
}
</style>

<div class="col-lg-12">
	<div id="sucessMsgDiv" class="row" style="display: none">
		<c:if test="${param.success eq true}">
			<div class="alert alert-success">Successfull!</div>
		</c:if>
	</div>
	<h3 class="page-header">Register Projects's</h3>
	<!-- Page Heading -->
	<div class="row">
		<div class="col-sm-8">

			<form:form id="projectRegisterForm" commandName="project"
				method="post" class="form-horizontal">
				<div id="alert"></div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<form:input id="name" path="name" cssClass="form-control" />
						<form:errors path="name" />
					</div>
				</div>

				<div class="form-group">
					<label for="scope" class="col-sm-2 control-label">Scope</label>
					<div class="col-sm-10">
						<form:input id="scope" path="scope" cssClass="form-control" />
						<form:errors path="scope" />
					</div>
				</div>

				<center>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Create</button>
							<button type="reset" class="btn btn-primary">Clear</button>
						</div>
					</div>
				</center>

			</form:form>
		</div>

	</div>
	<div id="feedback"></div>
</div>


<div align="center" class="embed-responsive embed-responsive-16by9">

</div>

<h3 class="page-header">Project's</h3>
<!-- Page Heading -->
<div class="row">
	<div class="col-md-8">
		<form:form id="tableProjectsForm" commandName="user" method="post"
			class="form-horizontal">

			<div class="table-responsive">
				<table id="tableProjects"
					class="table table-bordered dataTable no-footer" cellspacing="0"
					width="100%" role="grid" aria-describedby="example_info"
					style="width: 100%;">
					<thead>
						<tr>
							<th>Project Name</th>
							<th>Scope</th>
						</tr>
					</thead>

					<tbody>
					</tbody>

				</table>
			</div>

		</form:form>

	</div>

	<div id="projectUploadDiv" class="col-md-4 hide">
		<h3 class="page-header">Upload Audio to Selected Project</h3>

		<form id="uploadAudioProjectForm" method="POST"
			enctype="multipart/form-data" action="/projects/audio/upload">
			<div class="fileupload fileupload-new" data-provides="fileupload">
				<span class="btn btn-primary btn-file">
				<span class="fileupload-new">Select file</span>
				<span class="fileupload-exists">Change</span>
				<input type="file" name="file" /></span>
				<input id="projectNameInputHidden" type="hidden" name="projectName" /></span>
				
				<span
					class="fileupload-preview"></span>
					<a href="#"	class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
				<input type="submit" class="btn btn-primary" value="Send">	
				
					
			</div>
		</form>
	</div>
</div>

<div id="audioByProjectDiv" class="hide">
<h3 class="page-header">Project Audio's</h3>
<!-- Page Heading -->
<div class="row">
	<div class="col-md-8" >
		<form:form id="tableAudioForm" commandName="user" method="post"
			class="form-horizontal">
			<div class="table-responsive">
				<table id="tableAudios"
					class="table table-bordered dataTable no-footer" cellspacing="0"
					width="100%" role="grid" aria-describedby="example_info"
					style="width: 100%;">
					<thead>
						<tr>
							<th>Audio FileName</th>							
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</form:form>

	</div>
	
</div>
</div>



<script type="text/javascript">
	/**
	 * Project Register JS
	 */

	$(document)
			.ready(
					function() {

						$(".projectRegisterForm")
								.validate(
										{
											highlight : function(element) {
												$(element).closest(
														'.form-group')
														.removeClass(
																'has-success')
														.addClass('has-error');
											},
											unhighlight : function(element) {
												$(element)
														.closest('.form-group')
														.removeClass(
																'has-error')
														.addClass('has-success');
											},
											messages : {
												name : {
													remote : "Such project name already exists!"
												}
											}
										});

						$("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);

						loadInformation();

					});

	function tableDym() {

		var table = $('#tableProjects').DataTable();

		$('#tableProjects tbody').on('click', 'tr', function() {
			if ($(this).hasClass('active')) {
				$(this).removeClass('active');
				$('#projectUploadDiv').removeClass('show');
				$('#audioByProjectDiv').addClass('show');
				console.log($(this));
			} else {
				$('#projectUploadDiv').addClass('show');
				$('#audioByProjectDiv').addClass('show');
				table.$('tr.active').removeClass('active');
				$(this).addClass('active');
				var child = $(this);
				var projectName = child.children('#projectNameId').text();
				$('#projectNameInputHidden').val(projectName);
				loadAudioInformation(projectName);
				
			}

		});

	};

	function loadInformation() {

		var json = {
			"string" : 'a'
		};
		$
				.ajax({
					type : "GET",
					contentType : "application/json",
					url : "${home}projectsDetailsInformation",
					data : JSON.stringify(json),
					mimeType : 'application/json',
					contentType : 'application/json',
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						/*display(data);*/
						var htmlrows = "<thead>	<tr><th>Project Name</th><th>Scope</th><th>Del</th></tr></thead><tbody>";

						$.each(data, function(key, project) {

							var htmlrow = "<td id='projectNameId'>"
									+ project.name + "</td>" + "<td> "
									+ project.scope + "</td>"
									+ "<td style='text-align: center'><a onclick=removeByAjax('"
									+ project.id
									+ "')  class='imageAnchor' href='#'><i class='glyphicon glyphicon-remove redColor'></i></td>"
									+ "</tr>";

							htmlrows += htmlrow;

						})
						htmlrows += "</tbody>";

						$('#tableProjects').html(htmlrows);
						tableDym();

					}
				});
	}
	
	function loadAudioInformation(projectName) {

		
		$.ajax({	
					type : "POST",
					contentType : "application/json",
					url : "${home}projectAudios",
					data : JSON.stringify(projectName),
					mimeType : 'application/json',
					contentType : 'application/json',
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						/*display(data);*/
						var htmlrows = "<thead>	<tr><th>Audio FileName</th><th>Del</th><th>Change Key</th></tr></thead><tbody>";

						$.each(data, function(key, audio) {

							var htmlrow = "<td id='audioId'>"
									+ audio.fileName
									
									+ "<td style='text-align: center'><a onclick=removeByAjax('"
									+ audio.id
									+ "')  class='imageAnchor' href='#'><i class='glyphicon glyphicon-remove redColor'></i></td>"	
									
									+ "<td style='text-align: center'><a onclick=changeAudioKeyByAjax('"
									+ audio.id
									+ "')  class='imageAnchor' href='#'><i class='glyphicon glyphicon-lock blackColor'></i></td>"	
									
									+ "</td>" + "</tr>"
									;

							htmlrows += htmlrow;

						})
						htmlrows += "</tbody>";
						$('#tableAudios').html(htmlrows);

					}
				});
	}
	
	/*Remove User*/
	function removeByAjax(projectId) {
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}removeProjectAjax",
			data : JSON.stringify(projectId),
			mimeType : 'application/json',
			contentType : 'application/json',
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				loadInformation();
				$("#sucessMsgDiv").addClass("in")
				$("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);
			},
			error : function(e) {
			},
			done : function(e) {

			}
		});

	}
	
	
	/*Remove User*/
	function changeAudioKeyByAjax(audioId) {
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}changeAudioKeyByAjax",
			data : JSON.stringify(audioId),
			mimeType : 'application/json',
			contentType : 'application/json',
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				loadInformation();
				$("#sucessMsgDiv").addClass("in")
				$("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);
			},
			error : function(e) {
			},
			done : function(e) {

			}
		});

	}
	
!function(e){var t=function(t,n){this.$element=e(t),this.type=this.$element.data("uploadtype")||(this.$element.find(".thumbnail").length>0?"image":"file"),this.$input=this.$element.find(":file");if(this.$input.length===0)return;this.name=this.$input.attr("name")||n.name,this.$hidden=this.$element.find('input[type=hidden][name="'+this.name+'"]'),this.$hidden.length===0&&(this.$hidden=e('<input type="hidden" />'),this.$element.prepend(this.$hidden)),this.$preview=this.$element.find(".fileupload-preview");var r=this.$preview.css("height");this.$preview.css("display")!="inline"&&r!="0px"&&r!="none"&&this.$preview.css("line-height",r),this.original={exists:this.$element.hasClass("fileupload-exists"),preview:this.$preview.html(),hiddenVal:this.$hidden.val()},this.$remove=this.$element.find('[data-dismiss="fileupload"]'),this.$element.find('[data-trigger="fileupload"]').on("click.fileupload",e.proxy(this.trigger,this)),this.listen()};t.prototype={listen:function(){this.$input.on("change.fileupload",e.proxy(this.change,this)),e(this.$input[0].form).on("reset.fileupload",e.proxy(this.reset,this)),this.$remove&&this.$remove.on("click.fileupload",e.proxy(this.clear,this))},change:function(e,t){if(t==="clear")return;var n=e.target.files!==undefined?e.target.files[0]:e.target.value?{name:e.target.value.replace(/^.+\\/,"")}:null;if(!n){this.clear();return}this.$hidden.val(""),this.$hidden.attr("name",""),this.$input.attr("name",this.name);if(this.type==="image"&&this.$preview.length>0&&(typeof n.type!="undefined"?n.type.match("image.*"):n.name.match(/\.(gif|png|jpe?g)$/i))&&typeof FileReader!="undefined"){var r=new FileReader,i=this.$preview,s=this.$element;r.onload=function(e){i.html('<img src="'+e.target.result+'" '+(i.css("max-height")!="none"?'style="max-height: '+i.css("max-height")+';"':"")+" />"),s.addClass("fileupload-exists").removeClass("fileupload-new")},r.readAsDataURL(n)}else this.$preview.text(n.name),this.$element.addClass("fileupload-exists").removeClass("fileupload-new")},clear:function(e){this.$hidden.val(""),this.$hidden.attr("name",this.name),this.$input.attr("name","");if(navigator.userAgent.match(/msie/i)){var t=this.$input.clone(!0);this.$input.after(t),this.$input.remove(),this.$input=t}else this.$input.val("");this.$preview.html(""),this.$element.addClass("fileupload-new").removeClass("fileupload-exists"),e&&(this.$input.trigger("change",["clear"]),e.preventDefault())},reset:function(e){this.clear(),this.$hidden.val(this.original.hiddenVal),this.$preview.html(this.original.preview),this.original.exists?this.$element.addClass("fileupload-exists").removeClass("fileupload-new"):this.$element.addClass("fileupload-new").removeClass("fileupload-exists")},trigger:function(e){this.$input.trigger("click"),e.preventDefault()}},e.fn.fileupload=function(n){return this.each(function(){var r=e(this),i=r.data("fileupload");i||r.data("fileupload",i=new t(this,n)),typeof n=="string"&&i[n]()})},e.fn.fileupload.Constructor=t,e(document).on("click.fileupload.data-api",'[data-provides="fileupload"]',function(t){var n=e(this);if(n.data("fileupload"))return;n.fileupload(n.data());var r=e(t.target).closest('[data-dismiss="fileupload"],[data-trigger="fileupload"]');r.length>0&&(r.trigger("click.fileupload"),t.preventDefault())})}(window.jQuery)
</script>