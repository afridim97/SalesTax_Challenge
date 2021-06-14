
import java.util.*;
import java.io.*;

public class Billing {

	private Receipt r;
	
	private List<Item> items;
	
	private String inputFileName;
	
	private Item item;
	
	private double totalTax;
	
	private double total;
	
	Billing(String inputFileName){
		
		this.items=new ArrayList<>();
		
		this.inputFileName=inputFileName;
	
	}
	
	void addItemToReceipt() throws FileNotFoundException {
		
		//generate a new file at the given location and read from it
		
		File file=new File(inputFileName);
		
		Scanner in=new Scanner(file);
	
		while(in.hasNextLine()) {
				
			String line=in.nextLine();
			
			initializeItem(line);
			
			processTax(item);
			
			items.add(item);
		}
		
		in.close();
		
		generateReceipt();
	}
	
	
	/**
	* The line will contain the entry of the first purchase,
	* e.g. "1 imported chocolate at 12.50"
	*/
	
	void initializeItem(String line) {
			
		ItemFactory itemfact=new ItemFactory();
		
		item=itemfact.getItem(line);
		
		item.imported=line.contains("imported")?true:false;
		
		setPriceandQuantity(line);
		
	}
	
		
	void setPriceandQuantity(String line) {
			
		//Price comes after last "at" in input line, e.g. "2 chocolates at 10.50"
			
		int splitIndex=-1;
			
		splitIndex=line.lastIndexOf("at");
			
		//if "at" is never found in line, we cannot find price
			
		if(splitIndex==-1)
			System.out.println("Bad formatting");
			
		//update item price accordingly
			
		item.setPrice(Double.parseDouble(line.substring((splitIndex+2))));
		
		//first word in line is quantity
			
		item.setQuantity(Integer.parseInt(line.substring(0,1)));
			
		}
	
	double calculateTotalBeforeTax(Item item) {
		
		return item.getPrice()*(double)item.getQuantity();
		
	}
	
	void processTax(Item item) {
		
		Taxes tax=new Taxes();
		
		total+=calculateTotalBeforeTax(item);
		
		double taxOnItem=tax.calculateTaxValue(item);
		
		total+=(taxOnItem*item.getQuantity());
		
		totalTax+=(taxOnItem*item.getQuantity());
		
		item.setPrice(item.getPrice()+taxOnItem);
		
	}
	
	void generateReceipt() {
		
		r=new Receipt(items, total, totalTax);
				
		r.setItems(items);
		
		r.printReceipt();
		
	}
		
		
	
}
