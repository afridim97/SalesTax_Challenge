
import java.util.*;

abstract class Item {

	private String itemType;
	private double price;
	private int quantity;
	private boolean exempted;
	private boolean imported;
	
	public Item(){
		
		this.itemType="";
		
		this.price=0.0;
		
		this.quantity=0;
		
		this.exempted=false;
		
		this.imported=false;
		
	}
	

	  public Item(String itemType, double price, int quantity, boolean exempted, boolean imported) {
		
		this.setItemType(itemType);
		
		this.setPrice(price);
			
		this.setQuantity(quantity);
		
		this.exempted=exempted;
		
		this.imported=imported;
		
	}
	

	public String toString(){
		return this.itemType+this.getPrice();
	}

	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		
		return quantity;
		
	}
	
	public void setQuantity(int quantity) {
		
		this.quantity=quantity;	
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType=itemType;
	}

	boolean isExempted() {
		
		return this.exempted;
	}
	
	boolean isImported() {
		
		return this.imported;
	}
	
}
