package com.SalesTax_Challenge.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MiscTest {
	
	Misc misc;

	@Test
	final void testMiscDefault() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testMiscParameters() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void MiscDefault() {
		
		misc=new Misc();
		
		assertEquals("",misc.getItemName());
		
		assertEquals(0.0,misc.getPrice());
		
		assertEquals(0,misc.getQuantity());
		
		assertFalse(misc.isExempted());
		
		assertFalse(misc.isImported());
		
	}
	
	@Test
	final void MedicineParameters() {
		
		misc=new Misc("imported toys",20.00,1,true,false);
		
		assertEquals("imported toys",misc.getItemName());
		
		assertEquals(20.00,misc.getPrice());
		
		assertEquals(1,misc.getQuantity());
		
		assertFalse(misc.isExempted());
		
		assertTrue(misc.isImported());
		
	}

}
