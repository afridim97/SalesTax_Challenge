package com.SalesTax_Challenge.taxes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.SalesTax_Challenge.Items.Book;
import com.SalesTax_Challenge.Items.Item;
import com.SalesTax_Challenge.Items.ItemFactory;
import com.SalesTax_Challenge.Items.Misc;

class TaxesTest {
	
	Book book=new Book("imported book",10.00,1,true,true);
	
	Taxes tax=new Taxes();
	
	@Test
	final void testTaxes() {
			
		tax.calculateTaxValue(book);
		
		assertEquals(0.05,tax.getTaxRate());
		
		assertEquals(0.50,tax.getTaxValue());
	
	}
	

}
