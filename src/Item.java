enum ItemType{
	
	BOOK(true,false),
	MEDICINES(true,false),
	FOOD(true,false),
	OTHERS (false,false),
	IMPORTED_BOOK(true,true),
	IMPORTED_MEDICINES(true,true),
	IMPORTED_FOOD(true,true),
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
	private ItemType itemType;
	
	public Item(String name, double price, ItemType itemType) {
		this.name = name;
		
		this.setPrice(price);
		
		this.itemType = itemType;
		
	}
	
	public String toString(){
		return this.name + this.getPrice();
	}

	public double getPrice() {
		return price;
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
	
	public boolean isSalesTaxable() {
		return !this.itemType.isExempted();
	}

	public boolean isImportTaxable() {
		return this.itemType.isImported();
	}

	
	
}
