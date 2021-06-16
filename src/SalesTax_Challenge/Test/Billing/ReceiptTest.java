package com.SalesTax_Challenge.billing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.SalesTax_Challenge.Items.Item;
import com.SalesTax_Challenge.Items.Medicine;
import com.SalesTax_Challenge.Items.Misc;

class ReceiptTest {
	
	List<Item> items;

	double totalTax;

	double total;
	
	Medicine medicine;
	
	Misc misc;

	Receipt receipt;
	
	@BeforeEach
	void setUp() throws Exception {
		
		items=new ArrayList<>();
	
		medicine=new Medicine("pills",20.00,1,true,false);
	
		misc=new Misc("toys",30.00,1,false,false);
	
		items.add(medicine);
		
		items.add(misc);
		
		receipt=new Receipt(items,55.50,5.5);
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testPrintReceipt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void printReceipt() {
	
	assertEquals(55.5,receipt.getTotal());
	
	assertEquals(5.5,receipt.getTotalTax());
	
	}
	
}
