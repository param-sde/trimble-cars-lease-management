package com.trimble.carlease.dto.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:23:42 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Schema(description = "Response wrapper for User data")
public class UserResponse extends BaseResponse<UserResponse.UserBody> {

	@Getter
	@Setter
	@SuperBuilder
	@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
	@Schema(description = "User data response body")
	public static class UserBody {
		private Long id;
		private String fullName;
		private String email;
		private String phoneNo;
		private String role;

		private AddressDTO address;

		private List<UserBody> users;
	}

	@Getter
	@Setter
	@SuperBuilder
	@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
	@Schema(description = "User address data")
	public static class AddressDTO {
		private String line1;
		private String line2;
		private String city;
		private String state;
		private String country;
		private String postalCode;
	}
}
