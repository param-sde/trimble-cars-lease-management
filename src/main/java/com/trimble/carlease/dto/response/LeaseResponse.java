package com.trimble.carlease.dto.response;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:23:14 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "Response wrapper for Lease data")
public class LeaseResponse extends BaseResponse<LeaseResponse.LeaseBody> {

	@Getter
	@Setter
	@SuperBuilder
	@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
	@Schema(description = "Lease data response body")
	public static class LeaseBody {
		private Long id;
		private LocalDate startDate;
		private LocalDate endDate;
		private String status;

		private CarSummary car;
		private UserSummary customer;
	}

	@Getter
	@Setter
	@SuperBuilder
	@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
	@Schema(description = "Car summary for Lease response")
	public static class CarSummary {
		private Long id;
		private String make;
		private String model;
	}

	@Getter
	@Setter
	@SuperBuilder
	@NoArgsConstructor
	@AllArgsConstructor
	@Schema(description = "Customer summary for Lease response")
	public static class UserSummary {
		private Long id;
		private String fullName;
		private String email;
	}
}
