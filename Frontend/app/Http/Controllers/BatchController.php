<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class BatchController extends Controller
{
    public function index() {
        $batches = json_decode(file_get_contents('http://localhost:8081/batch/all'));
        return view("index")->with("batches", $batches);
    }


    public function create() {
        $types = json_decode(file_get_contents('http://localhost:8081/type/all'));
        return view("batch/create")->with("types", $types);
    }

    public function store(Request $request){
        $response = Http::post('http://localhost:8081/batch/add', [
            'amount' => $request->amount,
            'type'=> $request->type]);
        return redirect("index")->with('message', 'A new batch has been made');
    }

    public function showReport()
    {
        $batches = json_decode(file_get_contents('http://localhost:8081/batch/all'));
//        dd($batches);
        return view('batch/report', [
            'batchId' => $batches[0]
        ])->with('batchId');
    }


}

