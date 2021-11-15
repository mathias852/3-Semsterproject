<!doctype html>
<html lang="en">
<head>
    <title>Beermachine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="{{ asset('js/batchTable.js') }}"></script>
    <script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
    <script type="text/javascript" src="{{ asset('js/machineVariables.js') }}"></script>

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

<h1>Machine Overview</h1>
<p>Information about the current machine variables</p>

<h3>Humidity: </h3>
<l class="humidity">Humidity not updating...</l>

<h3>Temperature: </h3>
<label class="temperature">Temperature is not updating...</label>

<h3>Vibration: </h3>
<label class="vibration">Vibration is not updating...</label>

<h3>Good count: </h3>
<label class="gcount">Good count is not updating...</label>

<h3>Bad count: </h3>
<label class="bcount">Bad count is not updating...</label>

<h3>Total count: </h3>
<label class="tcount">Total count is not updating...</label>



{{--</script>--}}

</html>
