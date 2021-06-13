
import java.util.*;

public class Receipt {

	private List<Item> items;

	private double totalTax;

	private double total;

	Receipt(List<Item> items, double totalTax, double total){
		
		this.items=new ArrayList<>();
	
		this.totalTax=totalTax;
		
		this.total=total;
	}
	
	

	public void printReceipt(){
		/*
		 * Print all the information about the Receipt  
		 * 
		 */
	
		for(Item item:items){
			System.out.println(item.getQuantity() + " "+item.getItemType() + "at " + (float)item.getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + (float)total);
	}
		
	
	
	
}
