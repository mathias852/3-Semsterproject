window.addEventListener('load', (event) => {
    chartScript();
});

function chartScript() {
    $(document).ready(function () {
        const selectElement = document.getElementById('beerType');
        let speed = document.getElementById('speed')

        if (selectElement.value == 1) {
            // Initialize a Line chart in the container with the ID chart1
            new Chartist.Line('#beerChart', {
                //Pilsner
                labels: [30, 60, 90, 120, 150, 180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 600],
                series: [[30.00, 60.00, 89.40, 120.00, 148.00, 178.80, 208.60, 236.80, 268.20, 290.00, 312.40, 350.40, 366.60, 389.20, 402.00, 403.20, 374.00, 342.00, 288.00]]
            });
            speed.value = 460
        } else if (selectElement.value == 2) {
            new Chartist.Line('#beerChart', {
                //Wheat
                labels: [15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 165, 180, 95, 210, 225, 240, 255, 270, 285, 300],
                series: [[15.00, 30.00, 45.00, 60.00, 75.00, 89.40, 105.00, 120.00, 133.20, 150.00, 163.90, 180.00, 193.70, 208.60, 222.00, 238.40, 253.30, 261.00, 273.60, 290.00]]
            });
            speed.value = 300
        } else if (selectElement.value == 3) {
            //IPA
            new Chartist.Line('#beerChart', {
                labels: [8, 15, 23, 30, 38, 45, 53, 60, 68, 75, 83, 90, 98, 105, 113, 120, 128, 135, 143, 150],
                series: [[7.50, 15.00, 22.50, 30.00, 37.50, 45.00, 52.15, 60.00, 67.50, 75.00, 82.50, 90.00, 97.50, 105.00, 112.50, 120.00, 126.65, 134.10, 141.55, 148.00]]
            });
            speed.value = 150
        } else if (selectElement.value == 4) {
            //STAUT
            new Chartist.Line('#beerChart', {
                labels: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200],
                series: [[10.00, 20.00, 30.00, 40.00, 50.00, 60.00, 70.00, 80.00, 90.00, 100.00, 109.27, 120.00, 130.00, 140.00, 149.00, 160.00, 168.87, 180.00, 190.00, 198.67]]
            });
            speed.value = 200
        } else if (selectElement.value == 5) {
            //ALE
            new Chartist.Line('#beerChart', {
                labels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100],
                series: [[5.00, 10.00, 15.00, 20.00, 25.00, 30.00, 35.00, 40.00, 45.00, 50.00, 55.00, 60.00, 65.00, 70.00, 74.50, 79.47, 85.00, 90.00, 94.37, 100.00]]
            });
            speed.value = 100
        } else if (selectElement.value == 6) {
            //ALCHOHOL FREE
            new Chartist.Line('#beerChart', {
                labels: [6, 13, 19, 25, 31, 38, 44, 50, 56, 63, 69, 75, 81, 88, 94, 100, 106, 113, 119, 125],
                series: [[6.25, 12.50, 18.75, 25.00, 31.25, 37.50, 43.75, 50.00, 56.25, 62.50, 68.75, 75.00, 81.25, 87.50, 93.13, 99.33, 106.25, 112.50, 117.96, 125.00]]
            });
            speed.value = 125
        }


    })
}
