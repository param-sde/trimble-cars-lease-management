package com.trimble.carlease.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:21:46 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarFilterRequest {

	private String make;
	private String model;
	private String status;
	private Integer year;
	private Double pricePerDayMin;
	private Double pricePerDayMax;
}
