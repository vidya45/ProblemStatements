package com.student.management.Domain;

public class StudentRegistrationReply {
	String name;
	Integer registrationNumber;
	String registrationStatus;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public Integer getRegistrationNumber() {
	return registrationNumber;
	}
	public void setRegistrationNumber(Integer registrationNumber) {
	this.registrationNumber = registrationNumber;
	}
	public String getRegistrationStatus() {
	return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
	this.registrationStatus = registrationStatus;
	}
}
