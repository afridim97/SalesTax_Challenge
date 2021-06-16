package com.SalesTax_Challenge.Items;

public class Medicine extends Item{

	Medicine(){
		
		super();
	}
	
	public Medicine(String itemType,double price,int quantity,boolean exempted,boolean imported){
		
		super(itemType,price,quantity,true,imported);
		
	}
	
}
