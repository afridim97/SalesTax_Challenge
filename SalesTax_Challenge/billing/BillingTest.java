package com.SalesTax_Challenge.billing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.SalesTax_Challenge.taxes.Taxes;

class BillingTest {

	Billing bill;
	
	String inputFileName=System.getProperty("user.dir")+"/src/test_1.txt";
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		bill=new Billing(inputFileName);
		
	}

	@Test
	final void testBilling() throws Exception {
		
		bill.addItemToReceipt();
		
		bill.generateReceipt();
				
		assertEquals(3,bill.getItems().size());
		
		assertEquals(1.50,bill.getTotalTax());
		
		assertEquals(29.830000000000002,bill.getTotal());
		
		
	}
}
