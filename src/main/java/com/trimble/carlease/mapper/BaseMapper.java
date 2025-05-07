package com.trimble.carlease.mapper;

import org.mapstruct.Mapper;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:44:46 AM
 * Since: 1.0.0
 * @See #
 */

@Mapper(componentModel = "spring")
public interface BaseMapper<R, E, D> {

	/** Mapping from Request DTO to Entity **/
	E toEntity(R request);

	/** Mapping from Entity to Response DTO **/
	D toDto(E entity);

}
