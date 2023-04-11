package com.abhi.industrial.bo;

import org.json.simple.JSONObject;

import com.abhi.industrial.model.FLAScenarioInput;

public interface ScenarioInputBo {

	//public FLAScenarioInput insertScenarioValuesInDb(FLAScenarioInput userInput);

	public FLAScenarioInput getScenarioValues(String scenarioId);

	public JSONObject insertScenarioValuesInDb(JSONObject userInput);

}
