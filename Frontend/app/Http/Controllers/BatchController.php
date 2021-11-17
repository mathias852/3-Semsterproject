<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class BatchController extends Controller
{
    public function index() {
        return view("info");
    }

    public function create() {
        $response = Http::get('http://localhost:8081/type/all');
        $types = $response->json();
        return view("batch.create")->with("types", $types);
    }

    public function store(Request $request){
        Http::post('http://localhost:8081/batch/add', [
            'type' => $request->type,
            'amount' => $request->amount
        ]);

        return redirect("/configuration")->with('message', "New batch has been made");
    }

    public function list(){

        //batches
        $responseBatch = Http::get('http://localhost:8081/batch/all');
        $batches = $responseBatch->json();

        //reports
        $responseReport = Http::get('http://localhost:8081/batchReport/all');
        $reports = $responseReport->json();
        return view("list", ['batches' => $batches,
            'reports' => $reports]);
    }





}
