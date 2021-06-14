
import java.util.*;

public class Receipt {

	private List<Item> items;

	private double totalTax;

	private double total;

	Receipt(List<Item> items, double total, double totalTax){
		
		this.items=new ArrayList<>();
		
		this.total=total;
		
		this.totalTax=totalTax;
		
	}
	
	public List<Item> getItems() {
		
		return items;
		
	}
	
	public void setItems(List<Item> items) {
		
		this.items=items;
		
	}

	public void printReceipt(){
		/*
		 * Print all the information about the Receipt  
		 * 
		 */
		
		items=getItems();
		
		for(Item item:items){
			System.out.println(item.getQuantity()+item.getItemType() + " at " + (float)item.getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + (float)total);
	}
		
	
	
	
}
