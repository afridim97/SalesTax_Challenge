package com.SalesTax_Challenge.Items;

public class Book extends Item{

	public Book(){
		
		super();
	}
	
	public Book(String itemName,double price,int quantity,boolean imported,boolean exempted){
		
		super(itemName,price,quantity,imported,true);
		
	}
	
}
