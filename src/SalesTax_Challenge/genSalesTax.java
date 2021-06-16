package com.SalesTax_Challenge;
import java.io.FileNotFoundException;

import com.SalesTax_Challenge.billing.Billing;

public class genSalesTax{
		
	
	public static void main(String[] args) {
		
	String fileLocation=System.getProperty("user.dir");
		
	//for(int i=0;i<args.length;i++) {
		
		//let args[i] be the name of the test file
		
		Billing b= new Billing(fileLocation+"/src/test_1.txt");	
		
		try{
			b.addItemToReceipt();
		}
		catch(FileNotFoundException e) {
			
			System.out.print("Please enter a valid file name");
		}
		
	//}
	
	}
	
}
	
