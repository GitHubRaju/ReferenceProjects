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
@Table(name="dbo.quoteRequestItemClass")
public class QuoteRequestItemClass implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int quoteRequestItemClassID;
	
	@Column(name="itemClassificationCode")
	private String itemClassificationCode;
	
	@Column(name="itemHandlingTypeCode")
	private String itemHandlingTypeCode;
	
	@Column(name="itemTotalWeightQuantity")
	private Double itemTotalWeightQuantity;
	
	@Column(name="unitOfWeightMeasurementCode")
	private String unitOfWeightMeasurementCode;
	
	@Column(name="unitOfLenghtMeasurementCode")
	private String unitOfLenghtMeasurementCode;
	@Column(name="itemCategoryCode")
	private String itemCategoryCode;
	
	@Column(name="linearLenght")
	private Double linearLenght;
	
	@Column(name="palletQuantity")
	private int palletQuantity;
}
