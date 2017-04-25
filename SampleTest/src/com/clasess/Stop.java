package com.clasess;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Stop {
	private int stopID;

	private int locationID;

	//private int locationContactID;

	//private String locationContactType;

	//private String highCostDeliveryIndicator;

	private String stopReason;

	private int stopSequenceNumber;

	//private BigDecimal totalStopWeight;

	//private String unitOfWeightMeasurementCode;

	//private LocalDate initialOfferedDate;

	private List<Appointment> appointment;

	public int getStopID() {
		return stopID;
	}

	public void setStopID(int stopID) {
		this.stopID = stopID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	/*public int getLocationContactID() {
		return locationContactID;
	}

	public void setLocationContactID(int locationContactID) {
		this.locationContactID = locationContactID;
	}

	public String getLocationContactType() {
		return locationContactType;
	}

	public void setLocationContactType(String locationContactType) {
		this.locationContactType = locationContactType;
	}

	public String getHighCostDeliveryIndicator() {
		return highCostDeliveryIndicator;
	}

	public void setHighCostDeliveryIndicator(String highCostDeliveryIndicator) {
		this.highCostDeliveryIndicator = highCostDeliveryIndicator;
	}
*/
	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public int getStopSequenceNumber() {
		return stopSequenceNumber;
	}

	public void setStopSequenceNumber(int stopSequenceNumber) {
		this.stopSequenceNumber = stopSequenceNumber;
	}

/*	public BigDecimal getTotalStopWeight() {
		return totalStopWeight;
	}

	public void setTotalStopWeight(BigDecimal totalStopWeight) {
		this.totalStopWeight = totalStopWeight;
	}

	public String getUnitOfWeightMeasurementCode() {
		return unitOfWeightMeasurementCode;
	}

	public void setUnitOfWeightMeasurementCode(String unitOfWeightMeasurementCode) {
		this.unitOfWeightMeasurementCode = unitOfWeightMeasurementCode;
	}

	public LocalDate getInitialOfferedDate() {
		return initialOfferedDate;
	}

	public void setInitialOfferedDate(LocalDate initialOfferedDate) {
		this.initialOfferedDate = initialOfferedDate;
	}
*/
	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	
}