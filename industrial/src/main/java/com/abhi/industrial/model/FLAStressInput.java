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
@Table(name="FLA_Stress_Input")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FLAStressInput implements Serializable {

	private static final long serialVersionUID = 648674774675215176L;
	@Id
	@Column(name="V_SCENARIO_ID")
	private String scenarioId;
	@Column(name="V_POSITION")
	private String position;
	@Column(name="N_MEV_SOURCE_SKEY")
	private String mevSourceSkey;
	@Column(name="V_SD_SHOCKED_INPUT")
	private String sdShockedInput;
	@Column(name="N_MEV_SHOCKED_VALUE")
	private Number mevShockedValue;
	
}
