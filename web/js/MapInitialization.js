var mapsLib = mapsLibs || {};
var markerArray = [];
var directionsRenderer;
var stepDisplay;
var road = [];
var marker = [];
var traf = [];
var mapsLibs = {
    center: new google.maps.LatLng(33.887188, 35.513402),
    defaultZoom: 13,
    mapTypeId: google.maps.MapTypeId.ROADMAP
};
var mapOptions = {
    center: mapsLibs.center,
    zoom: mapsLibs.defaultZoom,
    mapTypeId: mapsLibs.mapTypeId
};
var rendererOptions = {
    draggable: true,
    suppressMarkers: true
};
var a;
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
    stepDisplay = new google.maps.InfoWindow();

    map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
    directionsDisplay.setPanel(document.getElementById('directions-panel'));
    google.maps.event.addListener(directionsDisplay, 'directions_changed', function() {
        computeJams(directionsDisplay.getDirections(), window.traf);
    });

    stepDisplay = new google.maps.InfoWindow();
    var styles = [{featureType: "road.highway", stylers: [{color: "#b7b7b7"}]}];
    map.setOptions({styles: styles});
    var control = document.getElementById('control');
    control.style.display = 'block';
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(control);
    DrawPolyline(window.traf);
    showStreetinfo(window.traf);
}

function DrawPolyline(traf) {
    window.traf = [];
    window.traf = traf;
    road.length = 0;
    marker.lenght = 0;
    var polyline = [];
    var image;
    var title;
    var HW = 4;
    var arr1;
    for (var j = 0; j < window.traf.length; j++) {
        arr1 = window.traf[j].location.split(',');
        for (var i = 0; i < arr1.length; i += 2) {
            polyline.push(new google.maps.LatLng(parseFloat(arr1[i]),parseFloat(arr1[i + 1])));
            var col;
            if (window.traf[j].speed === 30) {
                col = '#FFC000';
                image = 'image/SlowTraffic.png';
                title = window.traf[j].name;
            } else //yellow
            if (window.traf[j].speed === 20) {
                col = '#FF4000';
                image = 'image/queuingTraffic.png';
                title = window.traf[j].name ;
            } else //orange
            if (window.traf[j].speed === 10) {
                col = '#B30000';
                image = 'image/stationarytraffic.png';
                title = window.traf[j].name;
            }// red 

            road.push(new google.maps.Polyline({
                path: polyline,
                geodesic: true,
                strokeColor: col,
                strokeOpacity: 0.6,
                strokeWeight: HW,
                map: map
            }));
            marker.push(new google.maps.Marker({
                position: polyline[0],
                map: map,
                icon: image,
                title: title
            }));
        }
        polyline = [];
    }
    showStreetinfo(window.traf);
}
function reset() {
    traf = [];
    for (var i = 0; i < road.length; i++) {
        road[i].setMap(null);
    }
        for (var j = 0; j < marker.length; j++) {
        marker[j].setMap(null);
    }
}
function showStreetinfo(traf) {
    streetInfo(traf);
}


