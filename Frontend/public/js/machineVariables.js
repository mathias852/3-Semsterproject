//Get vibration



var getVibration = function() {
    $.ajax({
        url: "http://localhost:8081/machineState/getVibration",
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
    $(".vibration").html(data + "%");
    setTimeout(getVibration, 1000);
}

getVibration();

//Get temperature

var getTemperature = function() {
    $.ajax({
        url: "http://localhost:8081/machineState/getTemperature",
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
    $(".temperature").html(data + "%");
    setTimeout(getTemperature, 1000);
}

getTemperature();

//Get Humidity

var getHumidity = function() {
    $.ajax({
        url: "http://localhost:8081/machineState/getHumidity",
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
    $(".humidity").html(data + "%");
    setTimeout(getHumidity, 1000);
}

getHumidity();

//Get stopReason

var getStopReason = function() {
    $.ajax({
        url: "http://localhost:8081/machineState/getStopreason",
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
    setTimeout(getStopReason, 1000);
}

getStopReason();


