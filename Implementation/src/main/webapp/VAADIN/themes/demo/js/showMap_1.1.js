/**
 * 
 */
window.com_polimi_travlendar_gmaps_JavaScriptMap = function() { //Put correct package name

      this.myfunction = function(latitude, longitude) {     //Accept the parameters
         var map;

            //mapob is the id of your component
         function initialize(){
            map = new google.maps.Map(document.getElementById("mapob"), { 
            zoom: 16,
            center: {lat: latitude, lng: longitude}
              });
         }
            initialize();
    }
};