function streetInfo(traf) {
    var drr = [];
    var jamsPathPolyline = [];
    var jamsLong = 0;
    var img;
    var loc;
    var jamsInfo = document.getElementById('route-info');
    jamsInfo.innerHTML = "";
    var location = [];
    if (traf.lenght === 0) {
        jamsInfo.innerHTML += "<div><p style='color:#3f3f3f;font-size: 14px'>No Jams</p></div>";
    }
    for (var b in traf) {
        if (traf[b].sets === 'morning') {
            location.push(traf[b].location);
        }
    }

    for (var i in location) {
        jamsPathPolyline = [];
        drr = location[i].split(',');
        for (var p = 0; p < drr.length; p += 2) {
            jamsPathPolyline.push(new google.maps.LatLng(parseFloat(drr[p]), parseFloat(drr[p + 1])));
        }
        loc = drr[0] + ',' + drr[1];
        jamsLong = google.maps.geometry.spherical.computeLength(jamsPathPolyline);
        jamsLong = Math.round(jamsLong / 1000 * 100) / 100;

        if (traf[i].speed === 10) {
            img = 'image/stationarytraffic.png';
        } else if (traf[i].speed === 20) {
            img = "image/queuingTraffic.png";
        } else
            img = "image/SlowTraffic.png";
        jamsInfo.innerHTML += "<a href='javascript:focusOnMarker(" + '"' + loc + '"' + ");' style='text-decoration:none'><div style='float: left'><img src='" + img + "'/></div><div><p style='color:#3f3f3f;font-size: 14px'>" + traf[i].name + " <b>" + traf[i].type + "</b> " + jamsLong + " km " + Math.round(jamsLong * traf[i].speed) + " min delay</p></div></a><hr/>";
    }
}
//route calculation
function calcRoute() {
    document.getElementById("suggested-route").style.display = "block";
    document.getElementById("tab2").style.display = "block";
    document.getElementById("tab1").style.display = "none";
    document.getElementById("tab3").style.display = "none";
    document.getElementById("tab4").style.display = "none";
    document.getElementById("Incident").style.background = "#B0B0B0";
    document.getElementById("suggested-route").style.background = "#D6D6D6";
    document.getElementById('route-info').style.visibility = 'hidden';
    document.getElementById("routing").style.visibility = 'visible';
    document.getElementById("routing").style.position = 'static';
    document.getElementById("show-step").style.position = 'static';
    for (var i = 0; i < markerArray.length; i++) {
        markerArray[i].setMap(null);
    }
    markerArray = [];
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    var request = {
        origin: start,
        destination: end,
        travelMode: google.maps.TravelMode.DRIVING,
        provideRouteAlternatives: true,
        optimizeWaypoints: true,
        durationInTraffic: true
    };
    console.log(request);
    directionsService.route(request, function(response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
            console.log(status);   
            console.log(response.routes[0].legs[0]);
            directionsDisplay.setDirections(response);
            console.log(status); 
            directionsDisplay.setMap(map);
            showSteps(response);
        }
    });
}

function ClearRoute() {
    directionsDisplay.setMap(null);
    for (var i = 0; i < markerArray.length; i++) {
        markerArray[i].setMap(null);
    }
    document.getElementById('routing').style.visibility = 'hidden';
    document.getElementById('route-info').style.visibility = 'visible';
    document.getElementById('route-info').style.position = 'static';
    document.getElementById("routing").style.position = 'absolute';
}
function CalReverseRoute() {
    hideStep();
    var request;
    var count = 1;
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    
    for (var i = 0; i < markerArray.length; i++) {
        markerArray[i].setMap(null);
    }
    

    request = {
        origin: end,
        destination: start,
        travelMode: google.maps.TravelMode.DRIVING,
        provideRouteAlternatives: true,
        optimizeWaypoints: true,
        durationInTraffic: true
    };

    directionsService.route(request, function(response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
            directionsDisplay.setMap(map);
            showSteps(response);
        }
    });
    count++;
    request = null;
}
function showSteps(directionResult) {
    console.log(directionResult.toString());
    var myRoute = directionResult.routes[0].legs[0];
    var marker = new google.maps.Marker({
        position: myRoute.steps[0].start_point,
        map: map,
        icon: "https://chart.googleapis.com/chart?chst=d_map_xpin_icon&chld=pin_star|car-dealer|00FFFF|FF0000"
    });
    markerArray.push(marker);
    var marker = new google.maps.Marker({
        position: myRoute.steps[myRoute.steps.length - 1].end_point,
        map: map,
        icon: "https://chart.googleapis.com/chart?chst=d_map_pin_icon&chld=flag|ADDE63"
    });
    markerArray.push(marker);
    google.maps.event.trigger(markerArray[0], "click");
}

