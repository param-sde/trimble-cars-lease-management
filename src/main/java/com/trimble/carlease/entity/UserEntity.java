package com.trimble.carlease.entity;

import java.util.List;

import com.trimble.carlease.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:24:49 AM
 * Since: 1.0.0
 * @See #
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String fullName;

	@Column(unique = true, nullable = false)
	private String phoneNo;

	@Column(unique = true, nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Embedded
	private AddressEntity address;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<CarEntity> ownedCars;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<LeaseEntity> leases;

}
