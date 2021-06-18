package com.SalesTax_Challenge.billing;

import java.util.*;

import com.SalesTax_Challenge.Items.Item;
import com.SalesTax_Challenge.Items.ItemFactory;
import com.SalesTax_Challenge.taxes.Taxes;

import java.io.*;

public class Billing {

	private Receipt receipt;
	
	private List<Item> items;
	
	private String inputFileName;
	
	private Item item;
	
	private double totalTax, total;
	
	public Billing(String inputFileName){
		
		this.items=new ArrayList<>();
		
		this.inputFileName=inputFileName;
	
	}
	
	public void addItemToReceipt() throws Exception {
		
		//generate a new file at the given location and read from it
		
		File file=new File(inputFileName);
		
		Scanner in=new Scanner(file);
	
		while(in.hasNextLine()) {
				
			String line=in.nextLine();
			
			initializeItem(line);
			
			processTax(item);
			
			items.add(item);
		}
		
		in.close();
		
	}
	
	
	/**
	* @param line - the input line in text file
	* @throws Exception (handles bad input formatting)
	* The line will contain the entry of the first purchase,
	* e.g. "1 imported chocolate at 12.50"
	* 
	* From input line, we will determine type of item and generate it through ItemFactory
	* We will set import status and price and quantity accordingly
	*/
	
	public void initializeItem(String line) throws Exception {
			
		ItemFactory itemfact=new ItemFactory();
		
		item=itemfact.getItem(line);
		
		item.setImported(line.contains("imported")?true:false);
		
		setPriceandQuantity(line);
		
	}
		
	public void setPriceandQuantity(String line) throws Exception {
			
		//Price comes after last "at" in input line, e.g. "2 chocolates at 10.50"
			
		int splitIndex=-1;
			
		splitIndex=line.lastIndexOf("at");
			
		//if "at" is never found in line, we cannot find price
			
		if(splitIndex==-1)
			throw new Exception("Bad formatting");
			
		//update item price accordingly
			
		item.setPrice(Double.parseDouble(line.substring((splitIndex+2))));
		
		//first word in line is quantity
			
		item.setQuantity(Integer.parseInt(line.substring(0,1)));
			
		}
	
	/**
	 * 
	 * @param item - item to be purchased
	 * @return total price of item of a particular quantity before tax is applied
	 */
	
	public double calculateTotalBeforeTax(Item item) {
		
		return item.getPrice()*(double)item.getQuantity();
		
	}
	
	/**
	 * 
	 * @param item - item whose tax is to be calculated
	 * 
	 */
	
	public void processTax(Item item) {
		
		Taxes tax=new Taxes();
		
		// Calculates total price for the quantity of item being purchased.
		
		total+=calculateTotalBeforeTax(item);
		
		// Calculates tax on the price of the item.
		
		double taxOnItem=tax.calculateTaxValue(item);
		
		// Updating price of the item with the tax on its price.
		
		item.setPrice(item.getPrice()+taxOnItem);
		
		// To the total price of the item, adding total tax.
		
		total+=(taxOnItem*item.getQuantity());
		
		// Separately calculating total tax to be printed on receipt as Sales Tax.
		
		totalTax+=(taxOnItem*item.getQuantity());
		
	}
	
	public void generateReceipt() {
		
		receipt=new Receipt(items, total, totalTax);
				
		receipt.setItems(items);
		
		receipt.printReceipt();
		
	}
		
	public List<Item> getItems(){
		
		return items;
	}
	
	public double getTotal() {
		
		return total;
	}
	
	public double getTotalTax() {
		
		return totalTax;
		
	}	
	
}
