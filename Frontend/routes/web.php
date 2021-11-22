<?php

use App\Http\Controllers\BatchController;
use App\Http\Controllers\ReportController;
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
//index
Route::get('/', [BatchController::class, "index"])->name("index");

//configuration
Route::get('/batches', [BatchController::class, "list"])->name("batch.list");

//batches
Route::get('batch/create', [BatchController::class, "create"])->name("batch.create");
Route::post('batch/create', [BatchController::class, "store"])->name("batch.store");
Route::post('batch/start', [BatchController::class, "start"])->name("batch.start");
Route::get('batch/destroy/{id}', [BatchController::class, "destroy"])->name("batch.destroy");

//reports
Route::get('/report', [ReportController::class, "showReportWithId"])->name("reportWithId.show");
Route::get('/reports', [ReportController::class, "reportList"])->name("report.list");


