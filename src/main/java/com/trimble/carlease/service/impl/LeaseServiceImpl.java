package com.trimble.carlease.service.impl;

import org.springframework.stereotype.Service;

import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.service.LeaseService;

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
public class LeaseServiceImpl implements LeaseService {

	@Override
	public CarResponse searchAvailableCars(LeaseRequest leaseRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaseResponse startLease(LeaseRequest leaseRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endLease(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public LeaseResponse getLeaseHistoryByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
