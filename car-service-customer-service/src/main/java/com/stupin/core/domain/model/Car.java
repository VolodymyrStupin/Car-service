package com.stupin.core.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table(name = "cars")
public class Car {
	@Id
	private Long id;

	private String make;

	private String model;

	private Integer year;

	private Integer kilometers;

	private String userId;

	public Car() {
	}

	public Car(
		final Long id,
		final String make,
		final String model,
		final Integer year,
		final Integer kilometers,
		final String userId
	) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.kilometers = kilometers;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(final String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(final String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(final Integer year) {
		this.year = year;
	}

	public Integer getKilometers() {
		return kilometers;
	}

	public void setKilometers(final Integer kilometers) {
		this.kilometers = kilometers;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final Car car)) {
			return false;
		}
		return getYear() == car.getYear() &&
			Objects.equals(getId(), car.getId()) &&
			Objects.equals(getMake(), car.getMake()) &&
			Objects.equals(getModel(), car.getModel()) &&
			Objects.equals(getKilometers(), car.getKilometers()) &&
			Objects.equals(getUserId(), car.getUserId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getMake(), getModel(), getYear(), getKilometers(), getUserId());
	}

	@Override
	public String toString() {
		return "Car{" +
			"id=" + id +
			", make='" + make + '\'' +
			", model='" + model + '\'' +
			", productionYear=" + year +
			", kilometres='" + kilometers + '\'' +
			", userId='" + userId + '\'' +
			'}';
	}
}
