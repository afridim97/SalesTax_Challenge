
class Taxes{
	
	double calculateTaxRate(Item item) {
		
		double taxrate=0.0;
		
		if(!item.isExempted()) {
			
			taxrate+=0.1;
			
		}
		
		if(item.isImported()) {
			
			taxrate+=0.05;
			
		}
		
		return taxrate;
		
	}
	
	double calculateTax(Item item) {
		
		return calculateTaxRate(item)*item.getPrice();
		
	}
	
	
	
}