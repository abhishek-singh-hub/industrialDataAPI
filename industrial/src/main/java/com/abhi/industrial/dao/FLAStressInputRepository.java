package com.abhi.industrial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.abhi.industrial.model.FLAStressInput;



@EnableJpaRepositories
public interface FLAStressInputRepository extends JpaRepository<FLAStressInput, String>{

}
