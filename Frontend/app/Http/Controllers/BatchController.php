<?php

namespace App\Http\Controllers;

use http\Client\Curl\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class BatchController extends Controller
{
    public function index()
    {
        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        $getCurrentBatch = Http::get('http://localhost:8081/machineState/getBatch');
        $currentBatch = $getCurrentBatch->json();

        $getState = Http::get('http://localhost:8081/machine/getState');
        $currentState = $getState->json();



        return view("info")->with(['batches' => $batches, 'currentBatch' => $currentBatch, 'currentState' => $currentState]);
//        return view("info")->with(['batches' => $batches, 'currentBatch' => $currentBatch]);
    }

    public function create()
    {
        $response = Http::get('http://localhost:8081/type/all');
        $types = $response->json();
        return view("batch.create")->with("types", $types);
    }

    public function store(Request $request)
    {

        $request->validate([
            'type' => ['required'],
            'amount' => ['required'],
            'speed' => ['required']
        ]);

        Http::post('http://localhost:8081/batch/add', [
            'type' => $request->type,
            'amount' => $request->amount,
            'speed' => $request->speed
        ]);

        return redirect("/batches")->with('message', "New batch has been made");
    }

    public function start(Request $request)
    {
        $id = $request->id;
        Http::post("http://localhost:8081/machine/start/$id");
        return redirect()->route("batch.destroy", $request->id);
    }

    public function destroy(Request $request)
    {

        $id = $request->id;

        Http::delete("http://localhost:8081/batch/delete/$id");

        return redirect("/")->with('message', "Batch $id has been started");
    }

    public function list()
    {
        //batches
        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        //reports
        $responseReport = Http::get('http://localhost:8081/batchReport/all');
        $reports = $responseReport->json();

        usort($batches, function ($a, $b) {
            return $a['queueSpot'] - $b['queueSpot'];
        });

        return view("list", ['batches' => $batches,
            'reports' => $reports]);
    }


    public function stop()
    {
        Http::post('http://localhost:8081/machine/stop');
        return redirect("/")->with('message', "Machine has been stopped");
    }

    public function abort()
    {
        Http::post('http://localhost:8081/machine/abort');
        return redirect("/")->with('message', "Abort has been completed ");
    }

    public function reset()
    {
        Http::post('http://localhost:8081/machine/reset');
        return redirect("/")->with('message', "The machine is resetting");
    }

    public function maintenance()
    {
        Http::post('http://localhost:8081/machine/maintenance');
        return redirect("/")->with('message', "Maintenance is starting...");
    }

    public function queueUp(Request $request) {
        $id = $request->id;

        Http::post("http://localhost:8081/batch/set/queue/up/$id");

        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        //reports
        $responseReport = Http::get('http://localhost:8081/batchReport/all');
        $reports = $responseReport->json();

        usort($batches, function ($a, $b) {
            return $a['queueSpot'] - $b['queueSpot'];
        });

        return view("list", ['batches' => $batches,
            'reports' => $reports]);
    }

    public function queueDown(Request $request) {
        $id = $request->id;

        Http::post("http://localhost:8081/batch/set/queue/down/$id");

        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        //reports
        $responseReport = Http::get('http://localhost:8081/batchReport/all');
        $reports = $responseReport->json();

        usort($batches, function ($a, $b) {
            return $a['queueSpot'] - $b['queueSpot'];
        });

        return view("list", ['batches' => $batches,
            'reports' => $reports]);
    }
}

