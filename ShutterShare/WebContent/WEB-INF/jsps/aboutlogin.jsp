<!DOCTYPE html>
<html>
    <head>
        <title>About ShutterShare</title>
        <meta name="viewport" content="width=device-width, intial-scale=1.0">
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
		<!-- this is the navigation bar up top -->
		<div class = "navbar navbar-default navbar-custom navbar-static-top">
			<div class ="container">
				<div class = "navbar-header">
					<img class = "navbar-brand" src="${pageContext.request.contextPath}/resources/images/greenlogo.png" alt="shuttersharelogo">
						<button id="navbutton" class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
						<span class = "icon-bar"></span>
						<span class = "icon-bar"></span>
						<span class = "icon-bar"></span>
					</button>
				</div>
				<div class = "collapse navbar-collapse navHeaderCollapse">
				<ul class = "nav navbar-nav navbar-right">
					<li><a href = "${pageContext.request.contextPath}/">Home</a></li>
					<li><a href = "${pageContext.request.contextPath}/abouthome">About</a></li>
				</ul>
			
				</div>
			</div>
		</div>
		<br />
		<!-- navigation bar ends-->
		<div class = "container">
			<div class="row">
				<div class = "col-lg-12">
                    <center>
                        <img id="aboutlogo" src="${pageContext.request.contextPath}/resources/images/orangeshuttericon.png"/>
                        <h4>Modernizing Memories</h4><br />
                        <div class="container" id="box">
                        <p id="aboutp">Shutter Share is a premium photo sharing application curated by friends and family.  Simply enter an event access code and begin live-uploading photos and videos to the event album. Shutter Share is a modern solution to an everyday problem. With our application your photos are saved in one safe place, so you can enjoy the event now and relive it all later.</p>
                        </div>
                        
                        <br/>
                        <br/>
                        
                        <a href="https://play.google.com/store/apps/details?id=com.application.shuttershare&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-AC-global-none-all-co-pr-py-PartBadges-Oct1515-1"><img alt="Get it on Google Play" src="http://developer.android.com/images/brand/en_generic_rgb_wo_60.png" /></a>
                    </center>
                </div>
            </div>
        </div>
                        

		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>