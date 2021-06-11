
class Taxes{
	
	private double taxRate;
	
	private double importedTaxRate;
	
	private double nonExemptedTaxRate;
	
	Taxes(){
		
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
	
	double calculateTaxValue(Item item) {
		
		calculateTaxRate(item);
		
		return taxRate*item.getPrice();
		
	}
	
	
	
	void setImportedTaxRate(double importedTaxRate) {
		
		this.importedTaxRate=importedTaxRate;
		
	}
	
	double getImportedTaxRate() {
		
		return this.importedTaxRate;
		
	}
	
	void setNonExemptedTaxRate(double nonExemptedTaxRate) {
		
		
		this.nonExemptedTaxRate=nonExemptedTaxRate;
		
	}
	
	double getNonExemptedTaxRate() {
		
		return this.nonExemptedTaxRate;
		
	}
	
	//can be done in receipt
	
	/**double calculateTotalBeforeTax(Item item) {
		
		return item.getPrice()*(double)item.getQuantity();
		
	}
	
	double calculateTax(Item item) {
		
		return calculateTaxRate(item)*item.getPrice();
		
	}
	
	*/
	
	
}