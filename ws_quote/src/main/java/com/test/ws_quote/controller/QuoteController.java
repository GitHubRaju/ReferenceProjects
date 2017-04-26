package com.test.ws_quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbhunt.lib_quote_entity.QuoteRequest;
import com.jbhunt.quote.dto.QuoteRequestDTO;
import com.jbhunt.quote.dto.QuoteResponseDTO;
import com.test.ws_quote.mapper.QuoteMapper;
import com.test.ws_quote.service.QuoteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class QuoteController {
	
	@Autowired
	private QuoteService quoteService;
	

	
	@RequestMapping(name="/createquote",method=RequestMethod.POST)
	public ResponseEntity<QuoteResponseDTO> createQuote(@RequestBody QuoteRequestDTO quoteRequestDTO) {
		log.debug("QuoteController : Quote Creation ");
		quoteService.saveQoute(quoteRequestDTO);
		QuoteResponseDTO quoteResponseDTO = new QuoteResponseDTO();
		return ResponseEntity.ok(quoteResponseDTO);

	}

}
