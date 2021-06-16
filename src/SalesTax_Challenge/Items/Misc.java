package com.SalesTax_Challenge.Items;

public class Misc extends Item{


	Misc(){
		
		super();
	}
	
	public Misc(String itemType,double price,int quantity,boolean exempted,boolean imported){
		
		super(itemType,price,quantity,false,imported);
		
	}
	
	
}
