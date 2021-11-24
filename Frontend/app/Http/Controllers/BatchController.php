<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class BatchController extends Controller
{
    public function index() {
        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        return view("info")->with('batches', $batches);
    }

    public function create() {
        $response = Http::get('http://localhost:8081/type/all');
        $types = $response->json();
        return view("batch.create")->with("types", $types);
    }

    public function store(Request $request){

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

    public function start(Request $request){
        //need java route for starting
        //
        //
        //
        //
        return redirect()->route("batch.destroy", $request->id);
    }

    public function destroy(Request $request){

        $id = $request->id;

        Http::delete("http://localhost:8081/batch/delete/$id");

        return redirect("/")->with('message', "Batch $id has been started");
    }

    public function list(){

        //batches
        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        //reports
        $responseReport = Http::get('http://localhost:8081/batchReport/all');
        $reports = $responseReport->json();
//        dd($reports);
        return view("list", ['batches' => $batches,
            'reports' => $reports]);
    }





}
