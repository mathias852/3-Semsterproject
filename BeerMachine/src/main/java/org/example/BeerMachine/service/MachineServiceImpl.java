package org.example.BeerMachine.service;

import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.example.BeerMachine.BatchQueueComparator;
import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.example.BeerMachine.BeerMachineCommunication.Write;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.*;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.TimeStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MachineServiceImpl implements MachineService {
    @Autowired
    BatchReportRepository batchReportRepository;
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    TimeStateRepository timeStateRepository;

    private final Write write = new Write();
    private final Read read = new Read();
    private final MachineState machineState = BeerMachineController.getBeerMachineController().getMachineState();
    private final Map<String, Subscription> ingredients = machineState.getIngredients();
    private final String barley = "Barley", wheat = "Wheat", hops = "Hops", malt = "Malt", yeast = "Yeast";

    //Variables used for timeState
    boolean downTime = false;

    @Override
    public MessageResponse resetMachine() {
        write.reset();
        return new MessageResponse("Machine reset...");
    }
    @Override
    public MessageResponse startMachine(Integer batchId) {
        try {
            if(read.checkState() != 4) {
                write.reset();
            }
            BatchReport batchReport = batchReportRepository.findById(batchId).get();
            //The subtraction of 1 from the type_id is used because of different indexing methods (0index!=1index)
            write.startBatch(batchReport.getBatchId().floatValue(), batchReport.getSpeed(),
                    batchReport.getType().getId()-1, batchReport.getAmount());
            batchReport.setStartTime(Date.from(Instant.now()));
            batchReportRepository.save(batchReport);

            //Saves the current batch and related data in th beer machine controller
            BeerMachineController.getBeerMachineController().setProductionBatch(batchId, batchReport.getAmount(),
                    batchReport.getSpeed(), batchReport.getType());
            //Saves the current batchReport to the beer machine controller
            BeerMachineController.getBeerMachineController().setCurrentBatchReport(batchReport);
        } catch (Exception e) {
            System.out.println(e);
            return new MessageResponse("Machine didn't start...");
        }
        return new MessageResponse("Machine started...");
    }
    @Override
    public MessageResponse startQueue() {
        MessageResponse response = new MessageResponse("Queue didn't start...");
        try {
            ArrayList<Batch> batchQueue = new ArrayList<>(batchRepository.findAll());
            batchQueue.forEach( (batch -> {if(batch.getQueueSpot() == null) {batchQueue.remove(batch);}}));
            BatchQueueComparator myBatchQueueComparator = new BatchQueueComparator();
            batchQueue.sort(myBatchQueueComparator);
            if (machineState.getStateSub().getMachineState() == State.IDLE.getId()) {
                while (batchQueue.size() > 0) {
                    if (machineState.getStateSub().getMachineState() == State.IDLE.getId()) {
                        Integer firstQueue = batchQueue.get(0).getId();
                        response = startMachine(firstQueue);
                        batchQueue.remove(0);
                    }
                }
            } else {
                response = new MessageResponse("Machine not in idle...");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = new MessageResponse("Queue failed...");
        }
        return response;
    }

    @Override
    public MessageResponse stopMachine() {
        write.stop();
        return new MessageResponse("Machine stopped...");
    }
    @Override
    public MessageResponse abortMachine() {
        write.abort();
        return new MessageResponse("Machine aborted...");
    }
    @Override
    public MessageResponse clearMachine() {
        write.clear();
        return new MessageResponse("Machine cleared...");
    }
    @Override
    public MessageResponse getState() {
        int message = read.checkState();
        System.out.println(message);
        return new MessageResponse("Machine state: " + message);
    }

    @Override
    public float getAmountToProduce() {
        return read.getAmountToProduce();
    }

    @Override
    public float getBatchId() {
        return read.getBatchId();
    }

    @Override
    public float getSpeed() {
        return read.getSpeed();
    }

    @Override
    public float getBarley() {
        if (!ingredients.get(barley).isAlive()) {
            ingredients.get(barley).start();
        }
        return ingredients.get(barley).getBarley();
    }
    @Override
    public float getHops() {
        if (!ingredients.get(hops).isAlive()) {
            ingredients.get(hops).start();
        }
        return ingredients.get(hops).getHops();
    }
    @Override
    public float getMalt() {
        if (!ingredients.get(malt).isAlive()) {
            ingredients.get(malt).start();
        }
        return ingredients.get(malt).getMalt();
    }
    @Override
    public float getWheat() {
        if (!ingredients.get(wheat).isAlive()) {
            ingredients.get(wheat).start();
        }
        return ingredients.get(wheat).getWheat();
    }
    @Override
    public float getYeast() {
        if (!ingredients.get(yeast).isAlive()) {
            ingredients.get(yeast).start();
        }
        return ingredients.get(yeast).getYeast();
    }
    @Override
    public Short getHumidity() {
        if (!machineState.getHumiditySub().isAlive()) {
            machineState.getHumiditySub().start();
        }
        return machineState.getHumiditySub().getHumidity();
    }
    @Override
    public float getTemperature() {
        if (!machineState.getTemperatureSub().isAlive()) {
            machineState.getTemperatureSub().start();
        }
        return machineState.getTemperatureSub().getTemperature();
    }
    @Override
    public float getVibrations() {
        if (!machineState.getVibrationSub().isAlive()) {
            machineState.getVibrationSub().start();
        }
        return machineState.getVibrationSub().getVibrations();
    }
    @Override
    public int getStopReason() {
        if (!machineState.getStopReasonSub().isAlive()) {
            machineState.getStopReasonSub().start();
        }
        return machineState.getStopReasonSub().getStopReason();
    }

    @Override
    public UShort getTotalCount() {
        if (!machineState.getTotalCountSub().isAlive()) {
            machineState.getTotalCountSub().start();
        }
        return machineState.getTotalCountSub().getTotalCount();
    }

    @Override
    public UShort getGoodCount() {
        if (!machineState.getGoodCountSub().isAlive()) {
            machineState.getGoodCountSub().start();
        }
        return machineState.getGoodCountSub().getGoodCount();
    }

    @Override
    public UShort getBadCount() {
        if (!machineState.getBadCountSub().isAlive()) {
            machineState.getBadCountSub().start();
        }
        return machineState.getBadCountSub().getBadCount();
    }

    @Override
    public UShort getMaintenanceCount() {
        if (!machineState.getMaintenanceSub().isAlive()) {
            machineState.getMaintenanceSub().start();
        }
        return machineState.getMaintenanceSub().getMaintenance();
    }

    @Override
    public int getCurrentState() {
        if (!machineState.getStateSub().isAlive()) {
            machineState.getStateSub().start();
        }
        if(machineState.getStateSub().getMachineState() == 11 && !downTime) {
            downTime = true;
            TimeState timeState = new TimeState();
            timeState.setStartTime(Date.from(Instant.now()));
            timeState.setStopReason(read.checksStopState());
            timeState.setStateId(read.checkState());
            timeState.setBatchReport(BeerMachineController.getBeerMachineController().getBatchReport());
            BeerMachineController.getBeerMachineController().setCurrentTimeState(timeState.getBatchReport(), timeState.getStateId(),
                    timeState.getStopReason(), timeState.getStartTime());
        }
        if(machineState.getStateSub().getMachineState() == 6 && downTime) {
            if(BeerMachineController.getBeerMachineController().getTimeState() != null) {
                BeerMachineController.getBeerMachineController().getTimeState().setEndTime(Date.from(Instant.now()));
                timeStateRepository.save(BeerMachineController.getBeerMachineController().getTimeState());
                downTime = false;
            }
        }
        if (machineState.getStateSub().getMachineState() == 17) {
            BatchReport batchReport = batchReportRepository.findById(BeerMachineController.getBeerMachineController().getBatchReport().getBatchId()).get();
            updateBatchReport(batchReport);
            write.reset();
        }
        return machineState.getStateSub().getMachineState();
    }

    @Override
    public void updateBatchReport(BatchReport batchReport){
        if(!batchReport.isUpdated()) {
            //Used for down time
            List<TimeState> timeStates = null;
            if(timeStateRepository != null) {
                 timeStates = timeStateRepository.findAll();
            }

            Date endTime = Date.from(Instant.now());
            int goodCount = batchReport.getAmount() - read.getDefectiveCount();
            double planedProductionTime = endTime.getTime() - batchReport.getStartTime().getTime();
            double downTime = 0;

            double availability;
            double performance;
            double quality;

            assert timeStates != null;
            for (TimeState timeState : timeStates) {
                if (timeState.getBatchReport().getBatchId().equals(BeerMachineController.getBeerMachineController().getBatchReport().getBatchId())) {
                    downTime += timeState.getEndTime().getTime() - timeState.getStartTime().getTime();
                }
            }

            //Everything OEE-related
            availability = BeerMachineController.getBeerMachineController().getAvailability(
                    downTime, planedProductionTime);
            performance = BeerMachineController.getBeerMachineController().getPerformance(
                    batchReport.getType().getIdealCycleTime(), read.getTotalAmountProduced(),
                    batchReport.getSpeed(), batchReport.getAmount());
            quality = BeerMachineController.getBeerMachineController().getQuality(
                    goodCount, read.getTotalAmountProduced());

            batchReport.setAvailability(availability);
            batchReport.setPerformance(performance);
            batchReport.setQuality(quality);

            batchReport.setOEE(BeerMachineController.getBeerMachineController().calculateOEE(
                    availability, performance, quality));

            batchReport.setGoodCount(goodCount);
            batchReport.setRejectedCount(read.getDefectiveCount());
            batchReport.setTotalCount(read.getTotalAmountProduced());
            batchReport.setEndTime(endTime);
            batchReport.setUpdated(true);
            batchReportRepository.save(batchReport);
            System.out.println("Batch-report with the batchId: " + batchReport.getBatchId() + " has been updated");
        }
        System.out.println("Sorry, but the batchReport has all ready been updated. You cannot update it anymore");
    }
}
