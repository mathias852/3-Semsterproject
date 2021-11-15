@extends('index')
@section('content')
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
                </tr>
            </thead>
            <tbody>
            @foreach($batches as $batch)
                <tr>
                    <th scope="row">{{$batch['id']}}</th>
                    <th scope="row">{{$batch['amount']}}</th>
                    <th scope="row">{{$batch['type']['name']}}</th>
                </tr>
            @endforeach
            </tbody>
        </table>
    </div>

    <h2>Report</h2>

    <form action="{{route('report.show')}}" method="GET">
        <label for="batchId">Enter the ID of the report:
            <input type="number" name="batchId" required>
            @if($errors->has('batchId'))
                <p>{{($errors->first())}}</p>
            @endif
        </label>
        <button type="submit">Search</button>
    </form>

    <h2>Create new batch:</h2>
    <a href="{{route('batch.create')}}">
        <button>Make new Batch</button>
    </a>
@endsection
