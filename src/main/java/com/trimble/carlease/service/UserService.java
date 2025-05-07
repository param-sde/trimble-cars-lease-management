package com.trimble.carlease.service;

import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:30:08 AM
 * Since: 1.0.0
 * @See #
 */
public interface UserService {

	UserResponse registerUser(UserRequest userRequest);

	UserResponse getUserProfile(Long userId);

	UserResponse getAllUsers(UserRequest userRequest);

	LeaseResponse getUserLeaseHistory(Long userId);

	UserResponse updateUser(Long userId, UserRequest userRequest);

	void deleteUser(Long userId);
}
