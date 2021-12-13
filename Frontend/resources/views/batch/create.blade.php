@extends('index')
@section('content')

    <html>
    <head>
        <link rel="stylesheet" href="{{asset('css/chartist.min.css')}}">
        <script src="{{asset('js/chartist.min.js')}}"></script>
        <script type="text/javascript" src="{{ asset('js/changeChart.js') }}"></script>
    </head>
    <body>

    @if(@session()->has("message"))
        <p>{{@session()->get("message")}}</p>
    @endif

    <div class="create-form">
        <h2>New batch:</h2>
        <form action="{{route("batch.store")}}" method="post">
            @csrf
            <label for="amount" class="fw-bold">Amount</label>
            <input type="number" id="amount" name="amount" class="form-control" required>
            <label for="beerType" class="fw-bold">Type of Beer</label>
            <select id="beerType" name="type" class="form-control dropdown" onchange="chartScript()">
                {{--        TODO: Make queue implementation--}}
                @foreach($types as $type)
                    <option value="{{$type['id']}}">{{$type['name']}}</option>
                @endforeach
            </select>
            <label class="fw-bold">Speed</label>
            <input type="number" id="speed" name="speed" class="form-control" placeholder="460" required>
            <br>
            <button type="submit" class="form-control">Submit</button>
        </form>
    </div>

    <div class="ct-chart ct-golden-section" id="beerChart" style="height: 300px"></div>


    </body>
    </html>
@endsection
