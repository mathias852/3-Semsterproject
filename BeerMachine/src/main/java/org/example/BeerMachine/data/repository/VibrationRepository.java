package org.example.BeerMachine.data.repository;

import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.models.Vibration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VibrationRepository extends JpaRepository<Vibration, Integer> {
}
