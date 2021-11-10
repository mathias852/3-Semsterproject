<!DOCTYPE html>
<html>
<head>
    @if(session()->has('message'))
        <p style="background-color: #2d3748; color:white;" class="success-message">{{session()->get('message')}}</p>
    @endif

    <h1>Current batches: </h1>
</head>
<body>
@foreach($batches as $item)
    <li>
        {{--            <a href="{{route()}}">Link</a>--}}
        <label>ID: {{$item->id}}</label>
        <label>Amount: {{$item->amount}}</label>
    </li>
@endforeach

<h2>Report</h2>
<form action="{{route('showReport', 1)}}" method="get">
    @csrf
    <label for="batchId">Enter the batchid for the report
        <input type="number" name="batchId">
    </label>
    <button type="submit">Search</button>
</form>
<br>
<a href="{{route('batch.create')}}">
    <button>Make new Batch</button>
</a>


</body>
</html>
