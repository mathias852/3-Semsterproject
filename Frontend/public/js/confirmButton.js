function switchConfirmation() {
    let state = document.getElementById("checkbox").checked;
    let r = confirm("Are you sure you want to change host?!");
    if (r === true) {
        // console.log("You pressed OK");
        switchHost();
        if (state) {
            document.getElementById("checkbox").checked;
        } else {
            document.getElementById("checkbox").checked = false;
        }
    } else {
        document.getElementById("checkbox").checked = !state;
    }
}

//Saving state of checkbox
function saveCheckbox() {
    $('checkbox').on('change', function () {
        console.log("Saving state");
        let $el = $(this);
        sessionStorage[$el.prop('id')] = $el.is(':checked');
    });
}

let host = "";

var switchHost = function() {
    if(document.getElementById("checkbox").checked){
        host = "192.168.0.122";
    } else {
        host = "127.0.0.1"
    }
    $.ajax({
        url: "http://localhost:8081/machine/setHost/" + host,
        cache: false,
        type: 'POST',
        dataType: 'json',
        headers: {
            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
        },
        success: hostFunc
    });
}

var hostFunc = function() {
    console.log("Switched host to " + host)
}
