enum Item{
	
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
	
	Item(boolean exempted,boolean imported){
		
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


public class Product {

	private String name;
	private float price;
	private Item type;
	
	public Product(String name, float price, Item itemType){
		this.name = name;
		this.setPrice(price);
		
		this.type = itemType;
		
	}
	
	public String toString(){
		return this.name + this.getPrice();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSalesTaxable() {
		return !this.type.isExempted();
	}

	public boolean isImportTaxable() {
		return this.type.isImported();
	}

	
	
}
