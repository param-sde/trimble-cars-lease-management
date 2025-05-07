package com.trimble.carlease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trimble.carlease.entity.CarEntity;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:30:08 AM
 * Since: 1.0.0
 * @See #
 */

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
