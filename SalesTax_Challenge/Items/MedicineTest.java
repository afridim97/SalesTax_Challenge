package com.SalesTax_Challenge.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MedicineTest {
	
	Medicine medicine;

	@Test
	final void testMedicineDefault() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testMedicineParameters() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void MedicineDefault() {
		
		medicine=new Medicine();
		
		assertEquals("",medicine.getItemName());
		
		assertEquals(0.0,medicine.getPrice());
		
		assertEquals(0,medicine.getQuantity());
		
		assertFalse(medicine.isExempted());
		
		assertFalse(medicine.isImported());
		
	}
	
	@Test
	final void MedicineParameters() {
		
		medicine=new Medicine("pills",50.00,1,false,true);
		
		assertEquals("pills",medicine.getItemName());
		
		assertEquals(50.00,medicine.getPrice());
		
		assertEquals(1,medicine.getQuantity());
		
		assertTrue(medicine.isExempted());
		
		assertFalse(medicine.isImported());
		
	}

}
