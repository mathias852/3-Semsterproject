<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class ReportController extends Controller
{
    public function showReports(Request $request)
    {
        $request->validate([
            'batchId' => "numeric|required"
        ]);

        $id = $request->get('batchId');
//        dd($id);
        $response = Http::get("http://localhost:8081/batchReport/find/$id");
        $report = $response->json();
//        dd($report);
        if ($report == null){
            return back()->withErrors(["batchId" => "Batch with ID: $id does not exist."]);
        }

        return view('batch.report', ['report' => $report]);
    }
}
