package org.example.BeerMachine.service;

import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.example.BeerMachine.BeerMachineCommunication.MachineConnection;
import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.example.BeerMachine.BeerMachineCommunication.Write;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
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
    private MachineConnection machineConnection = new MachineConnection();
    private Write write = new Write();
    private Read read = new Read();

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
        return BeerMachineController.getBeerMachineController().getMachineState().getBarleySub().getBarley();
    }
    @Override
    public float getHops() {
        return BeerMachineController.getBeerMachineController().getMachineState().getHopsSub().getHops();
    }
    @Override
    public float getMalt() {
        return BeerMachineController.getBeerMachineController().getMachineState().getMaltSub().getMalt();
    }
    @Override
    public float getWheat() {
        return BeerMachineController.getBeerMachineController().getMachineState().getWheatSub().getWheat();
    }
    @Override
    public float getYeast() {
        return BeerMachineController.getBeerMachineController().getMachineState().getYeastSub().getYeast();
    }
    @Override
    public float getHumidity() {
        return BeerMachineController.getBeerMachineController().getMachineState().getHumiditySub().getHumidity();
    }
    @Override
    public float getTemperature() {
        return BeerMachineController.getBeerMachineController().getMachineState().getTemperatureSub().getTemperature();
    }
    @Override
    public float getVibrations() {
        return BeerMachineController.getBeerMachineController().getMachineState().getVibrationSub().getVibrations();
    }
    @Override
    public int getStopReason() {
        return BeerMachineController.getBeerMachineController().getMachineState().getStopReasonSub().getStopReason();
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
