package com.abhi.industrial.dao;

import com.abhi.industrial.model.FLAExecuScenarioInput;
import com.abhi.industrial.model.FLAScenarioInput;
import com.abhi.industrial.model.FLAStressInput;

public interface ScenarioInputDao {

	public FLAScenarioInput saveFLAScenarioInput(FLAScenarioInput userInput);

	public FLAScenarioInput getScenarioValues(String scenarioId);

	public FLAStressInput saveFLAStressInput(FLAStressInput flaStressInput);

	public FLAExecuScenarioInput saveFLAExecuScenarioInput(FLAExecuScenarioInput flaExecuScenarioInput);

}
