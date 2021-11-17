@extends('index')
@section('content')
    <div class="beerMachine-content">
        @if(@session()->has("message"))
            <p>{{@session()->get("message")}}</p>
        @endif


        <h2>All batches:</h2>

        <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table id="batchVerticalScroll" class="table table-striped table-bordered table-sm">
                <thead>
                <tr>
                    <th class="th-sm">Batch Id</th>
                    <th class="th-sm">Batch Amount</th>
                    <th class="th-sm">Batch Type</th>
                    <th class="th-sm">Batch Report</th>
                </tr>
                </thead>
                <tbody>
                @foreach($batches as $batch)
                    <tr>
                        <th scope="row">{{$batch['id']}}</th>
                        <th scope="row">{{$batch['amount']}}</th>
                        <th scope="row">{{$batch['type']['name']}}</th>
                        <th scope="row">
                            @foreach($reports as $report)
                                @if($report['batchId']==$batch['id'])
                                    <a href="{{route('reportWithId.show', ['batchId' =>$report['id']])}}">{{$report['id']}}</a>
                                @endif
                            @endforeach
                        </th>
                    </tr>
                @endforeach
                </tbody>
            </table>
        </div>
        <div class="row">

            <div class="col-sm ">
                <h2>Create new batch:</h2>
                <a href="{{route('batch.create')}}">
                    <button>Make new Batch</button>
                </a>
            </div>
            <div class="col-sm">
                <h2>Report</h2>
                <form action="{{route('reportWithId.show')}}" method="GET">
                    <h4>List of reports</h4>
                    @foreach($reports as $report)
                        @if($report['batchId'] != null)
                            <p>Report {{$report['id']}} for Batch {{$report['batchId']}}</p>
                        @else
                            <p>Report no. {{$report['id']}} belonging to batch with no relation</p>
                        @endif
                    @endforeach
                    <label for="batchId">Enter the ID of the report:
                        <input type="number" name="batchId" required>
                        @if($errors->has('batchId'))
                            <p>{{($errors->first())}}</p>
                        @endif
                    </label>
                    <button type="submit">Search</button>
                </form>
            </div>
        </div>
    </div>
@endsection
