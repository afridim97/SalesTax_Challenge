
import java.util.*;
import java.io.*;

public class Billing {

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
		
		Taxes tax=new Taxes();
	
		while(in.hasNextLine()) {
				
			String line=in.nextLine();
			
			initializeItem(line);
			
			calculateTotalBeforeTax(item);
			
			totalTax+=tax.calculateTaxValue(item);
			
			items.add(item);
		}
		
		in.close();
		
		generateReceipt(new Receipt(items,totalTax,total));
	}
	
	
	/**
	* The line will contain the entry of the first purchase,
	* e.g. "1 imported chocolate at 12.50"
	*/
	
	void initializeItem(String line) {
		
		String[] words=line.split(" ");
		
		String name="";
		
		ItemFactory itemfact=new ItemFactory();
		
		if(!line.contains("imported")) {
			
			name=words[1];
			
			item=itemfact.getItem(name);
			
			item.imported=false;
			
		}
		
		else {
			
			name=words[2];
			
			item=itemfact.getItem(name);
			
			item.imported=true;
			
		}
		
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
	
	void generateReceipt(Receipt r) {
		
		r=new Receipt(items,totalTax,total);
		
		r.printReceipt();
		
	}
		
		
	
}
