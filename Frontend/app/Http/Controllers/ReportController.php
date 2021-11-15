<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class ReportController extends Controller
{
    public function showReport(Request $request)
    {
        $request->validate([
            'batchId' => "numeric|required"
        ]);

        $id = $request->get('batchId');
        //General report
        $responseReport = Http::get("http://localhost:8081/batchReport/find/$id");
        $report = $responseReport->json();

        //humidity
        $responseHumidity = Http::get("http://localhost:8081/batchReport/all/$id/humidities");
        $humidities = $responseHumidity->json();

        //temperatures
        $responseTemperature = Http::get("http://localhost:8081/batchReport/all/$id/temperatures");
        $temperatures = $responseTemperature->json();

        //vibrations
        $responseVibration = Http::get("http://localhost:8081/batchReport/all/$id/vibrations");
        $vibrations = $responseVibration->json();

        //timestates
        $responsetimeStates = Http::get("http://localhost:8081/batchReport/all/$id/timeStates");
        $timeStates = $responsetimeStates->json();

        if ($report == null) {
            return back()->withErrors(["batchId" => "Batch Report with ID: $id does not exist."]);
        }

        return view('batch.report', ['report' => $report,
            'humidities' => $humidities,
            'temperatures' => $temperatures,
            'vibrations' => $vibrations,
            'timestates' => $timeStates]);
    }
}
