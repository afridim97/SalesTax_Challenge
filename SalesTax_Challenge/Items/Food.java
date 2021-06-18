package com.SalesTax_Challenge.Items;

public class Food extends Item{


	public Food(){
		
		super();
	}
	
	public Food(String itemType,double price,int quantity,boolean imported,boolean exempted){
		
		super(itemType,price,quantity,imported,true);
		
	}
	
	
}
