package com.abhi.industrial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhi.industrial.model.FLAExecuScenarioInput;
import com.abhi.industrial.model.FLAScenarioInput;
import com.abhi.industrial.model.FLAStressInput;
import com.abhi.industrial.util.DatabaseHelperUtil;

import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class ScenarioInputDaoImpl implements ScenarioInputDao {

	@Autowired
	private DatabaseHelperUtil databaseHelperUtil;
	
	@Autowired
	private FLAScenarioInputRepository flaScenarioInputRepository;

	@Autowired
	private FLAExecuScenarioInputRepository flaExecuScenarioInputRepository;

	@Autowired
	private FLAStressInputRepository flaStressInputRepository;
	
	
	@Override
	public FLAScenarioInput saveFLAScenarioInput(FLAScenarioInput flaScenarioInput) {
		log.info("ScenarioInputDaoImpl :: saveFLAScenarioInput()");
	
		return flaScenarioInputRepository.save(flaScenarioInput);
	}

	@Override
	public FLAStressInput saveFLAStressInput(FLAStressInput flaStressInput) {
		log.info("ScenarioInputDaoImpl :: saveFLAStressInput()");
	
		return flaStressInputRepository.save(flaStressInput);
	}
	
	@Override
	public FLAExecuScenarioInput saveFLAExecuScenarioInput(FLAExecuScenarioInput flaExecuScenarioInput) {
		log.info("ScenarioInputDaoImpl :: saveFLAExecuScenarioInput()");
	
		return flaExecuScenarioInputRepository.save(flaExecuScenarioInput);
	}
	
	@Override
	public FLAScenarioInput getScenarioValues(String scenarioId) {
		log.info("ScenarioInputDaoImpl :: getScenarioValues()");
		String queryString = "From FLAScenarioInput where scenarioId=:scenarioId";
		Query qr = databaseHelperUtil.getSession().createQuery(queryString);
		qr.setParameter("scenarioId", scenarioId);
		
		return (FLAScenarioInput) qr.getSingleResult();
	}

}
