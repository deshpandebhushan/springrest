package com.bd.mortgage.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bd.mortgage.model.MortgageRequest;
import com.bd.mortgage.model.MortgageResponse;
import com.bd.mortgage.service.MortgageServiceImpl;

/**
 * 
 * @author bhushan
 * MortgageServiceImplTest
 *
 */
public class MortgageServiceImplTest {
	
	MortgageServiceImpl mortgageServiceImpl = new MortgageServiceImpl();

	/**
	 * verifyMortgageCriteriaTestReturningTrueWithMonthlyCosts
	 * @throws Exception
	 */
	@Test
    public void verifyMortgageCriteriaTestReturningTrueWithMonthlyCosts() throws Exception {
        
		MortgageRequest mortgageRequest = new MortgageRequest();
		mortgageRequest.setIncome(7000);
		mortgageRequest.setMaturityPeriod(10);
		mortgageRequest.setLoanValue(9000);
		mortgageRequest.setHomeValue(14000);
		
		MortgageResponse mortgageResponse = mortgageServiceImpl.verifyMortgageCriteria(mortgageRequest);
		
		assertEquals(true, mortgageResponse.getFeasibleMortgage());
		assertEquals(4500, (int) mortgageResponse.getMonthlyCosts());
		
    }
	
	/**
	 * verifyMortgageCriteriaTestReturningFalseForIncomeValue
	 * @throws Exception
	 */
	@Test
    public void verifyMortgageCriteriaTestReturningFalseForIncomeValue() throws Exception {
        
		MortgageRequest mortgageRequest = new MortgageRequest();
		mortgageRequest.setIncome(7000);
		mortgageRequest.setMaturityPeriod(10);
		mortgageRequest.setLoanValue(29000);
		mortgageRequest.setHomeValue(14000);
		
		MortgageResponse mortgageResponse = mortgageServiceImpl.verifyMortgageCriteria(mortgageRequest);
		
		assertEquals(false, mortgageResponse.getFeasibleMortgage());
		
    }
	
	/**
	 * verifyMortgageCriteriaTestReturningFalseForLoanValue
	 * @throws Exception
	 */
	@Test
    public void verifyMortgageCriteriaTestReturningFalseForLoanValue() throws Exception {
        
		MortgageRequest mortgageRequest = new MortgageRequest();
		mortgageRequest.setIncome(7000);
		mortgageRequest.setMaturityPeriod(10);
		mortgageRequest.setLoanValue(15000);
		mortgageRequest.setHomeValue(14000);
		
		MortgageResponse mortgageResponse = mortgageServiceImpl.verifyMortgageCriteria(mortgageRequest);
		
		assertEquals(false, mortgageResponse.getFeasibleMortgage());
		
    }
}
