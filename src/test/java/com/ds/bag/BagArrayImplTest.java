package com.ds.bag;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BagArrayImplTest {

	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void testAdd() {
		BagInterface<Integer> bagImpl = new BagArrayImpl<>(); 
		
		for(int i = 0; i < 5; i++){
			bagImpl.add(i);
			Assert.assertTrue(bagImpl.size() == i + 1);
		}
		
		Assert.assertFalse(bagImpl.size() != 5);
		
		for(int i = 0; i < 10; i++){
			bagImpl.add(i);
		}
		
		System.out.println(bagImpl.size());
		
		Assert.assertTrue(bagImpl.size() == 15);
	}
	
	@Test
	public void testRemove() {
		BagInterface<Integer> bagImpl = new BagArrayImpl<>(); 
		
		Assert.assertTrue(bagImpl.remove() == null);
		
		for(int i = 0; i < 5; i++){
			bagImpl.add(i);
		}
		
		Assert.assertTrue(bagImpl.remove() == 0);
		
		Assert.assertTrue(bagImpl.size() != 5);
		Assert.assertTrue(bagImpl.size() == 4);
	}
	
	@Test
	public void testRemoveWithParam() {
		BagInterface<Integer> bagImpl = new BagArrayImpl<>(); 
		
		for(int i = 0; i < 5; i++){
			bagImpl.add(i);
		}
		
		Assert.assertTrue(bagImpl.remove(3) == 3);
		
		Assert.assertTrue(bagImpl.size() != 5);
		Assert.assertTrue(bagImpl.size() == 4);
	}
	
	@Test
	public void testContains() {
		BagInterface<Integer> bagImpl = new BagArrayImpl<>(); 
		
		for(int i = 0; i < 5; i++){
			bagImpl.add(i);
		}
		
		Assert.assertTrue(bagImpl.contains(3));
		Assert.assertFalse(bagImpl.contains(5));
	}
	
	@Test
	public void testisFull() {
		BagInterface<Integer> bagImpl = new BagArrayImpl<>(); 
		
		Assert.assertFalse(bagImpl.isFull());
		
		for(int i = 0; i < 10; i++){
			bagImpl.add(i);
		}
		
		Assert.assertTrue(bagImpl.isFull());
	}

	@Test
	public void testisEmpty() {
		BagInterface<Integer> bagImpl = new BagArrayImpl<>(); 
		
		Assert.assertTrue(bagImpl.isEmpty());
		
		for(int i = 0; i < 5; i++){
			bagImpl.add(i);
		}
		
		Assert.assertFalse(bagImpl.isEmpty());
	}

}
