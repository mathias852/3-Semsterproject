@extends('index')

@section('content')
    <div class="beerMachine-content ">
        <div class="row">
            <h1>Machine Overview</h1>
            <p>Live information about the current machine variables</p>

            @if(@session()->has("message"))
                <p>{{@session()->get("message")}}</p>
            @endif

            {{--            TODO: Get current PACKML status and change "STATUS" live, maybe change the color of the 'p'-element--}}
            <div>
                <p class="status">STATUS</p>
            </div>


            <div class="row">
                <div class="col-sm">
                    <h3>Yeast</h3>
                    <label class="yeast">Yeast value not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Hops</h3>
                    <label class="hops">Hops value not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Barley</h3>
                    <label class="barley">Barley not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Wheat</h3>
                    <label class="wheat">Wheat not reading</label>
                </div>

            </div>

            <div class="row">
                <div class="col-sm">
                    <h3>Humidity: </h3>
                    <label class="humidity">Humidity not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Stop reason: </h3>
                    <label class="stopReason">Stop reason not updating...</label>
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
                    <h3>Good count: </h3>
                    <label class="gcount">Good count is not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Bad count: </h3>
                    <label class="bcount">Bad count is not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Total count: </h3>
                    <label class="tcount">Total count is not updating...</label>
                </div>

            </div>
        </div>
        <br><br>


        <div class="row">
            <h1>Controls for the machine</h1>
            <div class="row">
                {{--                TODO: Implement corrct calls to reach method for the REST side.--}}
                {{--                TODO: Maybe do this in a seperate controller to keep it simple--}}
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
                <span class="col-sm"><button class="btn btn-danger ">Stop Machine</button></span>
                <span class="col-sm"><button class="btn btn-danger">Abort</button></span>
                <span class="col-sm"><button class="btn btn-secondary">Reset Machine</button></span>
                <span class="col-sm"><button class="btn btn-secondary">Refill Machine</button></span>
                <span class="col-sm"><button class="btn btn-secondary">Maintenance</button></span>
            </div>
        </div>
    </div>


@endsection
