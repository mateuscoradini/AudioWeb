<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layouts/taglib.jsp"%>

<!-- <script src="<c:url value="/resources/js/media.js" />"></script> 
<script
	src="<c:url value="/resources/js/thirdparty/modernizr.custom.js" />"></script>
<script src="<c:url value="/resources/js/thirdparty/js.cookie.js" />"></script>

<link href="<c:url value="/resources/css/ableplayer.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/ableplayer-playlist.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/thirdparty/ableplayer.js" />"></script>-->




<style>
.rightA {
	float: right;
}

.green {
	color: green;
}

.blueColor{

	color: #2B60DE;
}
/* Font Family
================================================== */

@import url("//fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200,300,400");

/* Desktop
================================================== */

.container {
    position: relative;
    margin: 0 auto;
    width: 700px;
}

.column {
    width: inherit;
}


/* CSS Reset
================================================== */

audio {
    border: 0;
    font: inherit;
    font-size: 100%;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
    color: #FFFFFF;
}

ul {
    list-style: none;
}


/* Basic Styles
================================================== */



/* Typography
================================================== */

h1,
h6,
p {
    color: #808080;
    font-weight: 200;
}

h1 {
    font-size: 42px;
    line-height: 44px;
    margin: 20px 0 0;
}

h6 {
    font-size: 18px;
    line-height: 20px;
    margin: 4px 0 20px;
}

p {
    font-size: 18px;
    line-height: 20px;
    margin: 0 0 2px;
}


/* Links
================================================== */

a,
a:visited {
    color: #ddd;
    outline: 0;
    text-decoration: underline;
}

a:hover,
a:focus {
    color: #bbb;
}

p a,
p a:visited {
    line-height: inherit;
}


/* Misc.
================================================== */

.add-bottom {
    margin-bottom: 20px !important;
}

.left {
    float: left;
}

.right {
    float: right;
}

.center {
    text-align: center;
}


/* Custom Styles
================================================== */


/* CSS Transitions */

* {
    -moz-transition: all 100ms ease;
    -o-transition: all 100ms ease;
    -webkit-transition: all 100ms ease;
    transition: all 100ms ease;
}


/* Highlight Styles */

::selection {
    background-color: #262223;
    color: #444;
}

::-moz-selection {
    background-color: #262223;
    color: #444;
}


/* Audio Player Styles
================================================== */


/* Default / Desktop / Firefox */

audio {
    margin: 0 15px 0 14px;
    width: 670px;
}

#mainwrap {
    /* add box-shadow or other styles here */
}

#audiowrap {
    background-color: #231F20;
    margin: 0 auto;
}

#plwrap {
    margin: 0 auto;
    color: white;
}

#tracks {
    min-height: 65px;
    position: relative;
    text-align: center;
    text-decoration: none;
    top: 13px;
}

#nowPlay {
    display: inline;
    color: white;
}

#npTitle {
    margin: 0;
    padding: 21px;
    text-align: right;
}

#npAction {
    padding: 21px;
    position: absolute;
}

#plList {
    margin: 0;
}

#plList li {
    background-color: #231F20;
    cursor: pointer;
    margin: 0;
    padding: 21px 0;
}

#plList li:hover {
    background-color: #262223;
}

.plItem {
    position: relative;
}

.plTitle {
    left: 50px;
    overflow: hidden;
    position: absolute;
    right: 65px;
    text-overflow: ellipsis;
    top: 0;
    white-space: nowrap;
}

.plNum {
    padding-left: 21px;
    width: 25px;
}

.plLength {
    padding-left: 21px;
    position: absolute;
    right: 21px;
    top: 0;
}

.plSel,
.plSel:hover {
    background-color: #262223!important;
    cursor: default!important;
}

a[id^="btn"] {
    background-color: #231F20;
    color: #C8C7C8;
    cursor: pointer;
    font-size: 50px;
    margin: 0;
    padding: 0 27px 11px;
    text-decoration: none;
}

a[id^="btn"]:last-child {
    margin-left: -4px;
}

a[id^="btn"]:hover,
a[id^="btn"]:active {
    background-color: #262223;
}

a[id^="btn"]::-moz-focus-inner {
    border: 0;
    padding: 0;
}


/* IE 9 */

html[data-useragent*="MSIE 9.0"] audio {
    margin-left: 9px;
    outline: none;
    width: 680px;
}

html[data-useragent*="MSIE 9.0"] #audiowrap {
    background-color: #000;
}

html[data-useragent*="MSIE 9.0"] #tracks {
    min-height: 57px;
    top: 5px;
}

html[data-useragent*="MSIE 9.0"] a[id^="btn"] {
    background-color: #000;
}