function computeJams(result, traf) {
    var totalDistance = 0;
    var totalTime = 0;
    var myroute;
    for (var v = 0; v < result.routes.length; v++) {
        var routeJams = v + 1;
        myroute = result.routes[v];
        totalDistance = 0;
        totalTime = 0;
        for (var i = 0; i < myroute.legs.length; i++) {
            totalDistance += myroute.legs[i].distance.value;
            totalTime += myroute.legs[i].duration.value;
        }
        totalDistance = totalDistance / 1000.0;
        totalTime = (totalTime / 60).toFixed(2);
    }
    var MyRoute;
    var jamsPath = [];
    var path = [];
    var a;
    var namee = [];

    var pathToString;
    var jamsTime = 0;
    var jamsTime = 0;
    var jamsPathPolyline = [];
    var jamsLong = 0;
    var jamsArrDuration = [];
    var jamsArrTotalDuration=[];
    var distanceOfJamsArr = [];
    var distanceOfJams = 0;
    var dist = [];
    var routess;
    var time;
    var tb;
    for (var f = 0; f < result.routes.length; f++) {
        jamsTime = 0;
        MyRoute = result.routes[f].legs[0];
        path = [];
        for (var i = 0; i < MyRoute.steps.length; i++) {
            path.push(MyRoute.steps[i].start_location);
        }
        jamsPath = [];
        a = path.join();//convert the array to string
        for (var b = 0; b < a.length; b++) {
            a = a.replace('(', '');
            a = a.replace(')', '');
            a = a.replace(' ', '');
        }
        jamsTime = 0;
        pathToString = a.split(',');
        jamsPathPolyline = [];
        jamsLong = 0;
        for (var l = 0; l < traf.length; l++) {
            tb = traf[l].location.split(',');
            for (var o = 0; o < jamsPath.length; o += 2) {
                distanceOfJamsArr.push(new google.maps.LatLng(parseFloat(tb[o]), parseFloat(tb[o + 1])));
            }
            distanceOfJams = google.maps.geometry.spherical.computeLength(distanceOfJamsArr);
            dist[l] = Math.round(distanceOfJams) / 1000;
            for (var d = 0; d < tb.length; d++) {

                for (var r = 0; r < pathToString.length; r++) {
                    if (tb[d] === pathToString[r]) {
                        jamsPath.push(pathToString[r]);
                        namee.push({route: f, name: traf[l].name, location: traf[l].location, distance: dist[l]});
                    }
                }
            }
            jamsPathPolyline = [];
            for (var p = 0; p < jamsPath.length; p += 2) {
                jamsPathPolyline.push(new google.maps.LatLng(parseFloat(jamsPath[p]), parseFloat(jamsPath[p + 1])));
            }
            jamsLong = google.maps.geometry.spherical.computeLength(jamsPathPolyline);
            jamsLong = Math.round(jamsLong / 1000 * 100) / 100;
            jamsTime = (jamsLong * 60) / traf[l].speed;
            //we should add the time of distance
        }
        
        jamsTime = Math.round(jamsTime);
        // here i should add the time that depend on the distance of a route
        //time = Math.floor(routess.legs[0].duration.value / 60);
        time = jamsTime + (result.routes[f].legs[0].duration.value / 60); 
        jamsArrTotalDuration[f] = jamsTime + time;
        jamsArrDuration[f] = jamsTime// + time;// + time;;
    }
    
    var summaryPanel = document.getElementById("route-segment");
    var detailsPanel = document.getElementById("DetailsPanel");
    detailsPanel.innerHTML = "";
    var routesss = result.routes[0];
    for (var u = 0; u < routesss.legs[0].steps.length; u++) {
        detailsPanel.innerHTML += "<ul><li>" + result.routes[0].legs[0].steps[u].instructions;
        +"</li></ul>";
    }
    document.getElementById('DetailsPanel').style.visibility = 'hidden';
    summaryPanel.innerHTML = "";

    var bestRoute = Math.min.apply(Math, jamsArrTotalDuration);
    var indexOfbestroute = jamsArrTotalDuration.indexOf(bestRoute);
    summaryPanel.innerHTML += "<p style='color:#3f3f3f;font-size: 11px'>Green segment is the best Route</p>";
    for (var k = 0; k < result.routes.length; k++) {
        var routeSegment = k + 1;
        routess = result.routes[k];
        for (var p = 0; p < routess.legs.length; p++) {
            time = Math.floor(routess.legs[p].duration.value / 60) + jamsArrDuration[k];

            if (k === indexOfbestroute) {
                summaryPanel.innerHTML += "<a href='javascript:directionsDisplay.setRouteIndex(" + k + ");' style=' text-decoration:none;' title='Best Route'><div style='font-family:sans-serif;'><b><p style='color:green;'>Route Segment: " + routeSegment + "</p></b><p style='color:#3f3f3f;'> Length: " + routess.legs[p].distance.text + " Normal time: " + routess.legs[p].duration.text + " Delay: " + jamsArrDuration[k] + " mins</p></div></a><hr/>";

            } else
            {
                summaryPanel.innerHTML += "<a href='javascript:directionsDisplay.setRouteIndex(" + k + ");' style=' text-decoration:none;'><div style='font-family:sans-serif;'><b><p style='color:#3f3f3f;'>Route Segment: " + routeSegment + "</p></b><p style='color:#3f3f3f;'> Length: " + routess.legs[p].distance.text + " Normal time: " + routess.legs[p].duration.text + " Delay: " + jamsArrDuration[k] + " mins</p></div></a><hr/>";
            }
        }
    }
}
function showStep() {
    document.getElementById('DetailsPanel').style.visibility = 'visible';
    document.getElementById('show-step').style.visibility = 'hidden';
    document.getElementById('hide-step').style.visibility = 'visible';
    document.getElementById("show-step").style.position = 'absolute';
}
function hideStep() {
    document.getElementById('hide-step').style.visibility = 'hidden';
    document.getElementById('DetailsPanel').style.visibility = 'hidden';
    document.getElementById('show-step').style.visibility = 'visible';
    document.getElementById("show-step").style.position = 'static';
}

