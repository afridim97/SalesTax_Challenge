
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
			
			item=new Item();
			
			//initialise Item object with parameters given in input line
			
			createItem(line);
			
			
			for(int i=0;i<item.getQuantity();i++) {
					
				Taxes tax=new Taxes();
				
				//price before applying tax
				
				total+=tax.calculateTotalBeforeTax(item);
				
				//finding total of sales + import tax rate, wherever applicable
				
				double taxRate=tax.calculateTaxRate(item);
				
				//calculate tax applied on item
				
				double taxOnItem=tax.calculateTaxAmount(item,taxRate);
				
				//update price of item to include tax on it
						
				item.setPrice(item.getPrice()+taxOnItem);
				
				//update total price and cost by adding tax
				
				total+=taxOnItem;
				
				totalTax+=taxOnItem;
				
			}
		
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
		
		//name is what comes between quantity and price in line
		
		item.setName(line.substring(1,splitIndex));
		
		//method to find item type based on item name and import/domestic status
		
		item.setItemType(findItemType(item.getName()));
		
		//first word in line is quantity
		
		item.setQuantity(Integer.parseInt(line.substring(0,1)));
		

		
	}
	/**
	 * 
	 * @param name - name of item
	 * @return item type based on which we will determine sales and import tax
	 */
	
	ItemType findItemType(String name){
		
		//check if given item comes in list of exempted items
		
		int indexOfExemptedList=checkIfItemExempted(name,item.getExemptedItems());
		
		String exemptedType=null;
		
		//if item is contained in list of exempted items, assign that item to exemptedType
		
		if(indexOfExemptedList!=-1)
			exemptedType=item.getExemptedItems().get(indexOfExemptedList);
		
		if(name.contains("imported")){
			
			//if exempted, sales tax is excluded but import tax applies
			
			if(exemptedType!=null) {
			
			if(exemptedType.equals("book"))
				return ItemType.IMPORTED_BOOK;
			
			if(exemptedType.equals("chocolates"))
				return ItemType.IMPORTED_FOOD;
			
			if(exemptedType.equals("pills"))
				return ItemType.IMPORTED_MEDICINES;
					
			}
			
			else
				return ItemType.IMPORTED_OTHERS;
			
		}
		
		else {
			
			/**
			 * Items bought locally, so import tax not applicable
			 * If item is exempted, sales tax also not applicable
			 */
			
			if(exemptedType!=null){
				
				
				if(exemptedType.equals("book"))
					return ItemType.BOOK;
				
				if(exemptedType.equals("chocolate"))
					return ItemType.FOOD;
				
				if(exemptedType.equals("pills"))
					return ItemType.MEDICINES;
						
				}
		
			}
		
		//if item bought domestically and not exempted
		
		return ItemType.OTHERS;
		
	}
	
	/**
	 * 
	 * @param line - input line
	 * @param exemptedItems - list of items exempted from sales tax (books, food, medicine)
	 * @return index of item in exempted items list, if found in input line
	 */
		
	public int checkIfItemExempted(String line, List<String> exemptedItems) {
	
		int index=-1;
		
		for(int i=0;i<exemptedItems.size();i++) {
			
			//return index value of item in exempted items found in line
			
			index=line.indexOf(exemptedItems.get(i));
			
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
		
		int numOfItems = items.size();
		for(int i = 0;i<numOfItems;i++){
			System.out.println(items.get(i).getQuantity() + items.get(i).getName() + "at " + (float)items.get(i).getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + (float)total);
	}
		
	
	
	
}
