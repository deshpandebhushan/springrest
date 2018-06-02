package com.bd.mortgage.model;

import java.io.Serializable;

/**
 * 
 * @author bhushan
 * MortgageResponse
 *
 */
public class MortgageResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Boolean feasibleMortgage;
	private double monthlyCosts;
	
	public Boolean getFeasibleMortgage() {
		return feasibleMortgage;
	}
	public void setFeasibleMortgage(Boolean feasibleMortgage) {
		this.feasibleMortgage = feasibleMortgage;
	}
	public double getMonthlyCosts() {
		return monthlyCosts;
	}
	public void setMonthlyCosts(double monthlyCosts) {
		this.monthlyCosts = monthlyCosts;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feasibleMortgage == null) ? 0 : feasibleMortgage.hashCode());
		long temp;
		temp = Double.doubleToLongBits(monthlyCosts);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MortgageResponse other = (MortgageResponse) obj;
		if (feasibleMortgage == null) {
			if (other.feasibleMortgage != null)
				return false;
		} else if (!feasibleMortgage.equals(other.feasibleMortgage))
			return false;
		if (Double.doubleToLongBits(monthlyCosts) != Double.doubleToLongBits(other.monthlyCosts))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MortgageResponse [feasibleMortgage=" + feasibleMortgage + ", monthlyCosts=" + monthlyCosts + "]";
	}
	
	
}
