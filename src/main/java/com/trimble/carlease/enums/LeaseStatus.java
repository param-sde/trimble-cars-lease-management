package com.trimble.carlease.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:27:50 AM
 * Since: 1.0.0
 * @See #
 */
public enum LeaseStatus {

	ACTIVE("ACTIVE"), ENDED("ENDED"), CANCELLED("CANCELLED");

	private final String value;

	LeaseStatus(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
