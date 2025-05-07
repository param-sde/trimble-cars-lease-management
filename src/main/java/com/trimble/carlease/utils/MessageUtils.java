package com.trimble.carlease.utils;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.trimble.carlease.dto.response.BaseResponse;

import lombok.RequiredArgsConstructor;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:34:14 AM
 * Since: 1.0.0
 * @See #
 */

@Component
@RequiredArgsConstructor
public class MessageUtils {

	private final MessageSource messageSource;

	public String getMessage(String code, Object... args) {
		return messageSource.getMessage(code, args, Locale.getDefault());
	}

	public <T> BaseResponse<T> buildSuccessResponse(String code, T data) {
		return buildResponse(code, HttpStatus.OK, true, data);
	}

	public <T> BaseResponse<T> buildErrorResponse(String code, HttpStatus status, Object... args) {
		return buildResponse(code, status, false, null, args);
	}

	private <T> BaseResponse<T> buildResponse(String code, HttpStatus status, boolean success, T data, Object... args) {
		return BaseResponse.<T>builder().success(success).status(status.name()).statusCode(status.value())
				.message(getMessage(code, args)).timestamp(LocalDateTime.now()).data(data).build();
	}
}
