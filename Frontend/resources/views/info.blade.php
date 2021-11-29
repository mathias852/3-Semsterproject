@extends('index')

@section('content')
    <div class="beerMachine-content ">
        <div class="row">
            <h1>Machine Overview</h1>
            <p>Live information about the current machine variables</p>

{{--            TODO: Get current PACKML status and change "STATUS" live, maybe change the color of the 'p'-element--}}
            <div>
                <p class="status">STATUS</p>
            </div>


            <div class="row">
                <div class="col-sm">
                    <h3>Humidity: </h3>
                    <label class="humidity">Humidity not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Temperature: </h3>
                    <label class="temperature">Temperature is not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Vibration: </h3>
                    <label class="vibration">Vibration is not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Good count: </h3>
                    <label class="goodCount">Good count is not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Bad count: </h3>
                    <label class="badCount">Bad count is not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Total count: </h3>
                    <label class="totalCount">Total count is not updating...</label>
                </div>
            </div>

            <br><br>

            <div class="row" style="margin-top: 5%">
                <div class="col-sm">
                    <h3>Barley: </h3>
                    <label class="barley">Barley not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Hops: </h3>
                    <label class="hops">Hops not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Malt: </h3>
                    <label class="malt">Malt not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Wheat: </h3>
                    <label class="wheat">Wheat not updating...</label>
                </div>
                <div class="col-sm">
                    <h3>Yeast: </h3>
                    <label class="yeast">Yeast not updating...</label>
                </div>


            </div>


        </div>
        <br><br>


        <div class="row">
            <h1>Controls for the machine</h1>
            <div class="row">
                {{--                TODO: Implement corrct calls to reach method for the REST side.--}}
                {{--                TODO: Maybe do this in a seperate controller to keep it simple--}}
                <span class="col-sm"><button>Start Machine</button></span>
                <span class="col-sm"><button>Stop Machine</button></span>
                <span class="col-sm"><button>Reset Machine</button></span>
                <span class="col-sm"><button>Refill Machine</button></span>
                <span class="col-sm"><button>Abort</button></span>
                <span class="col-sm"><button>Maintenance</button></span>
            </div>
            <div class="row">
                <span class="col-sm"><button>ABORT</button></span>
            </div>
        </div>
    </div>

    {{--</div>--}}
@endsection
