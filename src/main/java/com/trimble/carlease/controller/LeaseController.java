package com.trimble.carlease.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.response.BaseResponse;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.resource.LeaseResource;
import com.trimble.carlease.service.LeaseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:19:51 AM
 * Since: 1.0.0
 * @See #
 */

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class LeaseController implements LeaseResource {

	private final LeaseService leaseService;

	@Override
	public ResponseEntity<CarResponse> searchAvailableCars(LeaseRequest leaseRequest) {
		return ResponseEntity.ok(leaseService.searchAvailableCars(leaseRequest));
	}

	@Override
	public ResponseEntity<LeaseResponse> startLease(LeaseRequest leaseRequest) {
		return ResponseEntity.ok(leaseService.startLease(leaseRequest));
	}

	@Override
	public ResponseEntity<BaseResponse<String>> endLease(Long id) {
		leaseService.endLease(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<LeaseResponse> getCustomerLeaseHistory(Long customerId) {
		return ResponseEntity.ok(leaseService.getLeaseHistoryByCustomerId(customerId));
	}
}