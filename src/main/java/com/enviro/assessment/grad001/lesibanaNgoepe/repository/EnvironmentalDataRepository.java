package com.enviro.assessment.grad001.lesibanaNgoepe.repository;

import com.enviro.assessment.grad001.lesibanaNgoepe.entity.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentalDataRepository extends JpaRepository<EnvironmentalData,Integer> {
}
