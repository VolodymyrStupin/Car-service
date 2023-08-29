package com.stupin.core.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "managers")
public class Manager {

	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	public Manager(
		final String id,
		final String firstName,
		final String lastName,
		final String email,
		final String phoneNumber
	) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final Manager manager)) {
			return false;
		}
		return Objects.equals(getId(), manager.getId()) &&
			Objects.equals(getFirstName(), manager.getFirstName()) &&
			Objects.equals(getLastName(), manager.getLastName()) &&
			Objects.equals(getEmail(), manager.getEmail()) &&
			Objects.equals(getPhoneNumber(), manager.getPhoneNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPhoneNumber());
	}
}
