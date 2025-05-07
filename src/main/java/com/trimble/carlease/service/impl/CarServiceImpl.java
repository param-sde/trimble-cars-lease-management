package com.trimble.carlease.service.impl;

import org.springframework.stereotype.Service;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.service.CarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:31:23 AM
 * Since: 1.0.0
 * @See #
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	@Override
	public CarResponse registerCar(CarRequest carRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarResponse listOwnedCars(CarRequest carRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarResponse getCarDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaseResponse getCarLeaseHistory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}