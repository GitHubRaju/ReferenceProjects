package com.test.quote.service;

import org.springframework.stereotype.Service;

import com.test.quote.dto.QuoteRequestDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class QuoteRequestService {
	
	public void quoteRequestToQualification(QuoteRequestDTO quoteRequestDTO)
	{
		log.debug("QuoteRequestService :" + quoteRequestDTO);
	}

}
