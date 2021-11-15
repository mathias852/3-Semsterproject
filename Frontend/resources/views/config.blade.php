
@if(@session()->has("message"))
    <p>{{@session()->get("message")}}</p>
@endif


<h2>All batches:</h2>


<table>
    <tr>
        <th>Batch Id</th>
{{--        <th>Batch Type</th>--}}
        <th>Amount</th>
    </tr>
@foreach($batches as $batch)
{{--    <li>--}}
{{--        <label for="batchId">Batch: {{$batch->id}}</label>--}}
{{--        <label for="batchAmount">Amount: {{$batch->amount}}</label>--}}
{{--    </li>--}}
<tr>{{$batch->id}}</tr>
<tr>{{$batch->amount}}</tr>




    </table>

@endforeach

<h2>Report</h2>

<form action="{{route('report.view')}}" method="GET">

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
{{--{{dd($_POST)}}--}}
