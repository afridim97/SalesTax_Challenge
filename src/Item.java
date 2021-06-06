
import java.util.*;

enum ItemType{
	
	//sales tax exempted domestic list
	BOOK(true,false),
	MEDICINES(true,false),
	FOOD(true,false),
	
	//sales tax non-exempted domestic list
	OTHERS (false,false),
	
	//sales tax exempted imported list
	IMPORTED_BOOK(true,true),
	IMPORTED_MEDICINES(true,true),
	IMPORTED_FOOD(true,true),
	
	//non sales tax exempted imported list 
	IMPORTED_OTHERS(false,true);

	
	private boolean isExempted;
	
	private boolean isImported;
	
	ItemType(boolean exempted,boolean imported){
		
		this.isExempted=exempted;
		
		this.isImported=imported;
	}
	
	public boolean isImported() {
		
		return isImported;
		
	}
	
	public boolean isExempted() {
		
		return isExempted;
		
	}
	
	
}


public class Item {

	private String name;
	private double price;
	private int quantity;
	private ItemType itemType;
	
	private List<String> exemptedItems;
	
	public Item(){
		
		this.name="";
		
		this.price=0.0;
		
		this.quantity=0;
		
		this.itemType=ItemType.OTHERS;
		
		this.exemptedItems=new ArrayList<String>(Arrays.asList("book","chocolates","pills"));
		
	}
	
	/*
	 * public Item(String name, double price, int quantity, ItemType itemType) {
		
		this.setName(name);
		
		this.setPrice(price);
		
		this.itemType = itemType;
		
		this.setQuantity(quantity);
		
	}
	
	 */
	public List<String> getExemptedItems(){
		
		return exemptedItems;
		
	}
	

	public String toString(){
		return this.name + this.getPrice();
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ItemType getItemType() {
		
		return itemType;
		
	}
	
	public void setItemType(ItemType itemType) {
		
		this.itemType=itemType;
		
	}
	
	public boolean isSalesTaxable() {
		return !this.itemType.isExempted();
	}

	public boolean isImportTaxable() {
		return this.itemType.isImported();
	}

	
	
}
