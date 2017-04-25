package com.springApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@Table(name="order_t")

public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_Id")
	private Long orderId;
	@Column(name="order_Date")
	private Date orderDate;
	@Column(name="services")
	private String services;
public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}


}
