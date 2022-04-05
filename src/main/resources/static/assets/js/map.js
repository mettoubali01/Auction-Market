let map;
let suggestList = document.getElementById("list");
const apiKeyValue = `JrjM6YQD4R9vVzYzWj6WVCFkvjIWA1eiYhgLDj_hrRc`;

async function main() {

    let platform = new H.service.Platform({
        apikey: apiKeyValue
    });

    let defaultLayers = platform.createDefaultLayers();

    //Step 2: initialize a map - this map is centered over Europe
    map = new H.Map(document.getElementById('mapContainer'),
        defaultLayers.vector.normal.map, {
            center: {lat: 50, lng: 5},
            zoom: 4,
            pixelRatio: window.devicePixelRatio || 1
        });

    // add a resize listener to make sure that the map occupies the whole container
    window.addEventListener('resize', () => map.getViewPort().resize());
    //Step 3: make the map interactive
    // MapEvents enables the event system
    // Behavior implements default interactions for pan/zoom (also on mobile touch environments)
    let behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(map));


}

// to get default location
function getDefaultLocation() {
    let lat = 39.93075, lng = 4.14049;

    addMarkerToMap(lat, lng);
}

const addMarkerToMap = (lat, lng) => {
    map.removeObjects(map.getObjects())

    let selectedLocationMarker = new H.map.Marker({lat, lng});
    map.addObject(selectedLocationMarker);

    if (suggestList)
        suggestList.innerHTML = ``;

    map.setCenter({lat, lng}, true);
};

main().then(err => {
    console.log("error showing map ", err);
});

if (!suggestList)
    getDefaultLocation();
