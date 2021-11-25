package org.example.BeerMachine.service;

import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.example.BeerMachine.BeerMachineCommunication.MachineConnection;
import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.example.BeerMachine.BeerMachineCommunication.Write;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.models.MachineState;
import org.example.BeerMachine.data.models.State;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineConnection machineConnection = new MachineConnection();
    private final Write write = new Write();
    private final Read read = new Read();
    private final MachineState machineState = BeerMachineController.getBeerMachineController().getMachineState();

    @Autowired
    BatchReportRepository batchReportRepository;
    @Autowired
    BatchRepository batchRepository;

    @Override
    public MessageResponse resetMachine() {
        write.reset();
        return new MessageResponse("Machine reset...");
    }
    @Override
    public MessageResponse startMachine(Integer batchId) {
        try {
            BatchReport batchReport = batchReportRepository.findById(batchId).get();
            //The subtraction of 1 from the type_id is used because of different indexing methods (0index!=1index)
            write.startBatch(batchReport.getSpeed(), batchReport.getType().getId()-1, batchReport.getAmount());
        } catch (Exception e) {
            System.out.println(e);
            return new MessageResponse("Machine didn't start...");
        }
        return new MessageResponse("Machine started...");
    }
    @Override
    public MessageResponse startQueue() {
        MessageResponse response = new MessageResponse("Queue didn't start...");
        /*try {
            ArrayList<Batch> batchQueue = new ArrayList<>(batchRepository.findOrderByQueueSpotAndQueueSpotNotNull());
            if (BeerMachineController.getBeerMachineController().getMachineState().getState() == State.IDLE) {
                while (batchQueue.size() > 0) {
                    Integer firstQueue = batchQueue.get(0).getId();
                    response = startMachine(firstQueue);
                    batchQueue.remove(0);
                }
            } else {
                response = new MessageResponse("Machine not in idle...");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = new MessageResponse("Queue failed...");
        }*/
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
    public float getBarley() {
        if (!machineState.getBarleySub().isAlive()) {
            machineState.getBarleySub().start();
        }
        return machineState.getBarleySub().getBarley();
    }
    @Override
    public float getHops() {
        if (!machineState.getHopsSub().isAlive()) {
            machineState.getHopsSub().start();
        }
        return machineState.getHopsSub().getHops();
    }
    @Override
    public float getMalt() {
        if (!machineState.getMaltSub().isAlive()) {
            machineState.getMaltSub().start();
        }
        return machineState.getMaltSub().getMalt();
    }
    @Override
    public float getWheat() {
        if (!machineState.getWheatSub().isAlive()) {
            machineState.getWheatSub().start();
        }
        return machineState.getWheatSub().getWheat();
    }
    @Override
    public float getYeast() {
        if (!machineState.getYeastSub().isAlive()) {
            machineState.getYeastSub().start();
        }
        return machineState.getYeastSub().getYeast();
    }
    @Override
    public float getHumidity() {
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
    public int getTotalCount() {
        if (!machineState.getTotalCountSub().isAlive()) {
            machineState.getTotalCountSub().start();
        }
        return machineState.getTotalCountSub().getTotalCount();
    }

    @Override
    public int getGoodCount() {
        if (!machineState.getGoodCountSub().isAlive()) {
            machineState.getGoodCountSub().start();
        }
        return machineState.getGoodCountSub().getGoodCount();
    }

    @Override
    public int getBadCount() {
        if (!machineState.getBadCountSub().isAlive()) {
            machineState.getBadCountSub().start();
        }
        return machineState.getBadCountSub().getBadCount();
    }




    @Override
    public MessageResponse setHost(String host) {
        machineConnection.setHost(host);
        return new MessageResponse("Host changed");
    }

    @Override
    public MessageResponse getHost(){
        return new MessageResponse("The host is: " + machineConnection.getHost());
    }


}
