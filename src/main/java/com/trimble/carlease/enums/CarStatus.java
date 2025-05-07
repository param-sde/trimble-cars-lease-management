package com.trimble.carlease.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:27:17 AM
 * Since: 1.0.0
 * @See #
 */
public enum CarStatus {

	AVAILABLE("AVAILABLE"), LEASED("LEASED"), UNAVAILABLE("UNAVAILABLE");

	private final String value;

	CarStatus(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
