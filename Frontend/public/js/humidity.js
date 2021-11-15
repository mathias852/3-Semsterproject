var refresh = function() {
    $.ajax({
        url: "http://localhost:8081/machineState/getHumidity",
        cache: false,
        type: 'GET',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: success
    });
}

var success = function(data) {
    console.log(data);
    $(".humidity").html(data);
    setTimeout(refresh, 1000);
}

refresh();
