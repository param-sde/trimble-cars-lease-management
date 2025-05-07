package com.trimble.carlease.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.trimble.carlease.dto.request.LeaseRequest;
import com.trimble.carlease.dto.response.LeaseResponse;
import com.trimble.carlease.entity.LeaseEntity;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:44:54 AM
 * Since: 1.0.0
 * @See #
 */

@Mapper(componentModel = "spring", uses = { CarMapper.class, UserMapper.class })
public interface LeaseMapper extends BaseMapper<LeaseRequest, LeaseEntity, LeaseResponse> {

	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "car", ignore = true)
	@Mapping(target = "customer", ignore = true)
	LeaseEntity toEntity(LeaseRequest request);

	@Override
	@Mapping(target = "status", source = "status")
	@Mapping(target = "car", source = "car")
	@Mapping(target = "customer", source = "customer")
	LeaseResponse toDto(LeaseEntity entity);

}
