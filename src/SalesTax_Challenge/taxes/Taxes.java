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
	
	
	void calculateTaxRate(Item item) {
		
		//use getters and setters for tax
		
		if(item.isImported())
			taxRate+=getImportedTaxRate();
		
		if(!item.isExempted())
			taxRate+=getNonExemptedTaxRate();
		
	}
	
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
	
	//
	
	
	/**
	 * 
	 * @param taxAmount - the tax calculated until now
	 * @return taxAmount rounded to the nearest 0.05
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