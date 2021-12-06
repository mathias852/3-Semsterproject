<!doctype html>
<html lang="en">
<head>
    <title>Beer Machine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
    <script type="text/javascript" src="{{ asset('js/machineVariables.js') }}"></script>
    <script type="text/javascript" src="{{ asset('js/confirmButton.js') }}"></script>
    <script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js></script>
    <script src=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/js/dataTables.bootstrap4.min.js></script>

    <link rel="stylesheet" href="{{ asset('css/app.css') }}">
    <link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
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
                    <a class="nav-link" href="{{route('batch.list')}}">Batches</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="{{route('report.list')}}">Reports</a>
                </li>
            </ul>
            <ul class="navbar-nav d-flex">
                <li class="nav-item">
                   <label for="checkbox">Machine: </label><input type="checkbox" id="checkbox" checked data-on="Machine" data-off="Simulator" data-onstyle="success" data-offstyle="danger" onchange="switchConfirmation()">
                </li>
                <li class="nav-item"></li>
            </ul>
        </div>
    </div>
</nav>

@yield('content')

</html>
