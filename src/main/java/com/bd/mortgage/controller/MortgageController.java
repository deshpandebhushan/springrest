package com.bd.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bd.mortgage.model.InterestRates;
import com.bd.mortgage.model.MortgageRequest;
import com.bd.mortgage.model.MortgageResponse;
import com.bd.mortgage.service.MortgageService;

/**
 * 
 * @author bhushan
 * MortgageController - REST API
 *
 */
@RestController
public class MortgageController {
	
	@Autowired
	private MortgageService mortgageService;

	/**
	 * url - /api/interest-rates
	 * @return List<InterestRates>
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/interest-rates", method = RequestMethod.GET, produces = "application/json")
	public List<InterestRates> getInterestRates() throws Exception{
		return mortgageService.getInterestRates();
	}
	
	/**
	 * url - /api/mortgage-check
	 * @param mortgageRequest
	 * @return MortgageResponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/mortgage-check", method = RequestMethod.POST, produces = "application/json")
	public MortgageResponse mortgageCheck(@RequestBody MortgageRequest mortgageRequest) throws Exception{
		return mortgageService.verifyMortgageCriteria(mortgageRequest);
	}
}
