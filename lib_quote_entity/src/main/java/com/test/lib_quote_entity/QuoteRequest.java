package com.test.lib_quote_entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Data
@Entity
@Table(name="dbo.quoteRequest")
public class QuoteRequest implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quoteId")
	private int quoteId;
	
	@Column(name="billTOCode")
	private String billTOCode;
	
	@Column(name="equipmentClassType")
	private String equipmentClassificationTypeAssociation;
	
	@Column(name="totalWeight")
	private Double totalShipmentWeightQuantity;
	
	@Column(name="unitOfWeightMeasurementCode")
	private String unitOfWeightMeasurementCode;
	//@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="requestedPickUpDate")
	private LocalDate requestedPickUpDate;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="quote_Id")
	private List<QuoteStop> quoteStops;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="quote_Id")
	private List<QuoteRequestItemClass> quoteRequestItemClass;
}
