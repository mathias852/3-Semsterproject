<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class APIController extends Controller
{
    public function index() {
        $json = json_decode(file_get_contents('http://localhost:8081/batch/all'), true);
        return view("api")->with("result", $json);
    }
}
