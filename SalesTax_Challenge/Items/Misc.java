package com.SalesTax_Challenge.Items;

public class Misc extends Item{

	public Misc(){
		
		super();
	}
	
	public Misc(String itemType,double price,int quantity,boolean imported, boolean exempted){
		
		super(itemType,price,quantity,imported,false);
		
	}
	
	
}
