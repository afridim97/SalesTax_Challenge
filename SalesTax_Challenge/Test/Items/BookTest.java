package com.SalesTax_Challenge.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	
	Book book;

	@Test
	final void testBookDefault() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testBookParameters() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void BookDefault() {
		
		book=new Book();
		
		assertEquals("",book.getItemName());
		
		assertEquals(0.0,book.getPrice());
		
		assertEquals(0,book.getQuantity());
		
		assertEquals(false,book.isExempted());
		
		assertEquals(false,book.isImported());
		
	}
	
	@Test
	final void BookParameters() {
		
		book=new Book("book",10.00,1,false,true);
		
		assertEquals("book",book.getItemName());
		
		assertEquals(10.00,book.getPrice());
		
		assertEquals(1,book.getQuantity());
		
		assertEquals(true,book.isExempted());
		
		assertEquals(false,book.isImported());
		
	}

}
