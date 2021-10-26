package org.example.BeerMachine.data.repository;

import org.example.BeerMachine.data.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
}
