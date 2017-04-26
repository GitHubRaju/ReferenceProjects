package com.test.quote.dto;

import lombok.Data;

@Data
public class QuoteRequestItemClassDTO {

	private String itemClassificationCode;
	private String itemHandlingTypeCode;
	private Double itemTotalWeightQuantity;
	private String unitOfWeightMeasurementCode;
	private String unitOfLenghtMeasurementCode;
	private String itemCategoryCode;
	private Double linearLenght;
	private int palletQuantity;
}
