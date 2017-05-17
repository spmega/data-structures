package com.ds.bag;

public interface BagInterface<T> {
	//list down all the core methods of a bag
	
	// the add methods
	public void add(T object);
	
	// the deletion methods
	public T remove();
	public T remove(T object);
	
	// a method to turn it into an Array
	public T[] toArray();
	
	// utility methods
	public boolean isFull();
	public boolean isEmpty();
	public boolean contains(T object);
	public int size();
	
}
