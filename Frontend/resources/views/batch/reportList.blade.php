@extends('index')
@section('content')
    <div class="col-sm beerMachine-content">
        <h2>Report</h2>
        <form action="{{route('reportWithId.show')}}" method="GET">
            <h4>List of reports</h4>
            <div class="table-wrapper-scroll-y my-custom-scrollbar">
                <table id="batchVerticalScroll" class="table table-striped table-bordered table-sm">
                    <thead>
                    <tr>
                        <th class="th-sm">Report Id</th>
                        <th class="th-sm">Report Link</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($reports as $report)
                        <tr>
                            <th scope="row">{{$report['id']}}</th>
                            <th><a href="{{route('reportWithId.show', ['batchId' =>$report['id']])}}">Detailed report</a></th>
                        </tr>
                    @endforeach
                    </tbody>
                </table>
            </div>

            <label for="batchId">Search for report id: <br>
                <input type="number" name="batchId" required>
                @if($errors->has('batchId'))
                    <p>{{($errors->first())}}</p>
                @endif
            </label> <br>
            <button type="submit">Search</button>
        </form>
    </div>
@endsection
