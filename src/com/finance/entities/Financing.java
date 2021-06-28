package com.finance.entities;

public class Financing {
	private double totalAmount;
	private double income; 
	private int months;
	
	private double entry;
	
	public void finance() {}
	
	public Financing(double amount, double income, int months, double entry) {
		super();
		this.totalAmount = amount;
		this.income = income;
		this.months = months;
		this.entry = entry;
		
		this.validateFinance();
	}
	
	
	private void validateFinance() {
		//O valor da entrada deve ser 20% do montante
		this.checkTotalAmount(this.totalAmount);
		
		//O valor da prestação não pode ser maior que metade da renda do cliente.
		this.checkIncome(this.income);
		
	}
	
	private void checkTotalAmount(double totalAmount) {
		double percAcceptableEntry = .2d;
		double entryExpected = totalAmount * percAcceptableEntry; 
		
		if(this.entry != entryExpected) {
			throw new IllegalArgumentException("Valor da entrada deve ser "+entryExpected);
		}
	}
	
	private void checkIncome(double income) {
		if(this.quota() > income / 2  ) {
			throw new IllegalArgumentException("Valor da parcela deve ser inferior a 50% do salário");
		}
	}
	
	private void checkMonths(int months) {
		if(this.quota(months) > income / 2  ) {
			throw new IllegalArgumentException("Valor da parcela deve ser inferior a 50% do salário");
		}
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.checkTotalAmount(totalAmount);
		this.totalAmount = totalAmount;		
	}

	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.checkIncome(income);
		this.income = income;
	}
	public double getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.checkMonths(months);
		this.months = months;
	}

	public void setEntry(double entry) {
		
		this.entry = entry;
		this.validateFinance();		
	}

	
	
	public double entry() {
		return this.totalAmount * 0.2;
	}
	
	public double quota() {
		//O valor da prestação deve ser os 80% restantes do montante, divididos pelo número de meses do financiamento.
		double totalFinance = this.totalAmount -  this.totalAmount * 0.2;
		return totalFinance / this.months;
	}
	
	public double quota(int months) {
		//O valor da prestação deve ser os 80% restantes do montante, divididos pelo número de meses do financiamento.
		double totalFinance = this.totalAmount -  this.totalAmount * 0.2;
		return totalFinance / months;
	}
	
}
