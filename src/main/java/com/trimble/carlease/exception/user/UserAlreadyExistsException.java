package com.trimble.carlease.exception.user;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:28:51 AM
 * Since: 1.0.0
 * @See #
 */

public class UserAlreadyExistsException extends RuntimeException {
	private final String code;
	private final Object[] args;

	public UserAlreadyExistsException(String code, Object... args) {
		super(code);
		this.code = code;
		this.args = args;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}
}