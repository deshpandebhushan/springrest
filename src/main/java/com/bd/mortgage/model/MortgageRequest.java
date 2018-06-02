package com.bd.mortgage.model;

import java.io.Serializable;

/**
 * 
 * @author bhushan
 * MortgageRequest
 *
 */
public class MortgageRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double income;
	private Integer maturityPeriod;
	private double loanValue;
	private double homeValue;
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public double getLoanValue() {
		return loanValue;
	}
	public void setLoanValue(double loanValue) {
		this.loanValue = loanValue;
	}
	public double getHomeValue() {
		return homeValue;
	}
	public void setHomeValue(double homeValue) {
		this.homeValue = homeValue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(homeValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(income);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(loanValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((maturityPeriod == null) ? 0 : maturityPeriod.hashCode());
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
		MortgageRequest other = (MortgageRequest) obj;
		if (Double.doubleToLongBits(homeValue) != Double.doubleToLongBits(other.homeValue))
			return false;
		if (Double.doubleToLongBits(income) != Double.doubleToLongBits(other.income))
			return false;
		if (Double.doubleToLongBits(loanValue) != Double.doubleToLongBits(other.loanValue))
			return false;
		if (maturityPeriod == null) {
			if (other.maturityPeriod != null)
				return false;
		} else if (!maturityPeriod.equals(other.maturityPeriod))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MortgageRequest [income=" + income + ", maturityPeriod=" + maturityPeriod + ", loanValue=" + loanValue
				+ ", homeValue=" + homeValue + "]";
	}
	
	
}
