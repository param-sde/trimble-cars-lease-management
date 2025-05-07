package com.trimble.carlease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trimble.carlease.entity.LeaseEntity;
import com.trimble.carlease.entity.UserEntity;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:30:08 AM
 * Since: 1.0.0
 * @See #
 */

@Repository
public interface LeaseRepository extends JpaRepository<LeaseEntity, Long> {

	List<LeaseEntity> findByCustomer(UserEntity user);

}
