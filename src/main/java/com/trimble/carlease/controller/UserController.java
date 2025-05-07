package com.trimble.carlease.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.BaseResponse;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;
import com.trimble.carlease.resource.UserResource;
import com.trimble.carlease.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:19:37 AM
 * Since: 1.0.0
 * @See #
 */

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController implements UserResource {

	private final UserService userService;

	@Override
	public ResponseEntity<UserResponse> registerUser(UserRequest userRequest) {
		UserResponse response = userService.registerUser(userRequest);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<UserResponse> getUserProfile(Long id) {
		UserResponse response = userService.getUserProfile(id);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<UserResponse> getAllUsers(UserRequest userRequest) {
		UserResponse users = userService.getAllUsers(userRequest);
		return ResponseEntity.ok(users);
	}

	@Override
	public ResponseEntity<LeaseResponse> getUserLeaseHistory(Long id) {
		LeaseResponse leaseHistory = userService.getUserLeaseHistory(id);
		return ResponseEntity.ok(leaseHistory);
	}

	@Override
	public ResponseEntity<UserResponse> updateUser(Long id, UserRequest userRequest) {
		UserResponse updatedUser = userService.updateUser(id, userRequest);
		return ResponseEntity.ok(updatedUser);
	}

	@Override
	public ResponseEntity<BaseResponse<String>> deleteUser(Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}