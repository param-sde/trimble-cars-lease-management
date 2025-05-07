package com.trimble.carlease.service;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:30:08 AM
 * Since: 1.0.0
 * @See #
 */
public interface CarService {

	CarResponse registerCar(CarRequest carRequest);

	CarResponse listOwnedCars(CarRequest carRequest);

	CarResponse getCarDetails(Long id);

	LeaseResponse getCarLeaseHistory(Long id);
}
