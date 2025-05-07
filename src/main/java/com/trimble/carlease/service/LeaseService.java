package com.trimble.carlease.service;

import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:30:08 AM
 * Since: 1.0.0
 * @See #
 */
public interface LeaseService {

	CarResponse searchAvailableCars(LeaseRequest leaseRequest);

	LeaseResponse startLease(LeaseRequest leaseRequest);

	void endLease(Long id);

	LeaseResponse getLeaseHistoryByCustomerId(Long customerId);

}
