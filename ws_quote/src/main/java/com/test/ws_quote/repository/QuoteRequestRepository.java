package com.test.ws_quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbhunt.lib_quote_entity.QuoteRequest;

@Repository
public interface QuoteRequestRepository extends JpaRepository<QuoteRequest, Integer>{

}
