@extends('index')

@section('content')
    <div class="row machine-controls">
        <div class="mx-auto w-75">
            <div class="card">
                <div class="card-header">
                    <h1>Machine Overview</h1>
                </div>
                <div class="card-body">
                    <p>Live information about the current machine variables</p>

                    @if(@session()->has("message"))
                        <p>{{@session()->get("message")}}</p>
                    @endif

                    {{--            TODO: Get current PACKML status and change "STATUS" live, maybe change the color of the 'p'-element--}}
                </div>
            </div>
        </div>
    </div>

    <div class="row machine-controls">
        <div class="mx-auto w-75">
            <div class="card">
                <div class="card-header">
                    @if($currentState['message'] == null)
                        <h1 class="text-danger">NOT RUNNING</h1>
                    @else
                        <h1>{{$currentState['message']}}</h1>
                    @endif
                </div>
            </div>
        </div>
    </div>

    <div class="row machine-controls card mx-auto w-75">
        <div class="card-header">
            <h1>Controls for the machine</h1>
        </div>
        <div class="row card-body">
            {{--                TODO: Implement corrct calls to reach method for the REST side.--}}
            {{--                TODO: Maybe do this in a seperate controller to keep it simple--}}
            <span class="col-sm">

                @if (empty($batches))
                    <form action="{{route("batch.create")}}" method="get">
                        @csrf

                        <button type="submit" class="col-sm btn btn-success mb-1">Start batch</button>
                        </form>

                @else
                    <form action="{{route("batch.start")}}" method="post">
                            @csrf
                            <input type="hidden" id="id" name="id" value="{{$batches[0]['id']}}">
                            <button type="submit" class="col-sm btn btn-success mb-1">Start batch</button>
                        </form>
                @endif
                @if($currentBatch == null)
                    <button class="btn btn-secondary ">Stop Machine</button>
                @else
                    <form action="{{route("batch.stop")}}" method="post">
                    @csrf
                    <button class="btn btn-danger ">Stop Machine</button>
                </form>
                @endif

                </span>
            <span class="col-sm">
                <form action="{{route("queue.start")}}" method="post">
                    @csrf
                    <input type="hidden" name="id">
                    <button type="submit" class="col-sm btn btn-success mb-1">Start queue</button>
                </form>
                <form action="{{route("queue.stop")}}" method="post">
                    @csrf
                    <input type="hidden" name="id">
                    <button type="submit" class="col-sm btn btn-danger">Stop queue</button>
                </form>

                </span>
            <span class="col-sm">
                    <form action="{{route("batch.abort")}}" method="post">
                        @csrf
                        <button class="btn btn-danger">Abort</button>
                    </form>
                </span>
        </div>
    </div>

    <div class="card mx-auto w-75 m-2">
        <div class="card-header">
            <h2>Ingredients</h2>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Yeast</th>
                <th scope="col">Hops</th>
                <th scope="col">Barley</th>
                <th scope="col">Wheat</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="yeast">Yeast value not updating...</td>
                <td class="hops">Hops value not updating...</td>
                <td class="barley">Barley value not updating...</td>
                <td class="wheat">Wheat value not updating...</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row mb-2" >
        <div class="col"></div>
        <div class="col">
            <div class="card">
                <div class="card-header">
                    <h3>Humidity</h3>
                </div>
                <div class="card-body">
                    <label class="humidity">Humidity not updating...</label>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header">
                    <h3>Temperature: </h3>
                </div>
                <div class="card-body">
                    <label class="temperature">Temperature is not updating...</label>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header">
                    <h3>Vibration: </h3>
                </div>
                <div class="card-body">
                    <label class="vibration">Vibration is not updating...</label>
                </div>
            </div>
        </div>
        <div class="col"></div>
    </div>
    <div class="row">
        <div class="col"></div>
        <div class="col">
            <div class="card">
                <div class="card-header"><h3>Stop reason: </h3></div>
                <div class="card-body"><label class="stopReason">Stop reason not updating...</label></div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header"><h3>Good count: </h3></div>
                <div class="card-body"><label class="goodCount">Good count is not updating...</label></div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header"><h3>Bad count: </h3></div>
                <div class="card-body"><label class="badCount">Bad count is not updating...</label></div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header"><h3>Total count: </h3></div>
                <div class="card-body"><label class="totalCount">Total count is not updating...</label></div>
            </div>
        </div>
        <div class="col"></div>
    </div>

@endsection