html[data-useragent*="MSIE 9.0"] a[id^="btn"]:hover {
    background-color: #080808;
}

html[data-useragent*="MSIE 9.0"] #plList li {
    background-color: #000;
}

html[data-useragent*="MSIE 9.0"] #plList li:hover {
    background-color: #080808;
}

html[data-useragent*="MSIE 9.0"] .plSel,
html[data-useragent*="MSIE 9.0"] .plSel:hover {
    background-color: #080808!important;
}


/* IE 10 */

html[data-useragent*="MSIE 10.0"] audio {
    margin-left: 6px;
    width: 687px;
}

html[data-useragent*="MSIE 10.0"] #audiowrap {
    background-color: #000;
}

html[data-useragent*="MSIE 10.0"] #tracks {
    min-height: 60px;
    top: 8px;
}

html[data-useragent*="MSIE 10.0"] a[id^="btn"] {
    background-color: #000;
}

html[data-useragent*="MSIE 10.0"] a[id^="btn"]:hover {
    background-color: #080808;
}

html[data-useragent*="MSIE 10.0"] #plList li {
    background-color: #000;
}

html[data-useragent*="MSIE 10.0"] #plList li:hover {
    background-color: #080808;
}

html[data-useragent*="MSIE 10.0"] .plSel,
html[data-useragent*="MSIE 10.0"] .plSel:hover {
    background-color: #080808!important;
}


/* IE 11 */

html[data-useragent*="rv:11.0"] audio {
    margin-left: 2px;
    width: 695px;
}

html[data-useragent*="rv:11.0"] #audiowrap {
    background-color: #000;
}

html[data-useragent*="rv:11.0"] #tracks {
    min-height: 60px;
    top: 8px;
}

html[data-useragent*="rv:11.0"] a[id^="btn"] {
    background-color: #000;
}

html[data-useragent*="rv:11.0"] a[id^="btn"]:hover {
    background-color: #080808;
}

html[data-useragent*="rv:11.0"] #plList li {
    background-color: #000;
}

html[data-useragent*="rv:11.0"] #plList li:hover {
    background-color: #080808;
}

html[data-useragent*="rv:11.0"] .plSel,
html[data-useragent*="rv:11.0"] .plSel:hover {
    background-color: #080808!important;
}


/* All Apple Products */

html[data-useragent*="Apple"] audio {
    margin: 0;
    width: 100%;
}

html[data-useragent*="Apple"] #audiowrap {
    background-color: #000;
}

html[data-useragent*="Apple"] #tracks {
    min-height: 64px;
    top: 12px;
}

html[data-useragent*="Apple"] a[id^="btn"] {
    background-color: #000;
}

html[data-useragent*="Apple"] a[id^="btn"]:hover {
    background-color: #080808;
}

html[data-useragent*="Apple"] #plList li {
    background-color: #000;
}

html[data-useragent*="Apple"] #plList li:hover {
    background-color: #080808;
}

html[data-useragent*="Apple"] .plSel,
html[data-useragent*="Apple"] .plSel:hover {
    background-color: #080808!important;
}


/* IOS 7 */

html[data-useragent*="OS 7"] body {
    color: #373837;
}

html[data-useragent*="OS 7"] audio {
    margin-left: 3px;
    width: 690px;
}

html[data-useragent*="OS 7"] #audiowrap {
    background-color: #e6e6e6;
}

html[data-useragent*="OS 7"] #tracks {
    min-height: 75px;
    top: 23px;
}

html[data-useragent*="OS 7"] a[id^="btn"] {
    background-color: #e6e6e6;
    color: #373837;
}

html[data-useragent*="OS 7"] a[id^="btn"]:hover {
    background-color: #eee;
}

html[data-useragent*="OS 7"] #plList li {
    background-color: #e6e6e6;
}

html[data-useragent*="OS 7"] #plList li:hover {
    background-color: #eee;
}

html[data-useragent*="OS 7"] .plSel,
html[data-useragent*="OS 7"] .plSel:hover {
    background-color: #eee!important;
}


/* IOS 8 */

html[data-useragent*="OS 8"] body {
    color: #373837;
}

html[data-useragent*="OS 8"] audio {
    margin-left: 6px;
    width: 694px;
}

html[data-useragent*="OS 8"] #audiowrap {
    background-color: #e4e4e4;
}

html[data-useragent*="OS 8"] #tracks {
    min-height: 75px;
    top: 23px;
}

html[data-useragent*="OS 8"] a[id^="btn"] {
    background-color: #e4e4e4;
    color: #373837;
}

html[data-useragent*="OS 8"] a[id^="btn"]:hover {
    background-color: #eee;
}

