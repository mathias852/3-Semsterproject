<?php

use App\Http\Controllers\BatchController;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\APIController;
use Symfony\Component\Console\Input\Input;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/index', [BatchController::class, "index"])->name("index");
Route::post('/index', [BatchController::class, "store"])->name("index.store");
Route::get('/batch/create', [BatchController::class, "create"])->name("batch.create");
Route::get('/batch/{batchId}/report', [BatchController::class, "showReport"])->name('showReport');
