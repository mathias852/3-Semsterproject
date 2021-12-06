<?php

declare(strict_types=1);

namespace App\Charts;

use ConsoleTVs\Charts\BaseChart;
use Illuminate\Http\Request;
use Chartisan\PHP\Chartisan;

class PilsnerChart extends BaseChart
{
    /**
     * Handles the HTTP request for the given chart.
     * It must always return an instance of Chartisan
     * and never a string or an array.
     */
    public function handler(Request $request): Chartisan
    {
        return Chartisan::build()
            ->labels([30, 60, 90, 120, 150, 180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 600])
            ->dataset('Type 0', [30.00, 60.00, 89.40, 120.00, 148.00, 178.80, 208.60, 236.80, 268.20, 290.00, 312.40, 350.40, 366.60, 389.20, 402.00, 403.20, 374.00, 342.00, 288.00]);
    }


}
