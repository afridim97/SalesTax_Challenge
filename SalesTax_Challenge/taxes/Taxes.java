package com.SalesTax_Challenge.taxes;

import com.SalesTax_Challenge.Items.Item;

public class Taxes{
	
	private double taxRate;
	
	private double taxValue;
	
	private double importedTaxRate;
	
	private double nonExemptedTaxRate;
	
	public Taxes(){
		
		this.taxRate=0.0;
		
		setImportedTaxRate(0.05);
		
		setNonExemptedTaxRate(0.10);
		
	}
	

	/**
	 * 
	 * @param item - item for which tax rate is being calculated
	 * 
	 * If item is imported, add 5% import tax (as per problem statement)
	 * If item is not exempted from sales tax, add 10% basic sales tax (as per problem statement)
	 */
	
	void calculateTaxRate(Item item) {
		
		if(item.isImported())
			taxRate+=getImportedTaxRate();
		
		if(!item.isExempted())
			taxRate+=getNonExemptedTaxRate();
		
	}
	
	/**
	 * @param item - item for which tax is being calculated
	 *  To get the tax on item, multiply rate of tax with price on item
	 *  Rounds tax up to nearest 0.05 (as per problem statement)
	 */
	
	public double calculateTaxValue(Item item) {
		
		calculateTaxRate(item);
		
		taxValue=taxRate*item.getPrice();
		
		return round(taxValue);		
	}
	
	
	
	public void setImportedTaxRate(double importedTaxRate) {
		
		this.importedTaxRate=importedTaxRate;
		
	}
	
	public double getImportedTaxRate() {
		
		return this.importedTaxRate;
		
	}
	
	public void setNonExemptedTaxRate(double nonExemptedTaxRate) {
		
		
		this.nonExemptedTaxRate=nonExemptedTaxRate;
		
	}
	
	public double getNonExemptedTaxRate() {                                                   
		
		return this.nonExemptedTaxRate;
		
	}
	
	public double getTaxRate() {
		
		return taxRate;
	}
	
	public void setTaxRate(double taxRate) {
			
			this.taxRate=taxRate;
	}
	
	public double getTaxValue() {
		
		return taxValue;
	}
	
	public void setTaxValue(double taxValue) {
		
		this.taxValue=taxValue;
		
	}
	
	/**
	 * @param taxValue - the tax calculated until now
	 * @return taxValue - sales tax rounded up to the nearest 0.05
	 */

	public double round(double taxValue) {
		
		//taking the whole number only
		
		int x = (int)(taxValue*10);
		
		//separating fractional part from whole number 
		
		double temp = (taxValue * 10) - (x);
		
		//rounding up or down based on value of fractional part
		
		if (temp < 0.25)	temp = 0.0;
		else if (temp >= 0.25 && temp <= 0.50)	temp = 0.5;
		else	temp = 1.0;

		//adding rounded fractional part to original whole number
		
		return (temp + (double)x) / 10;
		
	}
	
	
}