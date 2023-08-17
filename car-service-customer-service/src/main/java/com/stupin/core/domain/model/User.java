package com.stupin.core.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Objects;

@Table(name = "users")
public class User {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private List<Car> cars;

	public User() {
	}

	public User(final String id, final String firstName, final String lastName, final List<Car> cars) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cars = cars;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(final List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final User user)) {
			return false;
		}
		return Objects.equals(getId(), user.getId()) &&
			Objects.equals(getFirstName(), user.getFirstName()) &&
			Objects.equals(getLastName(), user.getLastName()) &&
			Objects.equals(getCars(), user.getCars());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getCars());
	}

	@Override
	public String toString() {
		return "User{" +
			"id='" + id + '\'' +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", cars=" + cars +
			'}';
	}
}
