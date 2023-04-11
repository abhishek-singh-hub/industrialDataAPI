package com.abhi.industrial.bo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.industrial.dao.ScenarioInputDao;
import com.abhi.industrial.model.FLAExecuScenarioInput;
import com.abhi.industrial.model.FLAScenarioInput;
import com.abhi.industrial.model.FLAStressInput;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScenarionInputBoImpl implements ScenarioInputBo {

	@Autowired
	private ScenarioInputDao scenarioInputDao;

	@Override
	public FLAScenarioInput getScenarioValues(String scenarioId) {
		log.info("ScenarionInputBoImpl :: getScenarioValues()");

		return scenarioInputDao.getScenarioValues(scenarioId);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional
	public JSONObject insertScenarioValuesInDb(JSONObject userInput) {
		log.info("ScenarionInputBoImpl :: insertScenarioValuesInDb()");
		JSONObject responseObj = new JSONObject();
		if(validateScenarioInput(userInput)) {
			String stressScenarioFlag = (String) userInput.get("stressScenarioFlag");
			String scenarioId = userInput.get("scenarioId").toString();
			
			FLAScenarioInput flaScenarioInput = new FLAScenarioInput();
			flaScenarioInput.setScenarioId(scenarioId);
			flaScenarioInput.setStressScenarioFlag(stressScenarioFlag.charAt(0));
			flaScenarioInput.setForecastMevPeriod(Float.valueOf(userInput.get("forecastMevPeriod").toString()).floatValue());
			flaScenarioInput.setLatestIndicator(userInput.get("latestIndicator").toString().charAt(0));
			flaScenarioInput.setMisDate(new Date(userInput.get("misDate").toString()));
			flaScenarioInput.setProjectedPeriod(Float.valueOf(userInput.get("projectedPeriod").toString()).floatValue());
			flaScenarioInput.setScenarioExecutionId(userInput.get("scenarioExecutionId").toString());
			flaScenarioInput.setZIndustry(userInput.get("zIndustry").toString());
			flaScenarioInput.setZRegion(userInput.get("zRegion").toString());
			
			scenarioInputDao.saveFLAScenarioInput(flaScenarioInput);
			
			
			if(stressScenarioFlag.equalsIgnoreCase("Y")) {
				
				FLAStressInput flaStressInput = new FLAStressInput();
				flaStressInput.setScenarioId(scenarioId);
				flaStressInput.setMevShockedValue(Float.valueOf(userInput.get("mevShockedValue").toString()).floatValue());
				flaStressInput.setMevSourceSkey(userInput.get("mevSourceSkey").toString());
				flaStressInput.setPosition(userInput.get("position").toString());
				flaStressInput.setSdShockedInput(userInput.get("sdShockedInput").toString());
				
				scenarioInputDao.saveFLAStressInput(flaStressInput);
				
			} else {

				FLAExecuScenarioInput flaExecuScenarioInput = new FLAExecuScenarioInput();
				flaExecuScenarioInput.setScenarioId(scenarioId);
				flaExecuScenarioInput.setBase(Float.valueOf(userInput.get("base").toString()).floatValue());
				flaExecuScenarioInput.setDownside(Float.valueOf(userInput.get("downSide").toString()).floatValue());
				flaExecuScenarioInput.setUpside(Float.valueOf(userInput.get("upSide").toString()).floatValue());
				
				scenarioInputDao.saveFLAExecuScenarioInput(flaExecuScenarioInput);
				
			} 
		} else {
			String[] mandatoryFieldsArray = {"scenarioId","misDate","latestIndicator","scenarioExecutionId","stressScenarioFlag","forecastMevPeriod","projectedPeriod"};
			
			responseObj.put("error", "mandatory field missing.Mandatory Fields are ["+Arrays.toString(mandatoryFieldsArray)+"]");
			return responseObj;
		}
		
		responseObj.put("msg", "success");
		
		return responseObj;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean validateScenarioInput(JSONObject userInput) {
		log.info("ScenarionInputBoImpl :: validateScenarioInput()");
		
		String[] mandatoryFields = {"scenarioId","misDate","latestIndicator","scenarioExecutionId","stressScenarioFlag","forecastMevPeriod","projectedPeriod"};
		List<String> mandatoryFieldList = Arrays.asList(mandatoryFields);
		if( userInput.keySet().containsAll(mandatoryFieldList) ) 
			 return true;
		else
			return false;
	}

}
