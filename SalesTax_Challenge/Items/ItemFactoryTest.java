package com.SalesTax_Challenge.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemFactoryTest {

	ItemFactory factory;
	
	Item item; 
	
	String bookName="1 book at 10.50";
	
	String foodName="2 chocolates at 10.00";
	
	String medicineName="1 box of pills at 20.00";
	
	String miscName="1 toy at 15.00";
	
	@Test 
	final void testGetBook(){
		
		factory=new ItemFactory();
		
		item=factory.getItem(bookName);
		
		assertEquals("book",item.getItemName());
		
		assertEquals(0.00,item.getPrice());
		
		assertEquals(0,item.getQuantity());
		
		assertFalse(item.isImported());
		
		assertTrue(item.isExempted());
		
	}
	
	@Test 
	final void testGetFood(){
		
		factory=new ItemFactory();
		
		item=factory.getItem(foodName);
		
		assertEquals("chocolates",item.getItemName());
		
		assertEquals(0.00,item.getPrice());
		
		assertEquals(0,item.getQuantity());
		
		assertFalse(item.isImported());
		
		assertTrue(item.isExempted());
		
	}
	
	@Test 
	final void testGetMedicine(){
		
		factory=new ItemFactory();
		
		item=factory.getItem(medicineName);
		
		assertEquals("box of pills",item.getItemName());
		
		assertEquals(0.00,item.getPrice());
		
		assertEquals(0,item.getQuantity());
		
		assertFalse(item.isImported());
		
		assertTrue(item.isExempted());
		
	}
	
	@Test 
	final void testGetMisc(){
		
		factory=new ItemFactory();
		
		item=factory.getItem(miscName);
		
		assertEquals("toy",item.getItemName());
		
		assertEquals(0.00,item.getPrice());
		
		assertEquals(0,item.getQuantity());
		
		assertFalse(item.isImported());
		
		assertFalse(item.isExempted());
		
	}
}
