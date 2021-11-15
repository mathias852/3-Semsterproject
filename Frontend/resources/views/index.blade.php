
<?php header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: *');
header('Access-Control-Allow-Headers: *');
?>


<h1>GOTO CONFIGURAION</h1>
<a href="{{route('batch.config')}}">
    <button>Configuration</button>
</a>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>
    var refresh = function() {
        $.ajax({
            url: "http://localhost:8081/machineState/getHumidity",
            cache: false,
            type: 'GET',
            dataType: 'json',
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
            success: success
        });
    }

    var success = function(data) {
        console.log(data[0]);
        $(".field").html(data);
        setTimeout(refresh, 1000);
    }

        refresh();

</script>

<h1 class="field">Test</h1>
