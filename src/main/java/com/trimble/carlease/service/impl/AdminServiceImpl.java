package com.trimble.carlease.service.impl;

import org.springframework.stereotype.Service;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;
import com.trimble.carlease.service.AdminService;

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
public class AdminServiceImpl implements AdminService {

	@Override
	public CarResponse getAllCars(CarRequest carRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getAllUsers(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaseResponse getAllLeases(LeaseRequest leaseRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarResponse updateCar(Long carId, CarRequest carRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCar(Long carId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub

	}

}
