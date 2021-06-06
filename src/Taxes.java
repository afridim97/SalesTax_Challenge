

public class Taxes {

	
public double calculateTotalBeforeTax(Item item){
		
		
		return item.getPrice();
		
		
	}

public double calculateTaxRate(Item item) {
	
	double taxRate=0.0;
	
	//if exempted from sales tax and import tax, no tax added
	
	if(item.isSalesTaxable()) { 
	
		taxRate+=10.0;

	
	}
	
	if(item.isImportTaxable()) {
		
		taxRate+=5.0;
		
	}
	

	return taxRate;
	
}

public double calculateTaxAmount(Item item, double taxRate) {
	
	if(taxRate==0.0)
		return 0.0;
	
	double taxAmount=0.0;
			
	taxAmount=(item.getPrice()*taxRate)/100.0;

	
	return round(taxAmount);
	
}

/**
 * 
 * @param taxAmount - the tax calculated until now
 * @return taxAmount rounded to the nearest 0.05
 */

public double round(double taxAmount) {
	
	int x=(int) taxAmount;
	
	
	
	//find fractional part by subtracting int from double
	
	double temp=(taxAmount-x);

	
	//decide whether to round up or down accordingly
	
	if(temp<0.25)
		temp=0.0;
	else if(temp>=0.25&&temp<=0.5)
		temp=0.5;
	else
		temp=1.00;

	return (temp+(double)x);
	
}


}
