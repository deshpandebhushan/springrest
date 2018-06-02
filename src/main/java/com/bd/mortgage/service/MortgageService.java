package com.bd.mortgage.service;

import java.util.List;

import com.bd.mortgage.model.InterestRates;
import com.bd.mortgage.model.MortgageRequest;
import com.bd.mortgage.model.MortgageResponse;

/**
 * 
 * @author bhushan
 * MortgageService
 *
 */
public interface MortgageService {

	public List<InterestRates> getInterestRates() throws Exception;
	
	public MortgageResponse verifyMortgageCriteria(MortgageRequest mortgageRequest) throws Exception;
}
