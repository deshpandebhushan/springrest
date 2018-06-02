package com.bd.mortgage.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bd.mortgage.model.InterestRates;
import com.bd.mortgage.model.MortgageRequest;
import com.bd.mortgage.model.MortgageResponse;

/**
 * 
 * @author bhushan
 * MortgageServiceImpl
 *
 */
@Service
public class MortgageServiceImpl implements MortgageService{

	private static final Logger logger = LoggerFactory.getLogger(MortgageServiceImpl.class);
	
	/**
	 * List of interest rates for mortgage
	 */
	private final static List<InterestRates> interestRateList = new ArrayList<InterestRates>() {{
		add(new InterestRates(10, 6.0, Timestamp.valueOf("2018-05-17 09:29:42")));
		add(new InterestRates(11, 7.0, Timestamp.valueOf("2018-05-17 09:29:42")));
		add(new InterestRates(12, 8.0, Timestamp.valueOf("2018-05-17 09:29:42")));
		add(new InterestRates(13, 9.0, Timestamp.valueOf("2018-05-17 09:29:42")));
		add(new InterestRates(14, 6.0, Timestamp.valueOf("2018-05-17 09:29:42")));
		add(new InterestRates(15, 7.0, Timestamp.valueOf("2018-05-17 09:29:42")));
	}};
	
	/**
	 * getInterestRates - returning complete list of interest rates
	 * @param 
	 * @return List<InterestRates>
	 * @throws Exception
	 * 
	 */
	@Override
	public List<InterestRates> getInterestRates() throws Exception {
		
		logger.info("MortgageServiceImpl-getInterestRates");
		
		return interestRateList;
	}
	
	/**
	 * verifyMortgageCriteria - mortgage check for returning monthly costs
	 * @param MortgageRequest
	 * @return MortgageResponse
	 * @throws Exception
	 * 
	 */
	@Override
	public MortgageResponse verifyMortgageCriteria(MortgageRequest mortgageRequest) throws Exception {
		
		logger.info("MortgageServiceImpl-verifyMortgageCriteria");
		
		MortgageResponse mortgageResponse = new MortgageResponse();
		
		if(mortgageRequest.getLoanValue() >= 4 * mortgageRequest.getIncome()) {
			mortgageResponse.setFeasibleMortgage(false);
			return mortgageResponse;
		} else if(mortgageRequest.getLoanValue() >= mortgageRequest.getHomeValue()) {
			mortgageResponse.setFeasibleMortgage(false);
			return mortgageResponse;
		} else {
			
			int maturityPeriod = mortgageRequest.getMaturityPeriod();
			double loanValue = mortgageRequest.getLoanValue();
			double homeValue = mortgageRequest.getHomeValue();
			
			double interestRatesValue = 0.0;
		    for (InterestRates interestRates : interestRateList) {
		        if (interestRates.getMaturityPeriod() == maturityPeriod) {
		        	interestRatesValue = interestRates.getInterestRate();
		        }
		    }
			
			double monthlyRate = (double) interestRatesValue / 12.0;
			int termsInMonths = maturityPeriod * 12;
			Integer monthlyCosts = (int) ((loanValue * monthlyRate) / 
					(1-Math.pow(1+interestRatesValue, -termsInMonths)));
			mortgageResponse.setFeasibleMortgage(true);
			mortgageResponse.setMonthlyCosts(monthlyCosts);
			
			return mortgageResponse;
		}
		
	}
}
