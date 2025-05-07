package com.trimble.carlease.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.trimble.carlease.dto.request.CarRequest;
import com.trimble.carlease.dto.response.CarResponse;
import com.trimble.carlease.entity.CarEntity;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:44:46 AM
 * Since: 1.0.0
 * @See #
 */

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CarMapper extends BaseMapper<CarRequest, CarEntity, CarResponse> {

	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "leases", ignore = true)
	CarEntity toEntity(CarRequest request);

	@Override
	@Mapping(target = "status", source = "status")
	@Mapping(target = "ownerName", source = "owner.fullName")
	CarResponse toDto(CarEntity entity);

}
