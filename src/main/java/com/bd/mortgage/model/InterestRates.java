package com.bd.mortgage.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author bhushan
 * InterestRates
 *
 */
public class InterestRates implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer maturityPeriod;
	private double interestRate;
	private Timestamp lastUpdate;
	
	public InterestRates(Integer maturityPeriod, double interestRate, Timestamp lastUpdate) {
		super();
		this.maturityPeriod = maturityPeriod;
		this.interestRate = interestRate;
		this.lastUpdate = lastUpdate;
	}
	
	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(interestRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
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
		InterestRates other = (InterestRates) obj;
		if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
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
		return "InterestRates [maturityPeriod=" + maturityPeriod + ", interestRate=" + interestRate + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
}
