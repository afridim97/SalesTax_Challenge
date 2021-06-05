
import java.io.File;
import java.util.*;
import java.math.*;
import java.text.DecimalFormat;

public class Receipt {

	/**
	 * declared "products" - list to store all the products being bought, totalTax and totalPrice to store the
	 * totals of tax and overall total price for customer respectively
	 */
	
	private List<Product> products=new ArrayList<>();
	
	private double totalTax;
	
	private double totalPrice;
	
	@SuppressWarnings("resource")
	Receipt(String inputFileName){
		
		try{
			
		Scanner in=new Scanner(System.in); //creates a Scanner object
		
		File file=new File(inputFileName); //create a File object
		
		in=new Scanner(file); //initialise Scanner object with the file
		
		while(in.hasNextLine()) {
				
			/**
			* The line will contain the entry of the first purchase,
			* e.g. "1 imported chocolate at 12.50"
			*/
			
			String line=in.nextLine(); 
			
			// Array contains only the words in the line
			
			String[] words=line.split(" ");
			
			//first word will be quantity of product being purchased
			
			int quantity=Integer.parseInt(words[0]);
			
			//check for any mention of product being imported
			
			boolean isImported=line.contains("imported");
			
			String[] itemsExempted =  new String[]{"book","chocolate","pills","meds"};
			
			int exemptedIndex=checkIfItemExempted(line,itemsExempted);
			
			String exemptedItem=null;
			
			if(exemptedIndex!=-1) {
				
				/**
				 * If item is exempt of sales tax
				 */
				
				exemptedItem=itemsExempted[exemptedIndex];
				
			}
		
			int splitIndex=line.lastIndexOf("at");
			
			if(splitIndex==-1) {
				
				System.out.println("Bad format");
				
			}
			
			else {
				
				//after "at " comes the price
				
				Float price=Float.parseFloat(line.substring(splitIndex+2));
				
				//everything between quantity and price is name
				
				String name=line.substring(1,splitIndex);
				
			
			//collecting all the products
			
			for(int i=0;i<quantity;i++) {
				
				Product newProduct=null;
				
				/**
				 * Three types of categories:
				 * 1) Imported and exempted from sales tax
				 * 
				 * 2) Imported and not exempt from sales tax
				 * 
				 * 3) Domestic and not exempt from sales tax
				 */
				
		if(isImported) {
			
				//if product is imported 
				if(exemptedItem!=null) {
					
					//the product is imported + exempt of sales tax
					
					if(exemptedItem.equals("book")) {
						
						newProduct=new Product(name,price,Item.IMPORTED_BOOK);
						
					}
					
					if(exemptedItem.equals("chocolate")) {
						
						newProduct=new Product(name,price,Item.IMPORTED_FOOD);
						
					}
					
					if(exemptedItem.equals("pills")) {
						
						newProduct=new Product(name,price,Item.IMPORTED_MEDICINES);
						
					}
					
					
				}
				
				else {
					
					//product is imported but not exempt from sales tax
					
					newProduct=new Product(name,price,Item.IMPORTED_OTHERS);
					
				}
				
			}
		
		else {
			
			if(exemptedItem!=null) {
				
				//the product is domestic + exempt of sales tax
				
				if(exemptedItem.equals("book")) {
					
					newProduct=new Product(name,price,Item.BOOK);
					
				}
				
				if(exemptedItem.equals("chocolate")) {
					
					newProduct=new Product(name,price,Item.FOOD);
					
				}
				
				if(exemptedItem.equals("pills")) {
					
					newProduct=new Product(name,price,Item.MEDICINES);
					
				}
				
				
			}
		
		
		else {
				//product is domestic + not exempt of sales  tax
				newProduct=new Product(name,price,Item.OTHERS);
			}
				
			
		}
		
		products.add(newProduct);
		
				}	
			
			}
			
		}
		
		in.close();
		
			}		
		catch(Exception e) {
			
			e.printStackTrace();
			
			}
		
		}
	
	public void calculateTotal(){
		
		/**
		 * Calculate total with price of each item added + taxes applicable to it (sales, import)
		 */
		
		int totalItems=products.size();
	
		BigDecimal runningTotal=new BigDecimal("0");
		
		BigDecimal runningTax=new BigDecimal("0");
		
		for(int i=0;i<totalItems;i++){
			
			runningTax=BigDecimal.valueOf(0);
			
			BigDecimal totalBeforeTax=new BigDecimal(String.valueOf(this.products.get(i).getPrice()));
			
			runningTotal=runningTotal.add(totalBeforeTax);
			
			if(products.get(i).isSalesTaxable()) {
				
				// (10% sales tax)
				
				BigDecimal salesTaxPercent=new BigDecimal(".10");
				
				//multiply sales tax % with price of item before tax added
				
				BigDecimal salesTax=salesTaxPercent.multiply(totalBeforeTax);
				
				//rounding up to the nearest 0.05
				
				salesTax = round(salesTax, BigDecimal.valueOf(0.05), RoundingMode.UP);
				
				//add tax calculated so far
				
			    runningTax=runningTax.add(salesTax);
				
			}
			
			if(products.get(i).isImportTaxable()) {
				
				//5% import tax
				
				BigDecimal importTaxPercent=new BigDecimal(".05");
				
				//multiply sales tax % with price of item before tax added
				
				BigDecimal importTax=importTaxPercent.multiply(totalBeforeTax);
				
				//rounding up to the nearest 0.05
				
				importTax = round(importTax, BigDecimal.valueOf(0.05), RoundingMode.UP);
				
				//add tax calculated so far
				
			    runningTax = runningTax.add(importTax);
				
			}
			
			products.get(i).setPrice(runningTax.floatValue()+products.get(i).getPrice());
			
			totalTax+=runningTax.doubleValue();
			
			runningTotal=runningTotal.add(runningTax);
			
		}
		
		//total tax and price after adding all items
		
		totalTax=roundToTwoDecimals(totalTax);
		
		totalPrice=runningTotal.doubleValue();
		
		
	}
	
	public static BigDecimal round(BigDecimal value, BigDecimal increment,RoundingMode roundingMode) {
		/*
		 * This method handles custom rounding to 0.05, and also sets the BigDecimal numbers to use 2 decimals
		 * 
		 */
		if (increment.signum()==0) {
		//if value to be incremented by is 0, no need to proceed further
		
			return value;
		
		} 
		else {
			
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			
			BigDecimal result = divided.multiply(increment);
			
			result.setScale(2, RoundingMode.UNNECESSARY);
			
			return result;
		}
		
	}
	
	public double roundToTwoDecimals(double d) {
		//A rounding method for double values to 2 decimals
		
	    DecimalFormat twoDecimalForm = new DecimalFormat("#.##");
	    
	    return Double.valueOf(twoDecimalForm.format(d));
	}
		
	public static int checkIfItemExempted(String line,String[] exemptedItems) {
	
		int index=-1;
		
		for(int i=0;i<exemptedItems.length;i++) {
			
			index=line.indexOf(exemptedItems[i]);
			
			if(index!=-1)
				return i;
			
		}
		
		return -1;
		
	}
	
	public void printReceipt(){
		/*
		 * Print all the information about the Receipt  
		 * 
		 */
		int numOfItems = products.size();
		for(int i = 0;i<numOfItems;i++){
			System.out.println("1" + products.get(i).getName() + "at " + products.get(i).getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + totalPrice);
	}
		
	
	
	
}
