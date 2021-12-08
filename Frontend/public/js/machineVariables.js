//Barley - inventory
var getBarley = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getBarley",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: barley
    });
}
var barley = function(data) {
    $(".barley").html(data);
    setTimeout(getBarley, 1000);
}
getBarley();

//Hops - inventory
var getHops = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getHops",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: hops
    });
}
var hops = function(data) {
    $(".hops").html(data);
    setTimeout(getHops, 1000);
}
getHops();

//Malt - inventory
var getMalt = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getMalt",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: malt
    });
}
var malt = function(data) {
    $(".malt").html(data);
    setTimeout(getMalt, 500);
}
getMalt();

//Wheat - inventory
var getWheat = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getWheat",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: wheat
    });
}
var wheat = function(data) {
    $(".wheat").html(data);
    setTimeout(getWheat, 500);
}
getWheat();

//Yeast - inventory
var getYeast = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getYeast",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: yeast
    });
}
var yeast = function(data) {
    $(".yeast").html(data);
    setTimeout(getYeast, 500);
}
getYeast();

//Maintenance - inventory
var getMaintenance = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getMaintenanceCount",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: maintenance
    });
}
var maintenance = function(data) {
    $(".maintenance").html(data);
    setTimeout(getMaintenance, 500);
}
getMaintenance();



//Humidity
var getHumidity = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getHumidity",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: humidity
    });
}
var humidity = function(data) {
    // console.log(data);
    $(".humidity").html(data);
    setTimeout(getHumidity, 500);
}
getHumidity();

//Temperature
var getTemperature = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getTemperature",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: temperature
    });
}
var temperature = function(data) {
    // console.log(data);
    $(".temperature").html(data);
    setTimeout(getTemperature, 500);
}
getTemperature();

//Vibrations
var getVibrations = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getVibrations",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: vibration
    });
}
var vibration = function(data) {
    // console.log(data);
    $(".vibration").html(data);
    setTimeout(getVibrations, 500);
}
getVibrations();

//TotalCount
var getTotalCount = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getTotalCount",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: totalCount
    });
}
var totalCount = function(data) {
    // console.log(data);
    $(".totalCount").html(data);
    setTimeout(getTotalCount, 500);
}
getTotalCount();

//GoodCount
var getGoodCount = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getGoodCount",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: goodCount
    });
}
var goodCount = function(data) {
    // console.log(data);
    $(".goodCount").html(data);
    setTimeout(getGoodCount, 500);
}
getGoodCount();

//BadCount
var getBadCount = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getBadCount",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: badCount
    });
}
var badCount = function(data) {
    // console.log(data);
    $(".badCount").html(data);
    setTimeout(getBadCount, 500);
}
getBadCount();

//CurrentState
var getCurrentState = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getCurrentState",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: currentState
    });
}
var currentState = function(data) {
    // console.log(data);
    $(".currentState").html(data);
    setTimeout(getCurrentState, 500);
}
getCurrentState();

//StopReason
var getStopReason = function() {
    $.ajax({
        url: "http://localhost:8081/machine/getStopReason",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: stopReason
    });
}
var stopReason = function(data) {
    // console.log(data);
    $(".stopReason").html(data);
    setTimeout(getStopReason, 500);
}
getStopReason();

