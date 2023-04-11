package com.abhi.industrial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.abhi.industrial.model.FLAExecuScenarioInput;



@EnableJpaRepositories
public interface FLAExecuScenarioInputRepository extends JpaRepository<FLAExecuScenarioInput, String>{

}
