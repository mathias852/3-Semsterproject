<?php

use App\Http\Controllers\batchController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create.blade.php something great!
|
*/

Route::get('/', [batchController::class, "index"])->name("index");
Route::get('batch/create', [batchController::class, "create"])->name("batch.create");
Route::post('batch/create', [batchController::class, "store"])->name("batch.store");
Route::get("batch/*/report", [batchController::class, "showReport", function () {
    return view('batch.report');
}])->name("batch.showReport");
//Route::get("batch/{id}/report", [batchController::class, "showReport"])->name("batch.showReport");


