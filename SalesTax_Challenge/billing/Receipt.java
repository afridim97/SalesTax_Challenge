package com.SalesTax_Challenge.billing;
import java.util.*;

import com.SalesTax_Challenge.Items.Item;

public class Receipt {

	private List<Item> items;

	private double totalTax;

	private double total;

	Receipt(List<Item> items, double total, double totalTax){
		
		this.items=new ArrayList<>();
		
		this.total=total;
		
		this.totalTax=totalTax;
		
	}
	
	public double getTotalTax() {
		
		return totalTax;
	}
	
	public void setTotalTax(double totalTax) {
	
		this.totalTax=totalTax;
		
	}
	
	public double getTotal() {
		
		return total;
	}
	
	public void setTotal(double total) {
	
		this.total=total;
		
	}
		
	public List<Item> getItems() {
		
		return items;
		
	}
	
	public void setItems(List<Item> items) {
		
		this.items=items;
		
	}

	public void printReceipt(){
		/*
		 * Prints the quantity of each item purchased, name of item, and item price
		 * Also prints total tax and total price of all items
		 * 
		 */
		
		items=getItems();
		
		for(Item item:items){
			System.out.println(item.getQuantity()+" "+item.getItemName() + " at " + (float)item.getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.println("Total: " + (float)total);
	}
		
	
	
	
}
