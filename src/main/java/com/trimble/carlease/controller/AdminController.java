package com.trimble.carlease.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.BaseResponse;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;
import com.trimble.carlease.resource.AdminResource;
import com.trimble.carlease.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:18:06 AM
 * Since: 1.0.0
 * @See #
 */

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AdminController implements AdminResource {

	private final AdminService adminService;

	@Override
	public ResponseEntity<CarResponse> getAllCars(CarRequest carRequest) {
		return ResponseEntity.ok(adminService.getAllCars(carRequest));
	}

	@Override
	public ResponseEntity<UserResponse> getAllUsers(UserRequest userRequest) {
		return ResponseEntity.ok(adminService.getAllUsers(userRequest));
	}

	@Override
	public ResponseEntity<LeaseResponse> getAllLeases(LeaseRequest leaseRequest) {
		return ResponseEntity.ok(adminService.getAllLeases(leaseRequest));
	}

	@Override
	public ResponseEntity<CarResponse> updateCar(Long id, CarRequest carRequest) {
		return ResponseEntity.ok(adminService.updateCar(id, carRequest));
	}

	@Override
	public ResponseEntity<BaseResponse<String>> deleteCar(Long id) {
		adminService.deleteCar(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<BaseResponse<String>> deleteUser(Long id) {
		adminService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
