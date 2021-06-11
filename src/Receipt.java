
import java.io.*;
import java.util.*;

public class Receipt {

	/**
	 * items - list to store each item being purchased
	 * totalTax - sum total of sales and import tax on all items
	 * total - sum total of price of items 
	 * item - the item object to be used in calculation
	 * 
	 */
	
	private List<Item> items=new ArrayList<>();
	
	private double totalTax;
	
	private double total;
	
	private Item item;
	
	@SuppressWarnings("resource")
	Receipt(String inputFileName){
		
		try{
			
		Scanner in=new Scanner(System.in);
		
		//generate a new file at the given location and read from it
		
		File file=new File(inputFileName);
		
		in=new Scanner(file);
		
		while(in.hasNextLine()) {
				
			/**
			* The line will contain the entry of the first purchase,
			* e.g. "1 imported chocolate at 12.50"
			*/
			
			String line=in.nextLine();
			
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
					
			//initialise Item object with parameters given in input line
			
				createItem(line);
				
				//price before applying tax
				
				total+=calculateTotalBeforeTax(item);
				
				//finding total of sales + import tax rate, wherever applicable
				
				//calculate tax applied on item
				
				Taxes tax=new Taxes();
				
				double taxOnItem=tax.calculateTaxValue(item);
				
				//update price of item to include tax on it
						
				item.setPrice((item.getPrice()+taxOnItem)*item.getQuantity());
				
				//update total price and cost by adding tax
				
				total+=taxOnItem;
				
				totalTax+=taxOnItem;
				
			//}
		
			//add to list of items
			
			items.add(item);
		
			}
		
		
		in.close();
		
		}
		
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			}
		
		}
	
	/**
	 * 
	 * @param line - line of input 
	 * 
	 * Initializes item object with parameters based on details given in input line
	 */
		
	
	void createItem(String line) {
		
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
	
	
	

	public void printReceipt(){
		/*
		 * Print all the information about the Receipt  
		 * 
		 */
		
		int numOfItems=items.size();
		for(int i = 0;i<numOfItems;i++){
			System.out.println(items.get(i).getQuantity() + " "+items.get(i).getItemType() + "at " + (float)items.get(i).getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + (float)total);
	}
		
	
	
	
}
