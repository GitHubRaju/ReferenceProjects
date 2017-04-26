package com.test.quote.dto;

import lombok.Data;

@Data
public class QuoteStopDTO {

	private int  stopSequenceNumber;
	private String  customerLocationCode;
	private String stopReasonCode;
	private String stopCity;
	private String stopStateCode;
	private String stopPostalCode;
}
