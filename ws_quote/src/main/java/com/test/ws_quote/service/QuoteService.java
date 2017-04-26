package com.test.ws_quote.service;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jbhunt.lib_quote_entity.QuoteRequest;
import com.jbhunt.quote.dto.QuoteRequestDTO;
import com.test.ws_quote.mapper.QuoteMapper;
import com.test.ws_quote.repository.QuoteRequestRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author rcon697
 *
 */
@Slf4j
@Component(value = "quoteService")
public class QuoteService {

	private QuoteRequestRepository quoteRequestRepository;

	private QuoteMapper quoteMapper;
	
	@Autowired
	private ProducerTemplate producerTemplate;
	
	@Autowired
	public QuoteService(QuoteRequestRepository quoteRequestRepository,QuoteMapper quoteMapper)
	{
		this.quoteMapper=quoteMapper;
		this.quoteRequestRepository=quoteRequestRepository;
	}

	public void saveQoute(QuoteRequestDTO quoteRequestDTo) {
		QuoteRequest quoteRequest = quoteMapper.quoteRequestDtoToQuoteRequestEntity(quoteRequestDTo);
		quoteRequestRepository.save(quoteRequest);
		producerTemplate.requestBody("direct:postToTopic", quoteRequestDTo);
		log.debug("QuoteService : Quote saved in DB"+ quoteRequestDTo);
	}

}
