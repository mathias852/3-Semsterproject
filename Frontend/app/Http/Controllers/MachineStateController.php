<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class MachineStateController extends Controller
{
    public function startMachine()
    {
        $machineState = Http::post("http://localhost:8081/machinestate/start");
    }

}
