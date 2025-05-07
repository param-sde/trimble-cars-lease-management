package com.trimble.carlease.service;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:30:08 AM
 * Since: 1.0.0
 * @See #
 */
public interface AdminService {

	CarResponse getAllCars(CarRequest carRequest);

	UserResponse getAllUsers(UserRequest userRequest);

	LeaseResponse getAllLeases(LeaseRequest leaseRequest);

	CarResponse updateCar(Long carId, CarRequest carRequest);

	void deleteCar(Long carId);

	void deleteUser(Long userId);
}
