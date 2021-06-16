package com.SalesTax_Challenge.Items;

public class Book extends Item{

	Book(){
		
		super();
	}
	
	Book(String itemName,double price,int quantity,boolean exempted,boolean imported){
		
		super(itemName,price,quantity,true,imported);
		
	}
	
}
