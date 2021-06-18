package com.SalesTax_Challenge.Items;

public class Medicine extends Item{

	Medicine(){
		
		super();
	}
	
	public Medicine(String itemType,double price,int quantity,boolean imported, boolean exempted){
		
		super(itemType,price,quantity,imported,true);
		
	}
	
}
