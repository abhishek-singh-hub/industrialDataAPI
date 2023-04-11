package com.abhi.industrial.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="FLA_Execu_Scenario_Input")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FLAExecuScenarioInput implements Serializable {
	
	private static final long serialVersionUID = 6750554253430373820L;
	@Id
	@Column(name="V_SCENARIO_ID")
	private String scenarioId;
	@Column(name="N_BASE")
	private Number base;
	@Column(name="N_UPSIDE")
	private Number upside;
	@Column(name="N_DOWNSIDE")
	private Number downside;

}
