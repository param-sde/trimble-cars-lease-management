package com.trimble.carlease.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:28:10 AM
 * Since: 1.0.0
 * @See #
 */
public enum Role {

	ADMIN("ADMIN"), OWNER("OWNER"), CUSTOMER("CUSTOMER");

	private final String value;

	Role(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
