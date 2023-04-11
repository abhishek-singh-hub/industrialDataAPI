package com.abhi.industrial.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.industrial.bo.ScenarioInputBo;
import com.abhi.industrial.model.FLAScenarioInput;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/baseurl")
@Slf4j
public class ScenarioInputController {
	
	@Autowired
	private ScenarioInputBo scenarioInputBo;
	
	@RequestMapping("/isServiceUP")
	public String isServiceUp() {
		log.info("ScenarioInputController :: isServiceUp()");
		return "Service is up";
	}
	
	
	@RequestMapping(value= "/inputscenraio", method=RequestMethod.POST)
	public ResponseEntity<Object> inputScenraioValues(@RequestBody JSONObject userInput) {
		log.info("ScenarioInputController :: inputScenraio()");
		JSONObject jobject = null;
		try {
			jobject = scenarioInputBo.insertScenarioValuesInDb(userInput);
		} catch (Exception e) {
			e.printStackTrace();
			return new  ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		return new  ResponseEntity<>(jobject, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/inputscenraio", method=RequestMethod.GET)
	public ResponseEntity<Object> inputScenraio(@RequestParam String scenarioId) {
		log.info("ScenarioInputController :: inputScenraio()");
		FLAScenarioInput fla = null;
		try {
			fla = scenarioInputBo.getScenarioValues(scenarioId);
		} catch (Exception e) {
			e.printStackTrace();
			return new  ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		return new  ResponseEntity<>(fla, HttpStatus.OK);
	}

	
	/*
	 * @RequestMapping(value= "/inputscenraio", method=RequestMethod.POST) public
	 * ResponseEntity<Object> inputScenraio(@RequestBody FLAScenarioInput userInput)
	 * { log.info("ScenarioInputController :: inputScenraio()"); FLAScenarioInput
	 * fla = null; try { fla = scenarioInputBo.insertScenarioValuesInDb(userInput);
	 * } catch (Exception e) { e.printStackTrace(); return new
	 * ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED); } return new
	 * ResponseEntity<>(fla, HttpStatus.OK); }
	 */
	
}
