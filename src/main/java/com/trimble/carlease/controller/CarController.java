package com.trimble.carlease.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.resource.CarResource;
import com.trimble.carlease.service.CarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:19:18 AM
 * Since: 1.0.0
 * @See #
 */

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CarController implements CarResource {

	private final CarService carService;

	@Override
	public ResponseEntity<CarResponse> registerCar(CarRequest carRequest) {
		CarResponse response = carService.registerCar(carRequest);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<CarResponse> listOwnedCars(CarRequest carRequest) {
		CarResponse cars = carService.listOwnedCars(carRequest);
		return ResponseEntity.ok(cars);
	}

	@Override
	public ResponseEntity<CarResponse> getCarDetails(Long id) {
		CarResponse response = carService.getCarDetails(id);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<LeaseResponse> getCarLeaseHistory(Long id) {
		LeaseResponse leaseHistory = carService.getCarLeaseHistory(id);
		return ResponseEntity.ok(leaseHistory);
	}
}
