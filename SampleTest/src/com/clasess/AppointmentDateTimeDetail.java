package com.clasess;

import java.time.OffsetDateTime;


public class AppointmentDateTimeDetail {
	
	private int  appointmentDateTimeDetailID;

	//private OffsetDateTime appointmentStartTimestamp;

	//private OffsetDateTime appointmentEndTimestamp;

	private String primaryAppointmentIndicator;

	public int getAppointmentDateTimeDetailID() {
		return appointmentDateTimeDetailID;
	}

	public void setAppointmentDateTimeDetailID(int appointmentDateTimeDetailID) {
		this.appointmentDateTimeDetailID = appointmentDateTimeDetailID;
	}

/*	public OffsetDateTime getAppointmentStartTimestamp() {
		return appointmentStartTimestamp;
	}

	public void setAppointmentStartTimestamp(
			OffsetDateTime appointmentStartTimestamp) {
		this.appointmentStartTimestamp = appointmentStartTimestamp;
	}

	public OffsetDateTime getAppointmentEndTimestamp() {
		return appointmentEndTimestamp;
	}

	public void setAppointmentEndTimestamp(OffsetDateTime appointmentEndTimestamp) {
		this.appointmentEndTimestamp = appointmentEndTimestamp;
	}
*/
	public String getPrimaryAppointmentIndicator() {
		return primaryAppointmentIndicator;
	}

	public void setPrimaryAppointmentIndicator(String primaryAppointmentIndicator) {
		this.primaryAppointmentIndicator = primaryAppointmentIndicator;
	}
	
	
}
