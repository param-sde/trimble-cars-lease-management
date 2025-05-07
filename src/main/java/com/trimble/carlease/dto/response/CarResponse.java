package com.trimble.carlease.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:23:06 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "Response wrapper for Car data")
public class CarResponse extends BaseResponse<CarResponse.CarBody> {

	@Getter
	@Setter
	@SuperBuilder
	@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
	@Schema(description = "Car data response body")
	public static class CarBody {
		private Long id;
		private String make;
		private String model;
		private int year;
		private double pricePerDay;
		private String status;
		private String ownerName;
	}
}
