package com.abhi.industrial.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="FLA_Scenario_Input")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FLAScenarioInput implements Serializable {

	private static final long serialVersionUID = -238833314069941134L;
	@Id
	@Column(name = "V_SCENARIO_ID")
	private String scenarioId;//m
	@Column(name = "D_MIS_DATE")
	private Date misDate;//m
	@Column(name = "F_LATEST_RECORD")
	private char latestIndicator;//m
	@Column(name = "V_SCENARIO_EXECUTION_ID")
	private String scenarioExecutionId;//m
	@Column(name = "V_Z_REGION")
	private String zRegion;
	@Column(name = "V_Z_INDUSTRY")
	private String zIndustry;
	@Column(name = "V_STRESS_SCENARIO_FLAG")
	private char stressScenarioFlag;//m
	@Column(name = "N_FORECAST_MEV_PERIOD")
	private Number forecastMevPeriod;//m
	@Column(name = "N_PROJECTED_PERIOD")
	private Number projectedPeriod;//m
	
}
