@extends('index')
@section('content')
    <div class="beerMachine-content">

        <h2>All batches:</h2>
        <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table id="batchVerticalScroll" class="table table-striped table-bordered table-sm">
                <thead>
                <tr>
                    <th class="th-sm">Batch Id</th>
                    <th class="th-sm">Batch Amount</th>
                    <th class="th-sm">Batch Type</th>
                    <th class="th-sm">Batch Speed</th>
                    <th class="th-sm">Queue spot</th>
                    <th class="th-sm">Batch Report</th>
                </tr>
                </thead>
                <tbody>
                @foreach($batches as $batch)
                    <tr>
                        <th scope="row">{{$batch['id']}}</th>
                        <th scope="row">{{$batch['amount']}}</th>
                        <th scope="row">{{$batch['type']['name']}}</th>
                        <th scope="row">{{$batch['speed']}}</th>
                        <th scope="row">{{$batch['queueSpot']}}</th>
                        <th scope="row">
                            @foreach($reports as $report)
                                @if($report['batchId']==$batch['id'])
                                    <a href="{{route('reportWithId.show', ['batchId' =>$report['id']])}}">{{$report['id']}}</a>
                                @endif
                            @endforeach
                        </th>
                        <th scope="row">
                            <form action="{{route("batch.start")}}" method="post">
                                @csrf
                                <input type="hidden" id="id" name="id" value="{{$batch['id']}}">
                                <button type="submit" class="form-control">Start batch</button>
                            </form>
                        </th>
                        <th scope="row">
                            <form action="{{route("queue.up", $batch['id'])}}" method="post">
                                @csrf
                                <input type="hidden" id="id" name="id" value="{{$batch['id']}}">
                                <button type="submit" class="form-control">Move up in queue</button>
                            </form>
                            <form action="{{route("queue.down", $batch['id'])}}" method="post">
                                @csrf
                                <input type="hidden" id="id" name="id" value="{{$batch['id']}}">
                                <button type="submit" class="form-control">Move down in queue</button>
                            </form>
                        </th>
                    </tr>
                @endforeach
                </tbody>
            </table>
        </div>
        <div class="row">
            @if(@session()->has("message"))
                <p>{{@session()->get("message")}}</p>
            @endif

            <div class="col-sm ">
                <h2>Create new batch:</h2>
                <a href="{{route('batch.create')}}">
                    <button>Make new Batch</button>
                </a>
            </div>

        </div>
    </div>
@endsection
