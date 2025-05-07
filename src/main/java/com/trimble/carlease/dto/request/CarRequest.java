package com.trimble.carlease.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:21:03 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarRequest {

	@NotBlank(message = "Make is required")
	private String make;

	@NotBlank(message = "Model is required")
	private String model;

	@Min(value = 2000, message = "Year must be greater than 2000")
	private int year;

	@Min(value = 1, message = "Price per day must be greater than 0")
	private double pricePerDay;

	@NotBlank(message = "Car status is required")
	private String status;

	private PaginationFilterRequest pagination;

	private CarFilterRequest filter;
}
