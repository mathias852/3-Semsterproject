<html>
<body>

<h2>New batch:</h2>
<form action="{{route("batch.store")}}" method="post">
    @csrf
    <label>Amount: </label>
    <input type="text" id="amount" name="amount">
    <label>Type of Beer:</label>
    <select  id="type" name="type">
        @foreach($types as $type)
            <option value="{{$type->id}}">{{$type->name}}</option>
        @endforeach
    </select>
    <button type="submit">Submit</button>
</form>

</body>
</html>
