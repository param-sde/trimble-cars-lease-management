package com.trimble.carlease.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:24:49 AM
 * Since: 1.0.0
 * @See #
 */

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {

	private String line1;
	private String line2;
	private String city;
	private String state;
	private String country;
	private String postalCode;

}
