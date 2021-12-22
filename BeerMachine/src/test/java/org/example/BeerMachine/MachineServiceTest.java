package org.example.BeerMachine;

import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.service.BatchService;
import org.example.BeerMachine.service.MachineService;
import org.example.BeerMachine.service.QueueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MachineServiceTest {

    private MessageResponse response;
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private BatchService batchService;

    @Autowired
    private BatchReportRepository batchReportRepository;

    @Autowired
    private QueueService queueService;

    @Autowired
    private MachineService machineService;

    BatchRequest batchRequest;

    @BeforeEach
    public void start() {
        response = machineService.startMachine(queueService.getQueue().get(queueService.getQueue().size() - 1).getId());
    }

    @BeforeEach
    public void setUp() {
        batchRequest = new BatchRequest();
        batchRequest.setAmount(100);
        batchRequest.setSpeed(1);
        batchRequest.setType(1);
        batchService.createBatch(batchRequest);
    }

    @Test
    void assertThatStartMachineReturnsOk() {
        assertThat(response.getMessage()).isEqualTo("Machine started...");
    }
    @Test
    void assertThatMachineStateChanged() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        assertThat(BeerMachineController.getBeerMachineController().getMachineState().getStateSub().getMachineState()).isEqualTo(6);
    }

}