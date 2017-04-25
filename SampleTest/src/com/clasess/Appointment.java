package com.clasess;

import java.time.LocalTime;
import java.util.List;


public class Appointment   {
	private int appointmentID;
	
	private String appointmentTypeCode;

	private String appointmentConfirmationNumber;

	private String requestCallBackIndicator;

	private LocalTime recommendedAppointmentTimeStamp;
	
	private List<AppointmentDetail> appointmentDetails;

	private List<AppointmentDateTimeDetail> appointmentDateTimeDetails;

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getAppointmentTypeCode() {
		return appointmentTypeCode;
	}

	public void setAppointmentTypeCode(String appointmentTypeCode) {
		this.appointmentTypeCode = appointmentTypeCode;
	}

	public String getAppointmentConfirmationNumber() {
		return appointmentConfirmationNumber;
	}

	public void setAppointmentConfirmationNumber(
			String appointmentConfirmationNumber) {
		this.appointmentConfirmationNumber = appointmentConfirmationNumber;
	}

	public String getRequestCallBackIndicator() {
		return requestCallBackIndicator;
	}

	public void setRequestCallBackIndicator(String requestCallBackIndicator) {
		this.requestCallBackIndicator = requestCallBackIndicator;
	}

	public LocalTime getRecommendedAppointmentTimeStamp() {
		return recommendedAppointmentTimeStamp;
	}

	public void setRecommendedAppointmentTimeStamp(
			LocalTime recommendedAppointmentTimeStamp) {
		this.recommendedAppointmentTimeStamp = recommendedAppointmentTimeStamp;
	}

	public List<AppointmentDetail> getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(List<AppointmentDetail> appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}

	public List<AppointmentDateTimeDetail> getAppointmentDateTimeDetails() {
		return appointmentDateTimeDetails;
	}

	public void setAppointmentDateTimeDetails(
			List<AppointmentDateTimeDetail> appointmentDateTimeDetails) {
		this.appointmentDateTimeDetails = appointmentDateTimeDetails;
	}
	

	
	
}
