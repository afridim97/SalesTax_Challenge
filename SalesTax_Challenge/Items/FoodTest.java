package com.SalesTax_Challenge.Items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {
	
	Food food;

	@Test
	final void testFoodDefault() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFoodParameters() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void FoodDefault() {
		
		food=new Food();
		
		assertEquals("",food.getItemName());
		
		assertEquals(0.0,food.getPrice());
		
		assertEquals(0,food.getQuantity());
		
		assertFalse(food.isExempted());
		
		assertFalse(food.isImported());
		
	}
	
	@Test
	final void FoodParameters() {
		
		food=new Food("chocolate",5.00,1,false,true);
		
		assertEquals("chocolate",food.getItemName());
		
		assertEquals(5.00,food.getPrice());
		
		assertEquals(1,food.getQuantity());
		
		assertTrue(food.isExempted());
		
		assertFalse(food.isImported());
		
	}

}
