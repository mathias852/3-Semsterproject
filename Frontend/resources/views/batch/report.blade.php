@extends('index')
@section('content')

    <div class="row informationReport">
        <h1>General Information</h1>
        {{--        Taking the value of each item and outputting it to the html--}}
        @foreach($report as $item => $value1)
            <div class="col-sm-2">
                <div class="card text-center">
                    <div class="card-header batchHead">{{$item}}</div>
                    <div class="card-body">
                        @if($value1 == null)
                            <h5>{{$value = 'N/A'}}</h5>
                        @elseif($item == 'type')
                            <h5 class="card-title">{{$value1['name']}}</h5>
                        @else
                            <h5 class="card-title">{{$value1}}</h5>
                        @endif
                    </div>
                    <div class="card-footer text-muted"></div>
                </div>
            </div>
        @endforeach
    </div> <br>

    {{--    MORE INFORMATION--}}
    <div class="row informationReport ">
        <div class="col-sm ">
            <h1 class="text-center">Humidities</h1>
            <div class="table-wrapper-scroll-y my-custom-scrollbar vertical-scroll-table ">
                <table id="vertical-scroll-table" class="table table-striped table-bordered table-sm">
                    <thead>
                    <tr>
                        <th class="th-sm">Id</th>
                        <th class="th-sm">Humidity</th>
                        <th class="th-sm">Timestamp</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($humidities as $humidity)
                        <tr>
                            <th scope="row">{{$humidity['id']}}</th>
                            <th scope="row">{{$humidity['humidity']}}</th>
                            <th scope="row">{{$humidity['timestamp']}}</th>
                        </tr>
                    @endforeach
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col-sm">
            <h1 class="text-center">Temperatures</h1>
            <div class="table-wrapper-scroll-y my-custom-scrollbar vertical-scroll-table">
                <table id="vertical-scroll" class="table table-striped table-bordered table-sm">
                    <thead>
                    <tr>
                        <th class="th-sm">Id</th>
                        <th class="th-sm">Temperature</th>
                        <th class="th-sm">Timestamp</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($temperatures as $temperature)
                        <tr>
                            <th scope="row">{{$temperature['id']}}</th>
                            <th scope="row">{{$temperature['temperature']}}</th>
                            <th scope="row">{{$temperature['timestamp']}}</th>
                        </tr>
                    @endforeach
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-sm">
            <h1 class="text-center">Vibrations</h1>
            <div class="table-wrapper-scroll-y my-custom-scrollbar vertical-scroll-table">
                <table id="vertical-scroll" class="table table-striped table-bordered table-sm">
                    <thead>
                    <tr>
                        <th class="th-sm">Id</th>
                        <th class="th-sm">Vibration</th>
                        <th class="th-sm">Timestamp</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($vibrations as $vibration)
                        <tr>
                            <th scope="row">{{$vibration['id']}}</th>
                            <th scope="row">{{$vibration['vibration']}}</th>
                            <th scope="row">{{$vibration['timestamp']}}</th>
                        </tr>
                    @endforeach
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-sm">
            <h1 class="text-center">Time States</h1>
            <div class="table-wrapper-scroll-y my-custom-scrollbar vertical-scroll-table">
                <table id="vertical-scroll" class="table table-striped table-bordered table-sm">
                    <thead>
                    <tr>
                        <th class="th-sm">Id</th>
                        <th class="th-sm">StateId</th>
                        <th class="th-sm">StopReason</th>
                        <th class="th-sm">Start Time</th>
                        <th class="th-sm">End Time</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($timestates as $timestate)
                        <tr>
                            <th scope="row">{{$timestate['id']}}</th>
                            <th scope="row">{{$timestate['stateId']}}</th>
                            <th scope="row">{{$timestate['stopReason']}}</th>
                            <th scope="row">{{$timestate['startTime']}}</th>
                            <th scope="row">{{$timestate['endTime']}}</th>
                        </tr>
                    @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>

@endsection
