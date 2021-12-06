@extends('index')
@section('content')

    <html>
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
            <input type="number" id="speed" name="speed" class="form-control" required>
            <br>
            <button type="submit" class="form-control">Submit</button>
        </form>
    </div>

    <div id="pilsnerChart" style="height: 300px;"></div>
    <script>
        const chart = new Chartisan({
            el: '#pilsnerChart',
            url: "@chart('sample_chart')",
            hooks: new ChartisanHooks()
                .datasets([{type: 'line', fill: false}, 'bar'])
        });
    </script>



    </body>
    </html>
@endsection
