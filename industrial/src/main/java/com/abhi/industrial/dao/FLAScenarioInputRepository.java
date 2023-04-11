package com.abhi.industrial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.abhi.industrial.model.FLAScenarioInput;


@EnableJpaRepositories
public interface FLAScenarioInputRepository extends JpaRepository<FLAScenarioInput, String>{

}
