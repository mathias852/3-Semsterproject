<!doctype html>
<html lang="en">
<head>
    <title>Beer Machine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    {{--    LARAVEL JS+CSS--}}
    <script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
    <link rel="stylesheet" href="{{ asset('css/app.css') }}">
    {{--    JQUERY JS--}}
    <script type="text/javascript" src="{{ asset('js/jquery/jquery-3.6.0.min.js') }}"></script>
    <script type="text/javascript" src="{{ asset('js/jquery/jQueryScript.js') }}"></script>
    {{--    BOOTSTRAP CSS+JS--}}
    <script type="text/javascript" src="{{ asset('js/bootstrap.min.js') }}"></script>
    <script type="text/javascript" src="{{ asset('css/bootstrap/bootstrap4-toggle.min.js') }}"></script>
    <link rel="stylesheet" href="{{ asset('css/bootstrap/bootstrap4-toggle.min.css') }}">

    {{--    SELFSCRIPT--}}
    <script type="text/javascript" src="{{ asset('js/machineVariables.js') }}"></script>


    {{--    <script type="text/javascript" src="{{ asset('js/graph.js') }}"></script>--}}


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

                <li class="nav-item"></li>
            </ul>
        </div>
    </div>
</nav>

@yield('content')

</html>
