package org.example.BeerMachine.data.repository;

import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends JpaRepository<Humidity, Integer> {
}
