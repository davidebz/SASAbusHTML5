<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/dmweb-fragment-taglib.tld" prefix="dmweb"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link type="text/css" rel="stylesheet" href="../main-structure-responsive.css">
<link type="text/css" rel="stylesheet" href="../SASAbusHTML5.css">

<link rel="stylesheet" href="../js/leaflet-0.6.4/leaflet.css" />
<!--[if lte IE 8]>
    <link rel="stylesheet" href="../js/leaflet-0.6.4/leaflet.ie.css" />
<![endif]-->

<link rel="stylesheet" href="../js/leaflet-0.6.4/leaflet.label.css" />

<script src="../js/leaflet-0.6.4/leaflet.js"></script>
<script src="../js/leaflet-0.6.4/leaflet.label.js"></script>

<!--                                           -->
<!-- This script loads your compiled module.   -->
<!-- If you add any GWT meta tags, they must   -->
<!-- be added before this line.                -->
<!--                                           -->
<script type="text/javascript" language="javascript" src="../sasabushtml5/sasabushtml5.nocache.js"></script>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-42332209-1']);
  _gaq.push(['_trackPageview']);
  _gaq.push(['_trackEvent', 'ua', 'hit', navigator.userAgent]);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>


<link href='http://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>

<script type='text/javascript' src='https://www.google.com/jsapi'></script>
    <script type='text/javascript'>
      google.load('visualization', '1', {packages:['gauge']});
</script>


</head>
<dmweb:body marshallerUnmarshallerPrefix="it.bz.tis.sasabus.html5.shared.SASAbus">
	
	<dmweb:fragment viewclass="it.bz.tis.sasabus.html5.shared.SASAbusWebPage">
		<initParameters> 
			
		</initParameters>
	</dmweb:fragment>

	<!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
	<noscript>
		<div
			style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">Your
			web browser must have JavaScript enabled in order for this
			application to display correctly.</div>
	</noscript>

	<!-- OPTIONAL: include this if you want history support -->
	<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
		style="position: absolute; width: 0; height: 0; border: 0"></iframe>

</dmweb:body>
</html>