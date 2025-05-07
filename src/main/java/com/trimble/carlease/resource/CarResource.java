package com.trimble.carlease.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;

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

@Tag(name = "Car APIs", description = "APIs for car owners to manage their cars and view lease history")
@Validated
@RequestMapping("/api/v1/cars")
public interface CarResource {

	@Operation(summary = "Register a new car", responses = {
			@ApiResponse(responseCode = "200", description = "Car registered successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping("/")
	ResponseEntity<CarResponse> registerCar(@Valid @RequestBody CarRequest carRequest);

	@Operation(summary = "List all owned cars with filters", responses = {
			@ApiResponse(responseCode = "200", description = "Owned cars retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/owner")
	ResponseEntity<CarResponse> listOwnedCars(@Valid @RequestBody CarRequest carRequest);

	@Operation(summary = "View car detail & current status", responses = {
			@ApiResponse(responseCode = "200", description = "Car details retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/{id}")
	ResponseEntity<CarResponse> getCarDetails(@PathVariable Long id);

	@Operation(summary = "Get lease history of a specific car", responses = {
			@ApiResponse(responseCode = "200", description = "Lease history retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/{id}/leases")
	ResponseEntity<LeaseResponse> getCarLeaseHistory(@PathVariable Long id);
}
