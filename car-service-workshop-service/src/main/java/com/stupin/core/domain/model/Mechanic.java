package com.stupin.core.domain.model;

import com.stupin.core.enums.MechanicRole;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "mechanics")
public class Mechanic {

	private String id;

	private String firstName;

	private String lastName;

	private Double experience;

	private String email;

	private MechanicRole role;

	public Mechanic(
		final String id,
		final String firstName,
		final String lastName,
		final Double experience,
		final String email,
		final MechanicRole role
	) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.email = email;
		this.role = role;
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

	public Double getExperience() {
		return experience;
	}

	public void setExperience(final Double experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public MechanicRole getRole() {
		return role;
	}

	public void setRole(final MechanicRole role) {
		this.role = role;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final Mechanic mechanic)) {
			return false;
		}
		return Objects.equals(getId(), mechanic.getId()) &&
			Objects.equals(getFirstName(), mechanic.getFirstName()) &&
			Objects.equals(getLastName(), mechanic.getLastName()) &&
			Objects.equals(getExperience(), mechanic.getExperience()) &&
			Objects.equals(getEmail(), mechanic.getEmail()) &&
			getRole() == mechanic.getRole();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getExperience(), getEmail(), getRole());
	}

	@Override
	public String toString() {
		return "Mechanic{" +
			"id='" + id + '\'' +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", experience=" + experience +
			", email='" + email + '\'' +
			", role=" + role +
			'}';
	}
}

