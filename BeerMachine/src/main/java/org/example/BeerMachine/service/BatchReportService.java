package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.payloads.request.BatchReportRequest;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Component
public interface BatchReportService {
    MessageResponse createBatchReport(BatchReportRequest batchReportRequest);

    void deleteBatchReport(Integer batchReportId);

    BatchReport getBatchReport(Integer batchReportId);

    List<BatchReport> getAllBatchReports();
}
