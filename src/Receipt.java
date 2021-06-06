
import java.io.File;
import java.util.*;

public class Receipt {

	/**
	 * declared "products" - list to store all the products being bought, totalTax and totalPrice to store the
	 * totals of tax and overall total price for customer respectively
	 */
	
	private List<Item> items=new ArrayList<>();
	
	private double totalTax;
	
	private double total;
	
	@SuppressWarnings("resource")
	Receipt(String inputFileName){
		
		try{
			
		Scanner in=new Scanner(System.in);
		
		File file=new File(inputFileName);
		
		in=new Scanner(file);
		
		while(in.hasNextLine()) {
				
			/**
			* The line will contain the entry of the first purchase,
			* e.g. "1 imported chocolate at 12.50"
			*/
			
			String line=in.nextLine();
			
			int quantity=parseInput(line);
			
			Item item=null;
			
			for(int i=0;i<quantity;i++) {
			
				item=createItem(line);
				
				Taxes tax=new Taxes();
				
				total+=tax.calculateTotalBeforeTax(item);
				
				double taxRate=tax.calculateTaxRate(item);
				
				double taxOnItem=tax.calculateTaxAmount(item,taxRate);
				
				item.setPrice(item.getPrice()+taxOnItem);
				
				total+=taxOnItem;
				
				totalTax+=taxOnItem;
				
			}
		
			items.add(item);
		
			}
		
		
		in.close();
		
		}
		
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			}
		
		}
	
	public int parseInput(String line) {
		
		String[] details=line.split(" ");
		
		int quantity=Integer.parseInt(details[0]);
		
		return quantity;
		
	}
	
	Item createItem(String line) {
		
		int splitIndex=line.lastIndexOf("at");
		
		double price=Double.parseDouble(line.substring((splitIndex+2)));
		
		String name=line.substring(1,splitIndex);
		
		ItemType itemType=findItemType(name);
		
		return new Item(name,price,itemType);
		
	}
	
	ItemType findItemType(String name){
		
		String[] exemptedItems= {"book","chocolate","pills"};
		
		int isExempted=checkIfItemExempted(name,exemptedItems);
		
		String exemptedType=null;
		
		if(isExempted!=-1)
			exemptedType=exemptedItems[isExempted];
		
		if(name.contains("imported")){
			
			//if exempted, sales tax is excluded but import tax applies
			
			if(exemptedType!=null) {
			
			if(exemptedType.equals("book"))
				return ItemType.IMPORTED_BOOK;
			
			if(exemptedType.equals("chocolate"))
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
		int numOfItems = items.size();
		for(int i = 0;i<numOfItems;i++){
			System.out.println("1" + items.get(i).getName() + "at " + (float)items.get(i).getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + (float)total);
	}
		
	
	
	
}
