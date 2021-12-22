package org.example.BeerMachine;

import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.service.BatchService;
import org.example.BeerMachine.service.QueueService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BatchServiceTest {

    @Autowired
    private BatchRepository batchRepository;


    @Autowired
    private BatchService batchService;

    @Autowired
    private BatchReportRepository batchReportRepository;

    @Autowired
    private QueueService queueService;

    BatchRequest batchRequest;
    List<Integer> ids = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        batchRequest = new BatchRequest();
        batchRequest.setAmount(100);
        batchRequest.setSpeed(100);
        batchRequest.setType(1);
    }

    @Test
    void givenBatchRequestShouldAddBatchToRepository(){
        long count = batchRepository.count();
        batchRepository.findAll().forEach((n) -> ids.add(n.getId()));
        MessageResponse msg = batchService.createBatch(batchRequest);
        assertThat(msg.getMessage()).isEqualTo("New Batch created successfully with a corresponding batch report");
        assertThat(batchRepository.count()).isEqualTo(count+1);
    }
    @Test
    void assertThatBatchIdIsUnique() {
        assertThat(queueService.getQueue().get(queueService.getQueue().size() - 1).getId()).isNotIn(ids);
    }

    @Test
    void assertThatBatchReportIsCreated() {
        assertThat(batchReportRepository.findById(queueService.getQueue().get(queueService.getQueue().size() - 1).getId())).isNotNull();
    }

    @AfterEach
    public void tearDown() {
        batchRequest = null;
    }
}