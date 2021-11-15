<!doctype html>
<html lang="en">
<head>
    <title>Beermachine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="{{ asset('js/batchTable.js') }}"></script>
    <script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
    <link rel="stylesheet" href="{{ asset('css/app.css') }}">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="{{ route('index') }}">
            <span>Beer Brewing Machine</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="{{route('index')}}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="{{route('batch.config')}}">Configuration</a>
                </li>
                <li class="nav-item"></li>
            </ul>
            <ul class="navbar-nav d-flex">
                <li class="nav-item"></li>
                <li class="nav-item"></li>
                <li class="nav-item"></li>
            </ul>
        </div>
    </div>
</nav>

@yield('content')


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script src ="humidity.js">
</script>



<h1>Humidity: </h1>
<l class="humidity">Humidity</l>
<script>
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
        console.log(data[0]);
        $(".field").html(data);
        setTimeout(refresh, 1000);
    }

        refresh();


<h1 class="field">Test</h1>

{{--</script>--}}



</html>
