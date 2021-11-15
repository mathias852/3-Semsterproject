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
    console.log(data);
    $(".humidity").html(data + "%");
    setTimeout(getHumidity, 1000);
}

getHumidity();
