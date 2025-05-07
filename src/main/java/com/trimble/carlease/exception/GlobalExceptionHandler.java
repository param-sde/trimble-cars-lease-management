package com.trimble.carlease.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trimble.carlease.dto.response.BaseResponse;
import com.trimble.carlease.exception.user.UserAlreadyExistsException;
import com.trimble.carlease.exception.user.UserLeaseLimitExceededException;
import com.trimble.carlease.exception.user.UserNotFoundException;
import com.trimble.carlease.utils.MessageUtils;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:28:51 AM
 * Since: 1.0.0
 * @See #
 */

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

	private final MessageUtils messageUtils;

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<BaseResponse<Void>> handleIllegalArgument(IllegalArgumentException ex) {
		log.warn("Invalid argument: {}", ex.getMessage());

		BaseResponse<Void> response = messageUtils.buildErrorResponse("TCLM002", HttpStatus.BAD_REQUEST,
				ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BaseResponse<Void>> handleMethodArgNotValid(MethodArgumentNotValidException ex) {
		String errorMsg = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.joining("; "));

		log.warn("Validation failed: {}", errorMsg);

		BaseResponse<Void> response = messageUtils.buildErrorResponse("TCLM004", HttpStatus.BAD_REQUEST, errorMsg);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<BaseResponse<Void>> handleConstraintViolation(ConstraintViolationException ex) {
		String errorMsg = ex.getConstraintViolations().stream().map(v -> v.getPropertyPath() + ": " + v.getMessage())
				.collect(Collectors.joining("; "));

		log.warn("Constraint violation: {}", errorMsg);

		BaseResponse<Void> response = messageUtils.buildErrorResponse("TCLM004", HttpStatus.BAD_REQUEST, errorMsg);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<BaseResponse<Void>> handleAll(Exception ex) {
		log.error("Unexpected error occurred", ex);

		BaseResponse<Void> response = messageUtils.buildErrorResponse("TCLM003", HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<BaseResponse<Void>> handleUserAlreadyExists(UserAlreadyExistsException ex) {
		log.warn("User already exists: {}", ex.getMessage());

		BaseResponse<Void> response = messageUtils.buildErrorResponse(ex.getCode(), HttpStatus.BAD_REQUEST,
				ex.getArgs());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<BaseResponse<Void>> handleUserNotFound(UserNotFoundException ex) {
		log.warn("User not found: {}", ex.getMessage());

		BaseResponse<Void> response = messageUtils.buildErrorResponse(ex.getCode(), HttpStatus.NOT_FOUND, ex.getArgs());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserLeaseLimitExceededException.class)
	public ResponseEntity<BaseResponse<Void>> handleUserLeaseLimitExceeded(UserLeaseLimitExceededException ex) {
		log.warn("User lease limit exceeded: {}", ex.getMessage());

		BaseResponse<Void> response = messageUtils.buildErrorResponse(ex.getCode(), HttpStatus.FORBIDDEN, ex.getArgs());
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}
}
