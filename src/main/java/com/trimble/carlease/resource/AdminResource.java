package com.trimble.carlease.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.BaseResponse;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 11:45:32 AM
 * Since: 1.0.0
 * @See #
 */

@Tag(name = "Admin APIs", description = "APIs for admin to manage users, cars, and leases")
@Validated
@RequestMapping("/api/v1/admin")
public interface AdminResource {

	@Operation(summary = "View all cars", responses = {
			@ApiResponse(responseCode = "200", description = "Cars retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/cars")
	ResponseEntity<CarResponse> getAllCars(@RequestBody CarRequest carRequest);

	@Operation(summary = "View all users", responses = {
			@ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/users")
	ResponseEntity<UserResponse> getAllUsers(@RequestBody UserRequest userRequest);

	@Operation(summary = "View all leases", responses = {
			@ApiResponse(responseCode = "200", description = "Leases retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/leases")
	ResponseEntity<LeaseResponse> getAllLeases(@RequestBody LeaseRequest leaseRequest);

	@Operation(summary = "Update car details", responses = {
			@ApiResponse(responseCode = "200", description = "Car updated successfully"),
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PutMapping("/cars/{id}")
	ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @Valid @RequestBody CarRequest carRequest);

	@Operation(summary = "Remove a car", responses = {
			@ApiResponse(responseCode = "204", description = "Car deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@DeleteMapping("/cars/{id}")
	ResponseEntity<BaseResponse<String>> deleteCar(@PathVariable Long id);

	@Operation(summary = "Remove a user", responses = {
			@ApiResponse(responseCode = "204", description = "User deleted successfully"),
			@ApiResponse(responseCode = "404", description = "User not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@DeleteMapping("/users/{id}")
	ResponseEntity<BaseResponse<String>> deleteUser(@PathVariable Long id);
}