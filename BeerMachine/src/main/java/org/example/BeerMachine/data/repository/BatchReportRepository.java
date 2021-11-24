package org.example.BeerMachine.data.repository;

import org.example.BeerMachine.data.models.BatchReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchReportRepository extends JpaRepository<BatchReport, Integer> {
}