function setMarkers(title, image, location, type) {
    var xx1 = [];
    var icon;
    if (type === "Roadworks") {
        icon = 'image/roadworkIcon.jpg';
    } else
    if (type === "Accident") {
        icon = 'image/CarAccidentIcon.jpg';
    }
    else
    if (type === "Queuing traffic") {
        icon = 'image/queuingTraffic.png';
    }
    xx1 = location.split(',');
    var contentString = '<div align="center"><p style="font-size:12px">' + title + '</p><img src ="' + image + '"/>';
    var infowindow = new google.maps.InfoWindow({
        content: contentString
    });
    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(parseFloat(xx1[0]), parseFloat(xx1[1])),
        map: map,
        animation: google.maps.Animation.DROP,
        title: title,
        icon: icon
    });
    infowindow.open(map, marker);
}

function setRadar(location) {
    var xx = [];
    var radar = [];
    radar = location;
    var image = 'image/CameraSpeed.jpg';
    var myLatlng;
    var marker;
    var i = 0;
    for (i = 0; i < radar.length; i++) {
        xx = location[i].split(',');
        myLatlng = new google.maps.LatLng(parseFloat(xx[0]), parseFloat(xx[1]));
        marker = new google.maps.Marker({
            position: myLatlng,
            animation: google.maps.Animation.DROP,
            map: map,
            icon: image,
            title: 'Speed Camera!'
        });
        xx = [];
    }
}

function setNews(location, type, newsTitle, image) {
    var xx = [];
    var radar = [];
    radar = location;
    var icon;
    var myLatlng;
    var marker;
    var title;
    var contentString = [];
    var i = 0;
    for (i = 0; i < radar.length; i++) {
        if (type[i] === "Roadworks") {
            icon = 'image/roadworkIcon.jpg';
            title = "Roadworks";
        } else if (type[i] === "Accident") {
            icon = 'image/CarAccidentIcon.jpg';
            title = "Car accident";
        } else if (type[i] === "Queuing traffic") {
            icon = 'image/queuingTraffic.png';
            title = "Queuing Traffic";
        }
        xx = location[i].split(',');
        myLatlng = new google.maps.LatLng(parseFloat(xx[0]), parseFloat(xx[1]));
        marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            icon: icon,
            title: title
        });
        contentString[i] = '<div align="center"><p style="font-size:12px">' + newsTitle[i] + '</p><img src ="' + image[i] + '"/>';
        attachMessage(marker, i);
        xx = [];
    }
    function attachMessage(marker, num) {
        var infowindow = new google.maps.InfoWindow({
            content: contentString[num]
        });
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(marker.get('map'), marker);
        });
    }
}

function focusOnMarker(location) {
    var xx = location.split(',');
    map.setCenter(new google.maps.LatLng(parseFloat(xx[0]), parseFloat(xx[1])));
    map.setZoom(14);
}

function cleardirection() {
    directionsDisplay.setMap(null);
}

google.maps.event.addDomListener(window, 'load', function() {
    initialize();
});