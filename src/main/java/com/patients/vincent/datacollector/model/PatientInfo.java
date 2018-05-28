package com.patients.vincent.datacollector.model;


public class PatientInfo {

	private long patientId;
	private int appointmentId;
	private String gender;
	private String neighborHood;
	private int age;
	
	public PatientInfo(long patientId, int appointmentId, String gender, String neighborHood, int age) {
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.setGender(gender);
		this.neighborHood = neighborHood;
		this.age = age;
	}

	public PatientInfo() {}
	
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public String getNeighborHood() {
		return neighborHood;
	}
	public void setNeighborHood(String neighborHood) {
		this.neighborHood = neighborHood;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
