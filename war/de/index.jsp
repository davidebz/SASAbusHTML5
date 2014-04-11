<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib uri="/WEB-INF/dmweb-fragment-taglib.tld" prefix="dmweb"
%><!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="gwt:property" content="locale=de">
<title>SASAbus HTML5: Busse/Buslinien der SASA, Fahrpläne und Routen in Bozen und Meran.</title>
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

<!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
<noscript>
   <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">Your web
      browser must have JavaScript enabled in order for this application to display correctly.</div>
</noscript>

<!-- OPTIONAL: include this if you want history support -->
<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position: absolute; width: 0; height: 0; border: 0"></iframe>

	
	<dmweb:fragment viewclass="it.bz.tis.sasabus.html5.shared.SASAbusWebPage">
		<initParameters>
		<appTitle>SASAbus</appTitle>
		<custom.BusStationCustomViewAndI18N>
			<busRoutingViewFactory.SASABzRoutingViewFactory/>
			<i18n>
				<language>de</language>
				<translations><key>AboutPanel_checkingUpdates</key><text>Suche nach Updates ...</text></translations>
				<translations><key>AboutPanel_downloadingUpdates</key><text>Lade Updates ...</text></translations>
				<translations><key>AboutPanel_readingLocalstore</key><text>Lokale Datenbank wird geladen ...</text></translations>
				<translations><key>AboutPanel_ready</key><text>Startbereit!</text></translations>
				<translations><key>AboutPanel_writingLocalstore</key><text>Wird in lokaler Datenbank gespeichert ...</text></translations>
				<translations><key>BusLine</key><text>Linie</text></translations>
				<translations><key>BusLines</key><text>Linien</text></translations>
				<translations><key>BusStationPanel_calculating_departures</key><text>Berechne Abfahrtszeiten</text></translations>
				<translations><key>BusStationPanel_directions</key><text>Diese Haltestelle für die Routenberechnung nutzen</text></translations>
				<translations><key>BusStationPanel_refresh_departures</key><text>Abfahrtszeiten aktualisieren</text></translations>
				<translations><key>BusStationPanel_use_as_end_routing</key><text>Zielpunkt</text></translations>
				<translations><key>BusStationPanel_use_as_start_routing</key><text>Startpunkt</text></translations>
				<translations><key>BusStations</key><text>Haltestellen</text></translations>
				<translations><key>BusStationSearchWidget_introtext</key><text>Bezeichnung der Haltestelle</text></translations>
				<translations><key>BusTripPanel_show_prev_stops</key><text>Vorherige Haltestellen anzeigen</text></translations>
				<translations><key>FavouriteBusStationListPanel_empty_favourite</key><text>Sie haben keine Favoriten ausgewählt. Herz anklicken, um Haltestellen zu den Favoriten hinzuzufügen.</text></translations>
				<translations><key>FavouriteBusStationListPanel_favourite_are</key><text>Ihre bevorzugten Haltestellen sind</text></translations>
				<translations><key>Menu_about</key><text>About</text></translations>
				<translations><key>Menu_areasLines</key><text>Linien</text></translations>
				<translations><key>Menu_feedback</key><text>Feedback</text></translations>
				<translations><key>Menu_map</key><text>Karte</text></translations>
				<translations><key>Menu_more</key><text>Sonstiges</text></translations>
				<translations><key>Menu_news</key><text>Mitteilungen</text></translations>
				<translations><key>Menu_routing</key><text>Route ber.</text></translations>
				<translations><key>Menu_search</key><text>Suchen</text></translations>
				<translations><key>Menu_settings</key><text>Einstellg.</text></translations>
				<translations><key>NewsPanel_loading</key><text>News werden gelesen</text></translations>
				<translations><key>RouteResultDetailPanel_walk_for</key><text>Fußmarsch</text></translations>
				<translations><key>RouteResultDetailPanel_you_arrive</key><text>Sie sind am Ziel angekommen!</text></translations>
				<translations><key>RouteSearchPanel_calculating_routing</key><text>Route wird berechnet</text></translations>
				<translations><key>RouteSearchPanel_end_station</key><text>Ziel</text></translations>
				<translations><key>RouteSearchPanel_search</key><text>Berechnen</text></translations>
				<translations><key>RouteSearchPanel_start_station</key><text>Start</text></translations>
				<translations><key>RouteSearchPanel_when</key><text>Wann</text></translations>
				
				</i18n>
			</custom.BusStationCustomViewAndI18N>
			<homePageCustomFragment.HomePageCustomIntroText>
			<introText>Liebe Betatester, willkommen bei SASAbus HTML5. Mit dieser App können Sie
      Informationen zu allen Diensten der SASA abrufen: Buslinien, Haltestellen, Fahrpläne
      und Routenplanung in den Einzugsgebieten Meran und Bozen. Falls Sie die Anwendung
      auf einem Gerät mit kleinem Bildschirm verwenden, können Sie das Menü mit einem
      Klick auf das Ikon links oben öffnen. Ihre Meinung ist wichtig – teilen Sie uns über den
      Menüpunkt „Feedback“ Ihre Bewertung der App mit! Viel Spaß!</introText>
      		</homePageCustomFragment.HomePageCustomIntroText>
      		<aboutInfos>
			    <copyrightYears>2013</copyrightYears>
			    <copyrightCompany>TIS Innovation Park</copyrightCompany>
			    <copyrightCompanyUrl>http://www.tis.bz.it/open</copyrightCompanyUrl>
			    <copyrightCompanyAddress>Via Siemens 29 Strasse - Bolzano/Bozen - Italy</copyrightCompanyAddress>
			    
			    <licenseLabel>License</licenseLabel>
			    <licenseName>Affero GPL</licenseName>
			    <licenseUrl>http://www.gnu.org/licenses/agpl-3.0.html</licenseUrl>
			</aboutInfos>
			<supportEmail>community@sasabus.org</supportEmail>
		</initParameters>
	</dmweb:fragment>

</dmweb:body>
</html>