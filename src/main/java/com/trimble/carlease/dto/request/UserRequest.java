package com.trimble.carlease.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:21:29 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

	@NotBlank(message = "Full name is required")
	private String fullName;

	@NotBlank(message = "Phone number is required")
	private String phoneNo;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Role is required")
	private String role;

	private AddressRequest address;

	private PaginationFilterRequest pagination;

	private UserFilterRequest filter;
}
