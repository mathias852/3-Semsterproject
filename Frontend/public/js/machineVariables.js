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

/*//Malt - inventory
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
getYeast();*/



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
    setTimeout(getHumidity, 500);
}
getHumidity();*/
