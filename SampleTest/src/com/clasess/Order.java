package com.clasess;

import java.util.List;




public class Order {

    
    private static final String PENDING_ORDER_STATUS = "Pending";
    private static final String CANCELLED_ORDER_STATUS = "Cancelled";
    private static final String PRE_ASSIGNED_ORDER_STATUS = "PreAssigned";
    private static final String ACCEPTED_ORDER_STATUS = "Accepted";
    private static final String REJECTED_ORDER_STATUS = "Rejected";
    
    
    private int orderID;

    private int customerID;

    private String serviceOfferingCode;

    private String requestedServiceLevelCode;

    private String servicePriorityTypeCode;

    private String transitModeCode;

    private String financeBusinessUnitCode;

    private String orderSourceCode;

    private String orderStatusCode = "Incomplete";

    private String orderTypeCode;

    private String orderSubTypeCode;
    
    private String orderValueTypeCode;

    private List<Stop> stops;
    
    

	public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}



	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public String getServiceOfferingCode() {
		return serviceOfferingCode;
	}



	public void setServiceOfferingCode(String serviceOfferingCode) {
		this.serviceOfferingCode = serviceOfferingCode;
	}



	public String getRequestedServiceLevelCode() {
		return requestedServiceLevelCode;
	}



	public void setRequestedServiceLevelCode(String requestedServiceLevelCode) {
		this.requestedServiceLevelCode = requestedServiceLevelCode;
	}



	public String getServicePriorityTypeCode() {
		return servicePriorityTypeCode;
	}



	public void setServicePriorityTypeCode(String servicePriorityTypeCode) {
		this.servicePriorityTypeCode = servicePriorityTypeCode;
	}



	public String getTransitModeCode() {
		return transitModeCode;
	}



	public void setTransitModeCode(String transitModeCode) {
		this.transitModeCode = transitModeCode;
	}



	public String getFinanceBusinessUnitCode() {
		return financeBusinessUnitCode;
	}



	public void setFinanceBusinessUnitCode(String financeBusinessUnitCode) {
		this.financeBusinessUnitCode = financeBusinessUnitCode;
	}



	public String getOrderSourceCode() {
		return orderSourceCode;
	}



	public void setOrderSourceCode(String orderSourceCode) {
		this.orderSourceCode = orderSourceCode;
	}



	public String getOrderStatusCode() {
		return orderStatusCode;
	}



	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}



	public String getOrderTypeCode() {
		return orderTypeCode;
	}



	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}



	public String getOrderSubTypeCode() {
		return orderSubTypeCode;
	}



	public void setOrderSubTypeCode(String orderSubTypeCode) {
		this.orderSubTypeCode = orderSubTypeCode;
	}



	public String getOrderValueTypeCode() {
		return orderValueTypeCode;
	}



	public void setOrderValueTypeCode(String orderValueTypeCode) {
		this.orderValueTypeCode = orderValueTypeCode;
	}



	public List<Stop> getStops() {
		return stops;
	}



	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}



	public static String getPendingOrderStatus() {
		return PENDING_ORDER_STATUS;
	}



	public static String getCancelledOrderStatus() {
		return CANCELLED_ORDER_STATUS;
	}



	public static String getPreAssignedOrderStatus() {
		return PRE_ASSIGNED_ORDER_STATUS;
	}



	public static String getAcceptedOrderStatus() {
		return ACCEPTED_ORDER_STATUS;
	}



	public static String getRejectedOrderStatus() {
		return REJECTED_ORDER_STATUS;
	}



	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID
				+ ", serviceOfferingCode=" + serviceOfferingCode
				+ ", requestedServiceLevelCode=" + requestedServiceLevelCode
				+ ", servicePriorityTypeCode=" + servicePriorityTypeCode
				+ ", transitModeCode=" + transitModeCode
				+ ", financeBusinessUnitCode=" + financeBusinessUnitCode
				+ ", orderSourceCode=" + orderSourceCode + ", orderStatusCode="
				+ orderStatusCode + ", orderTypeCode=" + orderTypeCode
				+ ", orderSubTypeCode=" + orderSubTypeCode
				+ ", orderValueTypeCode=" + orderValueTypeCode + ", stops="
				+ stops + "]";
	}
    
    

    
    }
