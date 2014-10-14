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
                <translations><key>BusStationInRangeWidget_title</key><text>Haltestellen</text></translations>
                <translations><key>BusStationPanel_calculating_departures</key><text>Berechne Abfahrtszeiten</text></translations>
                <translations><key>BusStationPanel_directions</key><text>Diese Haltestelle für die Routenberechnung nutzen</text></translations>
                <translations><key>BusStationPanel_next_dep_label</key><text>Nächste Abfahrten</text></translations>
                <translations><key>BusStationPanel_refresh_departures</key><text>Abfahrtszeiten aktualisieren</text></translations>
                <translations><key>BusStationPanel_use_as_end_routing</key><text>Zielpunkt</text></translations>
                <translations><key>BusStationPanel_use_as_start_routing</key><text>Startpunkt</text></translations>
                <translations><key>BusStations</key><text>Haltestellen</text></translations>
                <translations><key>BusStationSearchWidget_introtext</key><text>Bezeichnung der Haltestelle</text></translations>
                <translations><key>BusTrainPopup_show_details</key><text>Details</text></translations>
                <translations><key>MapParkingPopup_msg</key><text>Besetzte Parkplätze</text></translations>
                <translations><key>MapParkingPopup_refresh</key><text>Aktualisieren</text></translations>
                <translations><key>BusTripPanel_show_prev_stops</key><text>Vorherige Haltestellen anzeigen</text></translations>
                <translations><key>FavouriteBusStationListPanel_empty_favourite</key><text>Sie haben keine Favoriten ausgewählt. Herz anklicken, um Haltestellen zu den Favoriten hinzuzufügen.</text></translations>
                <translations><key>FavouriteBusStationListPanel_favourite_are</key><text>Ihre bevorzugten Haltestellen sind</text></translations>
                <translations><key>Menu_about</key><text>About</text></translations>
                <translations><key>Menu_areasLines</key><text>Linien</text></translations>
                <translations><key>Menu_feedback</key><text>Feedback</text></translations>
                <translations><key>Menu_favourites</key><text>Favoriten</text></translations>
                <translations><key>Menu_map</key><text>Karte</text></translations>
                <translations><key>Menu_more</key><text>Sonstiges</text></translations>
                <translations><key>Menu_news</key><text>Mitteilungen</text></translations>
                <!-- <translations><key>Menu_routing</key><text>Route ber.</text></translations> -->
                <translations><key>Menu_search</key><text>Suchen</text></translations>
                <translations><key>Menu_settings</key><text>Einstellg.</text></translations>
                <translations><key>Menu_train</key><text>Züge</text></translations>
                <translations><key>NewsPanel_loading</key><text>News werden gelesen</text></translations>
                <translations><key>ParkingsPanel_title</key><text>Parkplätze</text></translations>
                <translations><key>RouteResultDetailPanel_walk_for</key><text>Fußmarsch</text></translations>
                <translations><key>RouteResultDetailPanel_you_arrive</key><text>Sie sind am Ziel angekommen!</text></translations>
                <translations><key>RouteSearchPanel_calculating_routing</key><text>Route wird berechnet</text></translations>
                <translations><key>RouteSearchPanel_end_station</key><text>Ziel</text></translations>
                <translations><key>RouteSearchPanel_search</key><text>Berechnen</text></translations>
                <translations><key>RouteSearchPanel_start_station</key><text>Start</text></translations>
                <translations><key>RouteSearchPanel_title</key><text>Routenplanung</text></translations>
                <translations><key>RouteSearchPanel_when</key><text>Wann</text></translations>
                <translations><key>RouteResultOverviewPanel_transfers</key><text>Umstiege</text></translations>
                <translations><key>RouteResultOverviewPanel_duration</key><text>Dauer</text></translations>
                <translations><key>RouteSearchPanel_no_start_or_stop</key><text>Bitte Start- und Zielhaltestelle auswählen!</text></translations>                
                <translations><key>SASAbusDateBox_prevHour</key><text>Std früher</text></translations>
                <translations><key>SASAbusDateBox_nextHour</key><text>Std später</text></translations>
                <translations><key>TrainStationsPanel_title</key><text>Zughaltestellen</text></translations>
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
                <copyrightYears>2013-2014</copyrightYears>
                <copyrightCompany>TIS Innovation Park</copyrightCompany>
                <copyrightCompanyUrl>http://www.tis.bz.it/open</copyrightCompanyUrl>
                <copyrightCompanyAddress>Via Siemens 29 Strasse - Bolzano/Bozen - Italy</copyrightCompanyAddress>
                
                <licenseLabel>License</licenseLabel>
                <licenseName>Affero GPL</licenseName>
                <licenseUrl>http://www.gnu.org/licenses/agpl-3.0.html</licenseUrl>
             
                <infos>Wir zeichnen anonym die Benutzung dieser Applikation mit Google Analytics auf (Seitenansichten und Ereignisse)</infos>
                
                <teamName>SASAbus community</teamName>
                <teamUrl>http://sasabus.org/community</teamUrl>
                
                <teamMembers>
                  <name>Davide Montesin</name>
                  <url>http://www.davide.bz</url>
			      <role>Main developer</role>
                </teamMembers>
                <teamMembers>
                  <name>Giulia Rosso</name>
                  <url>#</url>
                  <role>Design</role>
                </teamMembers>
                <teamMembers>
                  <name>Iryna Dorosh</name>
                  <url>#</url>
                  <role>Design</role>
                </teamMembers>
                <teamMembers>
                  <name>Virginia Mazzocco</name>
                  <url>#</url>
                  <role>Design</role>
                </teamMembers>
                <teamMembers>
                  <name>Matthias Dieter Wallnöfer</name>
                  <url>#</url>
                  <role>QA</role>
                </teamMembers>
                
                <libraries>
                   <name>DM XML-JSON</name>
                   <url>http://www.davide.bz/en/dmxj</url>
                   <owner>Davide Montesin</owner>
                   <license>LGPL3</license>
                   <licenseUrl>http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License</licenseUrl>
                </libraries>
                
                <libraries>
                   <name>DM Web</name>
                   <url>http://www.davide.bz/en/dmweb</url>
                   <owner>Davide Montesin</owner>
                   <license>LGPL3</license>
                   <licenseUrl>http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License</licenseUrl>
                </libraries>
                
                <libraries>
                   <name>Flag Icons - Europe</name>
                   <url>http://antibakteriell.deviantart.com/art/Flag-Icons-Europe-166536006</url>
                   <owner>antibakteriell</owner>
                   <license>CC BY 3.0</license>
                   <licenseUrl>http://creativecommons.org/licenses/by/3.0/</licenseUrl>
                </libraries>
                
                <libraries>
                   <name>Visualization: Gauge</name>
                   <url>https://developers.google.com/chart/interactive/docs/gallery/gauge</url>
                   <owner>Google</owner>
                   <license>API</license>
                   <licenseUrl>https://developers.google.com/chart/terms</licenseUrl>
                </libraries>
                
                <libraries>
                   <name>GWT</name>
                   <url>http://www.gwtproject.org</url>
                   <owner>Google</owner>
                   <license>Apache 2.0</license>
                   <licenseUrl>http://www.gwtproject.org/terms.html</licenseUrl>
                </libraries>
                
                <libraries>
                   <name>Leaflet</name>
                   <url>http://leafletjs.com</url>
                   <owner>Vladimir Agafonkin, CloudMade</owner>
                   <license>BSD</license>
                   <licenseUrl>http://github.com/Leaflet/Leaflet/blob/master/LICENSE</licenseUrl>
                </libraries>
                
            </aboutInfos>
            <supportEmail>community@sasabus.org</supportEmail>
        </initParameters>
    </dmweb:fragment>

</dmweb:body>
</html>