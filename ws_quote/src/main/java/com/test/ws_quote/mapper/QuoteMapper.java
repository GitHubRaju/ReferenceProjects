package com.test.ws_quote.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.jbhunt.lib_quote_entity.QuoteRequest;
import com.jbhunt.lib_quote_entity.QuoteRequestItemClass;
import com.jbhunt.lib_quote_entity.QuoteStop;
import com.jbhunt.quote.dto.QuoteRequestDTO;
import com.jbhunt.quote.dto.QuoteRequestItemClassDTO;
import com.jbhunt.quote.dto.QuoteStopDTO;


@Component("quoteMapper")
@Mapper(componentModel = "spring")
public abstract class QuoteMapper  {
	
	
	/**
	 * @param quoteRequestDTO
	 * @return
	 */
	public static QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);
	
	public abstract QuoteRequest quoteRequestDtoToQuoteRequestEntity(QuoteRequestDTO quoteRequestDTO);
	

	public abstract QuoteRequestDTO quoteRequestEntityToQuoteRequestDto(QuoteRequest quoteRequest);
	
	public abstract QuoteStop quoteStopDTOToQuoteStopEntity(QuoteStopDTO quoteStopDTO);
	
	
	public abstract QuoteStopDTO quoteStopToQuoteStopDTO(QuoteStop quoteStop);
	
	public abstract List<QuoteStop> quoteStopDTOToQuoteStops(List<QuoteStopDTO> quoteStopDTO);
	
	
	public abstract List<QuoteStopDTO> quoteStopToQuoteStopDTO(List<QuoteStop> quoteStop);
	
	public abstract QuoteRequestItemClass quoteRequestItemClassDtoToQuoteRequestItemClass(QuoteRequestItemClassDTO quoteRequestItemClassDTO);

	public abstract QuoteRequestItemClassDTO quoteRequestItemClassToQuoteRequestItemClassDto(QuoteRequestItemClass quoteRequestItemClass);
	
	public abstract List<QuoteRequestItemClass> listQuoteStopDtoTolistQuoteStopEntity(List<QuoteRequestItemClassDTO> listQuoteStopDto);

	public abstract List<QuoteRequestItemClassDTO> listQuoteStopEntityTolistQuoteStopDto(List<QuoteRequestItemClass> listQuoteStop);
	

}
