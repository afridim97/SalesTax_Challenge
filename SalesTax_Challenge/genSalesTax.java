package com.SalesTax_Challenge;
import java.io.FileNotFoundException;

import com.SalesTax_Challenge.billing.Billing;

public class genSalesTax{
		
	
	public static void main(String[] args) throws Exception {
		
	String fileLocation=System.getProperty("user.dir");
		
	for(int i=0;i<args.length;i++) {
		
		//let args[i] be the name of the test file
		
		Billing bill = new Billing(fileLocation+"/"+args[i]);	
		
		try{
			
			bill.addItemToReceipt();
			
			bill.generateReceipt();
		
		}
		
		catch(FileNotFoundException e) {
			
			System.out.print("Please enter a valid file name");
	
			}
		
	
		}

	}
	
}
	

	
