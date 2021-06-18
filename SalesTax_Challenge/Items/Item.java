package com.SalesTax_Challenge.Items;


public abstract class Item {

	private String itemName;
	private double price;
	private int quantity;
	private boolean exempted, imported;
	
	public Item(){
		
		this.itemName="";
		
		this.price=0.0;
		
		this.quantity=0;
		
		this.exempted=false;
		
		this.imported=false;
		
	}
	
	  public Item(String itemName, double price, int quantity, boolean imported, boolean exempted) {
		
		this.setItemType(itemName);
		
		this.setPrice(price);
			
		this.setQuantity(quantity);
		
		this.setImported(imported);
		
		this.setExempted(exempted);
		
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
	
	public String getItemName() {
		return itemName;
	}

	public void setItemType(String itemName) {
		this.itemName=itemName;
	}
	
	public void setExempted(boolean exempted) {
		
		this.exempted=exempted;
		
	}
	
	public void setImported(boolean imported) {
		
		this.imported=imported;
		
	}

	public boolean isExempted() {
		
		return this.exempted;
	}
	
	public boolean isImported() {
		
		return this.imported;
	}
	
}

