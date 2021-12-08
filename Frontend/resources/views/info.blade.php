@extends('index')

@section('content')
    <div class="beerMachine-info">
        <div class="row">
            <h1>Machine Overview</h1>
            <p>Live information about the current machine variables</p>

            @if(@session()->has("message"))
                <p>{{@session()->get("message")}}</p>
            @endif

            {{--            TODO: Get current PACKML status and change "STATUS" live, maybe change the color of the 'p'-element--}}
            <div>

                @if($currentState['message'] == null)
                    <p class="status">NOT RUNNING</p>
                @else
                    <p class="status">{{$currentState['message']}}</p>
                @endif
            </div>
        </div>
    </div>



    <div class="row machine-controls">
        <h1>Controls for the machine</h1>
        <div class="row">
            <span class="col-sm">

                    @if (empty($batches))
                    <form action="{{route("batch.create")}}" method="get">
                        @csrf

                        <button type="submit" class="col-sm btn btn-success">Start batch</button>
                        </form>

                @else
                    <form action="{{route("batch.start")}}" method="post">
                            @csrf
                            <input type="hidden" id="id" name="id" value="{{$batches[0]['id']}}">
                            <button type="submit" class="col-sm btn btn-success">Start batch</button>
                        </form>
                @endif
                </span>
            <span class="col-sm">
                    <form action="{{route("batch.stop")}}" method="POST">
                        @csrf
                        <button class="btn btn-danger ">Stop Machine</button>
                    </form>
                </span>
            <span class="col-sm">
                    <form action="{{route("batch.abort")}}" method="POST">
                        @csrf
                        <button class="btn btn-danger">Abort</button>
                    </form>
                </span>
            <span class="col-sm">
                <form action="{{ route("batch.reset") }}" method="POST">
                @csrf
                <button class="btn btn-secondary">Reset Machine</button>
                </form>
            </span>
        </div>
    </div>

    <div class="machine-variables">
        <h2>Ingredients</h2>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Yeast</th>
                <th scope="col">Hops</th>
                <th scope="col">Barley</th>
                <th scope="col">Wheat</th>
                <th scope="col">Maintenance</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="yeast">Yeast value not updating...</td>
                <td class="hops">Hops value not updating...</td>
                <td class="barley">Barley value not updating...</td>
                <td class="wheat">Wheat value not updating...</td>
                <td class="maintenance">Maintenance not updating...</td>
            </tr>
            </tbody>
        </table>

    </div>
    <div class="row machine-variables">


        <div class="col-sm">
            <h3>Humidity: </h3>
            <label class="humidity">Humidity not updating...</label>
        </div>
        <div class="col-sm">
            <h3>Temperature: </h3>
            <label class="temperature">Temperature is not updating...</label>
        </div>
        <div class="col-sm">
            <h3>Vibration: </h3>
            <label class="vibration">Vibration is not updating...</label>
        </div>
        <div class="col-sm">
            <h3>Stop reason: </h3>
            <label class="stopReason">Stop reason not updating...</label>
        </div>
        <div class="col-sm">
            <h3>Good count: </h3>
            <label class="goodCount">Good count is not updating...</label>
        </div>
        <div class="col-sm">
            <h3>Bad count: </h3>
            <label class="badCount">Bad count is not updating...</label>
        </div>
        <div class="col-sm">
            <h3>Total count: </h3>
            <label class="totalCount">Total count is not updating...</label>
        </div>
    </div>





@endsection
