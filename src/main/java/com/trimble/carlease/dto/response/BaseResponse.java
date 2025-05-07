package com.trimble.carlease.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:23:06 AM
 * Since: 1.0.0
 * @See #
 */

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BaseResponse<T> {

	private boolean success;
	private String status;
	private int statusCode;
	private String message;
	private LocalDateTime timestamp;
	private T data;

}
