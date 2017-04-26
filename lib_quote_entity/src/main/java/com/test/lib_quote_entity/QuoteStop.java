package com.test.lib_quote_entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dbo.quoteStop")
public class QuoteStop implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int quoteStopID;
	
	@Column(name="stopSequenceNumber")
	private int  stopSequenceNumber;
	
	@Column(name="customerLocationCode")
	private String  customerLocationCode;
	
	@Column(name="stopReasonCode")
	private String stopReasonCode;
	
	@Column(name="stopCity")
	private String stopCity;
	
	@Column(name="stopStateCode")
	private String stopStateCode;
	
	@Column(name="stopPostalCode")
	private String stopPostalCode;
}
