package com.ds.bag;

public class BagArrayImpl<T> implements BagInterface<T> {

	private T[] bagArray = null;
	private final int INITIAL_BAG_SIZE = 10;
	
	@SuppressWarnings("unchecked")
	public BagArrayImpl() {
		super();
		bagArray = (T[]) new Object[INITIAL_BAG_SIZE];
	}

	@Override
	public void add(T object) {
		// the method grabs the size then adds it to the array
		if(isFull())
			resize();
		
		bagArray[size()] = object;
	}

	@Override
	public T remove() {
		// removes the first element and 
		// replaces it with the last element
		
		int size = size() != 0 ? size() - 1 : 0;
		
		T firstItem = bagArray[0];
		
		bagArray[0] = bagArray[size];
		bagArray[size] = null;
		
		return firstItem;
	}

	@Override
	public T remove(T object) {
		// removes the specified element 
		// and then replaces the gap with the last element
		
		// check if the object even exists
		if(contains(object)){
			int size = size()-1;
			for(int i = 0; i < size(); i++)
				if(bagArray[i].equals(object)){
					// grab the object
					T item = bagArray[i];
					
					//replace the object in the index with the last element
					bagArray[i] = bagArray[size];
					bagArray[size] = null;
					
					// return the grabbed object
					return item;
				}
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		// method copies the vales from the array 
		// and gives back an identical array
		T[] tempArray = (T[]) new Object[bagArray.length];
		System.arraycopy(bagArray, 0, tempArray, 0, bagArray.length);
		return tempArray;
	}

	@Override
	public boolean isFull() {
		// checks whether the amount of objects match the array size
		return size() == bagArray.length;
	}

	@Override
	public boolean isEmpty() {
		// checks whether the amount of objects = 0
		return size() == 0;
	}

	@Override
	public boolean contains(T object) {
		// this method tests whether there is an object T
		
		if(object == null)
			return false;
		
		for(int i = 0; i < size(); i++){
			if(bagArray[i].equals(object))
				return true;
		}
		
		return false;
	}
	
	@Override
	public int size() {
		int length = 0;
		for(T object: bagArray){
			if(object == null)
				break;
			
			length++;
		}
		
		return length;
	}

	@SuppressWarnings("unchecked")
	private void resize(){
		T[] tempArray = (T[]) new Object[bagArray.length*2];
		System.arraycopy(bagArray, 0, tempArray, 0, bagArray.length);
		bagArray = tempArray;
	}
}
