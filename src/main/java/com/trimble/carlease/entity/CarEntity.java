package com.trimble.carlease.entity;

import java.util.List;

import com.trimble.carlease.enums.CarStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:25:16 AM
 * Since: 1.0.0
 * @See #
 */

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String make;
	private String model;
	private int year;
	private double pricePerDay;

	@Enumerated(EnumType.STRING)
	private CarStatus status;

	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private UserEntity owner;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private List<LeaseEntity> leases;
}
