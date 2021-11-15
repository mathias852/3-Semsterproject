@extends('index')

@section('content')

    <h1>Machine Overview</h1>
    <p>Information about the current machine variables</p>

    <h3>Humidity: </h3>
    <l class="humidity">Humidity not updating...</l>

    <h3>Temperature: </h3>
    <label class="temperature">Temperature is not updating...</label>

    <h3>Vibration: </h3>
    <label class="vibration">Vibration is not updating...</label>

    <h3>Good count: </h3>
    <label class="gcount">Good count is not updating...</label>

    <h3>Bad count: </h3>
    <label class="bcount">Bad count is not updating...</label>

    <h3>Total count: </h3>
    <label class="tcount">Total count is not updating...</label>

@endsection
