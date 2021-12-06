function chartScript() {
    $(document).ready(function () {
        const selectElement = document.getElementById('beerType');
        let speed = document.getElementById('speed')
        console.log(selectElement.value);
        console.log(speed.value)

        if (selectElement.value == 1) {

            document.getElementById('beerChart').hidden = false
            speed.value = 200
        } else if (selectElement.value == 2) {

            document.getElementById('beerChart').hidden = true
            speed.value = 200
        } else if (selectElement.value == 3) {
            document.getElementById('beerChart').hidden = true
            speed.value = 200
        } else if (selectElement.value == 4) {
            document.getElementById('beerChart').hidden = true
            speed.value = 200
        } else if (selectElement.value == 5) {
            document.getElementById('beerChart').hidden = true
            speed.value = 200
        } else if (selectElement.value == 6) {
            document.getElementById('beerChart').hidden = true
            speed.value = 200
        }




    })
}
