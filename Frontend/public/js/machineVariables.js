//Humidity
/*var getHumidity = function() {
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
    setTimeout(getHumidity, 1000);
}
getHumidity();*/

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
    setTimeout(getWheat, 1000);
}
getWheat();
