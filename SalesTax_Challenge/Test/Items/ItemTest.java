package com.SalesTax_Challenge.Items;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	Item item;
	
	String name="test";
	
	double price=10.00;
	
	int quantity=1;
	
	boolean imported=false;
	
	boolean exempted=true;
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	
	final void testCreateBook() {
		
		item=new Book(name,price,quantity,imported,exempted);
		
		assertEquals("test",item.getItemName());
		
		assertEquals(10.00,item.getPrice());
		
		assertEquals(1,item.getQuantity());
		
		assertFalse(item.isImported());
		
		assertTrue(item.isExempted());
		
		item.setExempted(false);
		
		assertFalse(item.isExempted());
		
		item.setImported(true);
		
		assertTrue(item.isImported());
		
	}

}
