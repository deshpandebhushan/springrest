package com.bd.mortgage.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bd.mortgage.controller.MortgageController;
import com.bd.mortgage.model.MortgageRequest;
import com.bd.mortgage.model.MortgageResponse;

/**
 * MortgageControllerTest
 * @author bhushan
 *
 */
public class MortgageControllerTest {
	
	MortgageController mortgageController = new MortgageController();

	/**
	 * mortgageCheckTestReturningTrueWithMonthlyCosts
	 * @throws Exception
	 */
	@Test
    public void mortgageCheckTestReturningTrueWithMonthlyCosts() throws Exception {
        
		MortgageRequest mortgageRequest = new MortgageRequest();
		mortgageRequest.setIncome(7000);
		mortgageRequest.setMaturityPeriod(10);
		mortgageRequest.setLoanValue(9000);
		mortgageRequest.setHomeValue(14000);
		
		MortgageResponse mortgageResponse = mortgageController.mortgageCheck(mortgageRequest);
		
		assertEquals(true, mortgageResponse.getFeasibleMortgage());
		assertEquals(4500, (int) mortgageResponse.getMonthlyCosts());
		
    }
	
	/**
	 * mortgageCheckTestReturningFalseForIncomeValue
	 * @throws Exception
	 */
	@Test
    public void mortgageCheckTestReturningFalseForIncomeValue() throws Exception {
        
		MortgageRequest mortgageRequest = new MortgageRequest();
		mortgageRequest.setIncome(7000);
		mortgageRequest.setMaturityPeriod(10);
		mortgageRequest.setLoanValue(29000);
		mortgageRequest.setHomeValue(14000);
		
		MortgageResponse mortgageResponse = mortgageController.mortgageCheck(mortgageRequest);
		
		assertEquals(false, mortgageResponse.getFeasibleMortgage());
		
    }
	
	/**
	 * mortgageCheckTestReturningFalseForLoanValue
	 * @throws Exception
	 */
	@Test
    public void mortgageCheckTestReturningFalseForLoanValue() throws Exception {
        
		MortgageRequest mortgageRequest = new MortgageRequest();
		mortgageRequest.setIncome(7000);
		mortgageRequest.setMaturityPeriod(10);
		mortgageRequest.setLoanValue(15000);
		mortgageRequest.setHomeValue(14000);
		
		MortgageResponse mortgageResponse = mortgageController.mortgageCheck(mortgageRequest);
		
		assertEquals(false, mortgageResponse.getFeasibleMortgage());
		
    }
}
