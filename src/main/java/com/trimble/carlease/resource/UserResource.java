package com.trimble.carlease.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.BaseResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 11:45:32 AM
 * Since: 1.0.0
 * @See #
 */

@Tag(name = "User APIs", description = "APIs for managing user profiles, registration, and leases")
@Validated
@RequestMapping("/api/v1/users")
public interface UserResource {

	@Operation(summary = "Register a new user", responses = {
			@ApiResponse(responseCode = "200", description = "User registered successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@PostMapping("/")
	ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest);

	@Operation(summary = "Get user profile by ID", responses = {
			@ApiResponse(responseCode = "200", description = "User profile retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@GetMapping("/{id}")
	ResponseEntity<UserResponse> getUserProfile(@PathVariable Long id);

	@Operation(summary = "Get all users with pagination", responses = {
			@ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@GetMapping("/")
	ResponseEntity<UserResponse> getAllUsers(@RequestBody UserRequest userRequest);

	@Operation(summary = "Get user's lease history", responses = {
			@ApiResponse(responseCode = "200", description = "User's lease history retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@GetMapping("/{id}/leases")
	ResponseEntity<LeaseResponse> getUserLeaseHistory(@PathVariable Long id);

	@Operation(summary = "Update user profile", responses = {
			@ApiResponse(responseCode = "200", description = "User updated successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@PutMapping("/{id}")
	ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest);

	@Operation(summary = "Delete a user by ID", responses = {
			@ApiResponse(responseCode = "200", description = "User deleted successfully"),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@DeleteMapping("/{id}")
	ResponseEntity<BaseResponse<String>> deleteUser(@PathVariable Long id);
}