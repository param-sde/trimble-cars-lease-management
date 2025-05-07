package com.trimble.carlease.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.response.BaseResponse;
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

@Tag(name = "Lease APIs", description = "APIs for customers to search cars and manage leases")
@Validated
@RequestMapping("/api/v1/leases")
public interface LeaseResource {

	@Operation(summary = "View available cars with pagination/filter", responses = {
			@ApiResponse(responseCode = "200", description = "Available cars retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/cars/search")
	ResponseEntity<CarResponse> searchAvailableCars(@Valid @RequestBody LeaseRequest leaseRequest);

	@Operation(summary = "Start lease (max 2 per customer)", responses = {
			@ApiResponse(responseCode = "200", description = "Lease started successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid input or lease limit reached"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping("/start")
	ResponseEntity<LeaseResponse> startLease(@Valid @RequestBody LeaseRequest leaseRequest);

	@Operation(summary = "End a lease", responses = {
			@ApiResponse(responseCode = "200", description = "Lease ended successfully"),
			@ApiResponse(responseCode = "404", description = "Lease not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@PutMapping("/{id}/end")
	ResponseEntity<BaseResponse<String>> endLease(@PathVariable Long id);

	@Operation(summary = "Get customer's lease history", responses = {
			@ApiResponse(responseCode = "200", description = "Lease history retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Customer not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("/history")
	ResponseEntity<LeaseResponse> getCustomerLeaseHistory(@RequestParam Long customerId);
}