html[data-useragent*="OS 8"] #plList li {
    background-color: #e4e4e4;
}

html[data-useragent*="OS 8"] #plList li:hover {
    background-color: #eee;
}

html[data-useragent*="OS 8"] .plSel,
html[data-useragent*="OS 8"] .plSel:hover {
    background-color: #eee!important;
}


/* IOS 9 */

html[data-useragent*="OS 9"] body {
    color: #373837;
}

html[data-useragent*="OS 9"] audio {
    margin-left: 6px;
    width: 694px;
}

html[data-useragent*="OS 9"] #audiowrap {
    background-color: #d5d5d5;
}

html[data-useragent*="OS 9"] #tracks {
    min-height: 75px;
    top: 23px;
}

html[data-useragent*="OS 9"] a[id^="btn"] {
    background-color: #d5d5d5;
    color: #373837;
}

html[data-useragent*="OS 9"] a[id^="btn"]:hover {
    background-color: #eee;
}

html[data-useragent*="OS 9"] #plList li {
    background-color: #d5d5d5;
}

html[data-useragent*="OS 9"] #plList li:hover {
    background-color: #eee;
}

html[data-useragent*="OS 9"] .plSel,
html[data-useragent*="OS 9"] .plSel:hover {
    background-color: #eee!important;
}


/* Chrome */

html[data-useragent*="Chrome"] audio {
    margin-left: 6px;
    width: 687px;
}

html[data-useragent*="Chrome"] #audiowrap {
    background-color: #141414;
}

html[data-useragent*="Chrome"] #tracks {
    min-height: 64px;
    top: 12px;
}

html[data-useragent*="Chrome"] a[id^="btn"] {
    background-color: #141414;
}

html[data-useragent*="Chrome"] a[id^="btn"]:hover {
    background-color: #171717;
}

html[data-useragent*="Chrome"] #plList li {
    background-color: #141414;
}

html[data-useragent*="Chrome"] #plList li:hover {
    background-color: #171717;
}

html[data-useragent*="Chrome"] .plSel,
html[data-useragent*="Chrome"] .plSel:hover {
    background-color: #171717!important;
}




</style>

<div class="col-lg-12">
	<div id="sucessMsgDiv" class="alert alert-success fade"
		style="display: none">
		<strong>Success!</strong>
	</div>
	<h3 class="page-header">All Project's Audio's</h3>
	<!-- Page Heading -->
	<div class="row">
		<div class="col-sm-6">
			<form:form id="projectAudiosForm" commandName="user" method="post"
				class="form-horizontal">
				<div class="list-group">
					<div id="plwrap1">
						<ul id="plList1">
						</ul>
					</div>
				</div>
			</form:form>
		</div>

		<div class="col-sm-6">
			<div class="container">
				<div class="column center panel panel-primary">
					<h1 class="blueColor" >User Audio Player</h1>
				</div>
				<div class="column add-bottom">
					<div id="mainwrap">
						<div id="nowPlay">
							<span class="left" id="npAction">Paused...</span> <span
								class="right" id="npTitle"></span>
						</div>
						<div id="audiowrap">
							<div id="audio0">
								<audio preload id="audio1" controls="controls">Your
									browser does not support HTML5 Audio!
								</audio>
							</div>
							<div id="tracks">
								<a id="btnPrev">&laquo;</a> <a id="btnNext">&raquo;</a>
							</div>
						</div>
						<div id="plwrap">
							<ul id="plList">
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

