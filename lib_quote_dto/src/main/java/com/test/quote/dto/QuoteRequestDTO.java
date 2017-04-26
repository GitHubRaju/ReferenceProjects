package com.test.quote.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class QuoteRequestDTO {

	private String billTOCode;
	private String equipmentClassificationTypeAssociation;
	private Double totalShipmentWeightQuantity;
	private String unitOfWeightMeasurementCode;

	 @JsonDeserialize(using = LocalDateTOstring.class)
	    //@JsonSerialize(using = JsonSerializer.class)	
	private LocalDate requestedPickUpDate;
	private List<QuoteStopDTO> quoteStops;
	private List<QuoteRequestItemClassDTO> quoteRequestItemClass;
}
