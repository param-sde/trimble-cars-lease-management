package com.trimble.carlease.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.trimble.carlease.dto.request.UserRequest;
import com.trimble.carlease.dto.response.UserResponse;
import com.trimble.carlease.entity.UserEntity;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:43:51 AM
 * Since: 1.0.0
 * @See #
 */

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserRequest, UserEntity, UserResponse> {

	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ownedCars", ignore = true)
	@Mapping(target = "leases", ignore = true)
	UserEntity toEntity(UserRequest request);

	@Override
	@Mapping(target = "role", source = "role")
	@Mapping(target = "address", source = "address")
	UserResponse toDto(UserEntity entity);

}
