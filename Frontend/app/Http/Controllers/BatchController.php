<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;
use Symfony\Component\Console\Input\Input;

class batchController extends Controller
{
    public function index() {
//        return view("index");
        return view("info");
    }

    public function create() {
        $response = Http::get('http://localhost:8081/type/all');
        $types = $response->json();

        return view("batch/create")->with("types", $types);
    }

    public function store(Request $request){
        $post = Http::post('http://localhost:8081/batch/add', [
            'type' => $request->type,
            'amount' => $request->amount
        ]);
        return redirect("/configuration")->with('message', "New batch has been made");
    }

    public function config(){
        $response = Http::get('http://localhost:8081/batch/all');
        $batches = $response->json();
        return view("config", ['batches' => $batches]);
    }





}
