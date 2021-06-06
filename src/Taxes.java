
public class Taxes {

	/**
	 * 
	 * @param item - the item for which we are calculating tax
	 * @return item.getPrice() - price of item before tax is calculated
	 */
	
public double calculateTotalBeforeTax(Item item){
		
		
		return item.getPrice();
		
		
	}

/**
 * 
 * @param item
 * @return taxRate - rate of tax inclusive of sales tax and import tax
 */

public double calculateTaxRate(Item item) {
	
	double taxRate=0.0;
	
	//if exempted from sales tax and import tax, no tax added
	
	if(item.isSalesTaxable()) { 
	
		//10% sales tax if item not exempt
		
		taxRate+=10.0;

	
	}
	
	if(item.isImportTaxable()) {
		
		//5% sales tax on imported items
		
		taxRate+=5.0;
		
	}
	

	return taxRate;
	
}

public double calculateTaxAmount(Item item, double taxRate) {
	
	if(taxRate==0.0)
		return 0.0;
	
	double taxAmount=0.0;
		
	//tax amount = (n*p)/100, where n=tax rate, p=price
	
	taxAmount=(item.getPrice()*taxRate)/100.0;
	
	//taxAmount rounded to the nearest 0.05
	taxAmount = round(taxAmount);
	

	return taxAmount;
	
}

/**
 * 
 * @param taxAmount - the tax calculated until now
 * @return taxAmount rounded to the nearest 0.05
 */

public double round(double taxAmount) {
	
	//taking the whole number only
	
	int x = (int)(taxAmount*10);
	
	//separating fractional part from whole number 
	
	double temp = (taxAmount * 10) - (x);
	
	//rounding up or down based on value of fractional part
	
	if (temp < 0.25)	temp = 0.0;
	else if (temp >= 0.25 && temp <= 0.50)	temp = 0.5;
	else	temp = 1.0;

	//adding rounded fractional part to original whole number
	
	return (temp + (double)x) / 10;
	
}


}
