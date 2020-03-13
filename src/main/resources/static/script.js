function initMap() {
  // The location of Uluru
  var rencen = {lat: 42.3293 , lng: -83.0398 };
  var rencen2 = {lat: 42.5 , lng: -82.9 };
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 8, center: rencen});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: rencen, map: map});
  var marker = new google.maps.Marker({position: rencen2, map: map});
}


src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQBAPP61snKjU7C8Gma0DXzZ_YkJ9wsLk&callback=initMap"                                             