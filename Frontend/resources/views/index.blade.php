
<h1>GOTO CONFIGURAION</h1>
<a href="{{route('batch.config')}}">
    <button>Configuration</button>
</a>

<script>
    var refresh = function() {
        $.ajax({
            url: "/some/path",
            cache: false,
            success: success
        });
    }

    var success = function(data) {
        $(".field").html(data);
        setTimeout(refresh, 1000);
    }

    $(function() {
        refresh();
    });

</script>

