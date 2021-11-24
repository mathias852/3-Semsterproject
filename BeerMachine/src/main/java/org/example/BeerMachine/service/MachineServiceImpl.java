package org.example.BeerMachine.service;

import org.example.BeerMachine.BeerMachineCommunication.MachineConnection;
import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.example.BeerMachine.BeerMachineCommunication.Write;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.eclipse.milo.opcua.stack.core.types.enumerated.OpenFileMode.Write;

@Service
public class MachineServiceImpl implements MachineService {
    private MachineConnection machineConnection = new MachineConnection();
    private Write write = new Write();
    private Read read = new Read();
    private Subscription subscription = new Subscription();
    Subscription.GetBarley getBarley = new Subscription.GetBarley();
    Subscription.GetWheat getWheat = new Subscription.GetWheat();


    @Autowired
    BatchReportRepository batchReportRepository;

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
            getBarley.start();
            getWheat.start();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return new MessageResponse("Machine started...");
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
    public MessageResponse setHost(String host) {
        machineConnection.setHost(host);
        return new MessageResponse("Host changed");
    }

    @Override
    public MessageResponse getHost(){
        return new MessageResponse("The host is: " + machineConnection.getHost());
    }


}
