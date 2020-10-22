package com.arquitectura.tp.tpfinalgrupo7.repository;

import com.arquitectura.tp.tpfinalgrupo7.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