</div>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		loadProjectAudioList();
		loadUserPrivateAudioList();

	});

	/*Remove User*/
	function requestAcess(audioId) {
		var json = {
			"username" : 'a'
		};
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}audioUser/requestPermission",
			data : JSON.stringify(audioId),
			mimeType : 'application/json',
			contentType : 'application/json',
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				$("#sucessMsgDiv").addClass("in")
				$("#sucessMsgDiv").slideDown(300).delay(2500).slideUp(400);
			}

		});

	}

	/* LIST Projects/Audios */
	function loadProjectAudioList() {

		var json = {
			"string" : 'a'
		};
		$
				.ajax({
					type : "POST",
					contentType : "application/json",
					url : "${home}audioUser/findAllProjectAudios",
					data : JSON.stringify(json),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						/*display(data);*/
						var htmlrows = "";

						$
								.each(
										data,
										function(key, projectAudioList) {
											var htmlrow = "<h1>"
													+ projectAudioList.name
													+ "</h1>";
											$
													.each(
															projectAudioList.listAudio,
															function(key, audio) {

																htmlrow += "<li class='list-group-item' id='audioFileName'>"
																		+ " <div class='plTilotle'>"
																		+ audio.fileName;
																		
																		if(!audio.userHasPermission){
																			htmlrow += " <a onclick=requestAcess('"
																			+ audio.id
																			+ "')  class='imageAnchor rightA' href='#'><i class='glyphicon glyphicon-open green'></i></a>";
																			
																		}
																		
																		htmlrow += "</div>"
																		+ "</li>";

															});

											htmlrows += htmlrow;

										});
						htmlrows += "";

						$('#plList1').html(htmlrows);

					}
				});
	}

	/* LIST Projects/Audios */
	function loadUserPrivateAudioList() {
		var media = null;
		var json = {
			"string" : 'a'
		};
		$
				.ajax({
					type : "POST",
					contentType : "application/json",
					url : "${home}audioUser/findUserPrivateAudios",
					data : JSON.stringify(json),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						/*display(data);*/
						var htmlrows = "<ul id='plList'>";
						htmlrows += "<li>&nbsp;&nbsp;&nbsp;&nbsp; <i class='glyphicon glyphicon-folder-open blueColor'></i>&nbsp;&nbsp;&nbsp;&nbsp; User Playlist </li></br>";
						
						var projectName = "";
						$.each(data, function(key, track) {
							
							if(track.projectName != projectName){
								projectName = track.projectName;
								
								htmlrows += "<p style='background-color: #141414'>"+projectName+" </p>";
								
							}
							
							htmlrows += "<li> <div class='plItem'>"
							+ "<div class='plNum'>"+track.track+"</div>"
							+ "<div class='plTitle'>"+track.name+"</div>"
							/*+ "<div class='plLength'>"+track.length+"</div>"*/
							+"</div>"
							+"</li>";
											

						});
						htmlrows += "</ul>";

						$('#plwrap').html(htmlrows);
						startMedia(data);

					}
				});
	};
	
	
	
	
	// Add user agent as an attribute on the <html> tag...
	// Inspiration: http://css-tricks.com/ie-10-specific-styles/
	var b = document.documentElement;
	b.setAttribute('data-useragent', navigator.userAgent);
	b.setAttribute('data-platform', navigator.platform);


	// HTML5 audio player + playlist controls...
	// Inspiration: http://jonhall.info/how_to/create_a_playlist_for_html5_audio
	// Mythium Archive: https://archive.org/details/mythium/
	function startMedia(mediaTracks) {
	    var supportsAudio = !!document.createElement('audio').canPlayType;
	    if (supportsAudio) {
	        var index = 0,
	            playing = false,
	            mediaPath = '',
	            extension = '',
	            tracks = mediaTracks,            
	            trackCount = tracks.length,
	            npAction = $('#npAction'),
	            npTitle = $('#npTitle'),
	            audio = $('#audio1').bind('play', function () {
	                playing = true;
	                npAction.text('Now Playing...');
	            }).bind('pause', function () {
	                playing = false;
	                npAction.text('Paused...');
	            }).bind('ended', function () {
	                npAction.text('Paused...');
	                if ((index + 1) < trackCount) {
	                    index++;
	                    loadTrack(index);
	                    audio.play();
	                } else {
	                    audio.pause();
	                    index = 0;
	                    loadTrack(index);
	                }
	            }).get(0),
	            btnPrev = $('#btnPrev').click(function () {
	                if ((index - 1) > -1) {
	                    index--;
	                    loadTrack(index);
	                    if (playing) {
	                        audio.play();
	                    }
	                } else {
	                    audio.pause();
	                    index = 0;
	                    loadTrack(index);
	                }
	            }),
	            btnNext = $('#btnNext').click(function () {
	                if ((index + 1) < trackCount) {
	                    index++;
	                    loadTrack(index);
	                    if (playing) {
	                        audio.play();
	                    }
	                } else {
	                    audio.pause();
	                    index = 0;
	                    loadTrack(index);
	                }
	            }),
	            li = $('#plList li').click(function () {
	               /* var id = parseInt($(this).index());*/
	               var id = parseInt($(this).children().children().first().text()) - 1;
	                if (id !== index) {
	                    playTrack(id);
	                }
	            }),
	            
	            loadTrack = function (id) {
	                $('.plSel').removeClass('plSel');
	                $('#plList li:eq(' + id + ')').addClass('plSel');
	                npTitle.text(tracks[id].name);
	                index = id;
	                audio.src = "/recfile/"+tracks[id].audioId;
	            },
	            playTrack = function (id) {
	                loadTrack(id);
	                audio.play();
	            };
	            
	        extension = audio.canPlayType('audio/mpeg') ? '.mp3' : audio.canPlayType('audio/ogg') ? '.ogg' : '';
	        loadTrack(index);
	    }
	};
</script>