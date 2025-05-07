package com.trimble.carlease.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.dto.response.UserResponse;
import com.trimble.carlease.dto.response.UserResponse.UserBody;
import com.trimble.carlease.entity.AddressEntity;
import com.trimble.carlease.entity.UserEntity;
import com.trimble.carlease.enums.Role;
import com.trimble.carlease.exception.user.UserAlreadyExistsException;
import com.trimble.carlease.exception.user.UserLeaseLimitExceededException;
import com.trimble.carlease.exception.user.UserNotFoundException;
import com.trimble.carlease.mapper.UserMapper;
import com.trimble.carlease.repository.LeaseRepository;
import com.trimble.carlease.repository.UserRepository;
import com.trimble.carlease.service.UserService;
import com.trimble.carlease.utils.MessageUtils;

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
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final LeaseRepository leaseRepository;
	private final UserMapper userMapper;
	private final MessageUtils messageUtils;

	@Override
	public UserResponse registerUser(UserRequest userRequest) {
		log.info("Registering user with email: {}", userRequest.getEmail());

		if (userRepository.existsByEmail(userRequest.getEmail())) {
			log.warn("User already exists for email: {}", userRequest.getEmail());
			throw new UserAlreadyExistsException("TCLM102", userRequest.getEmail());
		}

		try {
			UserEntity userEntity = userMapper.toEntity(userRequest);
			UserEntity savedUser = userRepository.save(userEntity);

			UserBody userBody = userMapper.toDto(savedUser).getData();
			log.info("User registration successful, ID: {}", savedUser.getId());

			return buildUserResponse("TCLM100", HttpStatus.OK, userBody);
		} catch (DataIntegrityViolationException ex) {
			log.error("Data integrity error during user registration", ex);
			throw new UserAlreadyExistsException("TCLM102", userRequest.getEmail());
		} catch (Exception ex) {
			log.error("Unexpected error during user registration", ex);
			throw ex;
		}
	}

	@Override
	public UserResponse getUserProfile(Long id) {
		log.info("Fetching profile for user ID: {}", id);

		UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("TCLM101", id));

		UserBody userBody = userMapper.toDto(user).getData();
		log.info("User profile retrieval successful for ID: {}", id);

		return buildUserResponse("TCLM100", HttpStatus.OK, userBody);
	}

	@Override
	public UserResponse getAllUsers(UserRequest request) {
		log.info("Fetching all users");

		try {
			List<UserEntity> users = userRepository.findAll();

			List<UserBody> userList = users.stream().map(user -> userMapper.toDto(user).getData())
					.collect(Collectors.toList());

			UserBody userBody = UserBody.builder().users(userList).build();

			log.info("Successfully fetched {} users", userList.size());

			return buildUserResponse("TCLM100", HttpStatus.OK, userBody);
		} catch (Exception ex) {
			log.error("Error while fetching all users", ex);
			throw ex;
		}
	}

	@Override
	public LeaseResponse getUserLeaseHistory(Long userId) {
		log.info("Fetching lease history for user ID: {}", userId);

		try {
			/** TODO: Actual logic has to be implement **/
			return new LeaseResponse();
		} catch (UserLeaseLimitExceededException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("Unexpected error fetching lease history", ex);
			throw ex;
		}
	}

	@Override
	public UserResponse updateUser(Long id, UserRequest request) {
		log.info("Updating user ID: {}", id);

		UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("TCLM101", id));

		try {
			user.setFullName(request.getFullName());
			user.setPhoneNo(request.getPhoneNo());
			user.setEmail(request.getEmail());
			user.setRole(Role.valueOf(request.getRole()));

			user.setAddress(AddressEntity.builder().line1(request.getAddress().getLine1())
					.line2(request.getAddress().getLine2()).city(request.getAddress().getCity())
					.state(request.getAddress().getState()).country(request.getAddress().getCountry())
					.postalCode(request.getAddress().getPostalCode()).build());

			UserEntity updatedUser = userRepository.save(user);
			UserBody userBody = userMapper.toDto(updatedUser).getData();

			log.info("User update successful for ID: {}", id);
			return buildUserResponse("TCLM104", HttpStatus.OK, userBody);
		} catch (Exception ex) {
			log.error("Error updating user ID: {}", id, ex);
			throw ex;
		}
	}

	@Override
	public void deleteUser(Long id) {
		log.info("Deleting user ID: {}", id);

		UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("TCLM101", id));

		try {
			userRepository.delete(user);
			log.info("User deleted successfully: {}", id);
		} catch (Exception ex) {
			log.error("Error deleting user ID: {}", id, ex);
			throw ex;
		}
	}

	private UserResponse buildUserResponse(String code, HttpStatus status, UserBody body) {
		return UserResponse.builder().success(true).status(status.name()).statusCode(status.value())
				.message(messageUtils.getMessage(code)).timestamp(LocalDateTime.now()).data(body).build();
	}
}
