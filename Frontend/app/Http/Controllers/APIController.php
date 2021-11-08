<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;


class APIController extends Controller
{
    public function index() {
        $json = json_decode(file_get_contents('http://localhost:8081/batch/all'), true);
        return view("api")->with("result", $json);
    }

    public function store(Request $request){
        $response = Http::post('http://localhost:8081/batch/add', [
            'amount' => $request->amount,
            'type'=> $request->type]);
        return redirect("api");
    }

}
