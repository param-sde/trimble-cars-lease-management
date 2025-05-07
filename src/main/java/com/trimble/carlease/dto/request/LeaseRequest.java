package com.trimble.carlease.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:21:14 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaseRequest {

	@NotNull(message = "Car ID is required")
	private Long carId;

	@NotNull(message = "Customer ID is required")
	private Long customerId;

	@NotNull(message = "Start date is required")
	private LocalDate startDate;

	private LocalDate endDate;

	private LeaseFilterRequest filter;
}
