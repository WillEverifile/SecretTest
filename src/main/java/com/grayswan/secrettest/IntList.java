package com.grayswan.secrettest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author will
 */
public class IntList {
	
	// holds a list of integers.  Can be added to and read only.
	// uses an ArrayList of int[] arrays.
	private List<int[]> data = new ArrayList<int[]>();
	private int size = 0;
	private static final int CHUNK_SIZE = 2048;
	
	public void add(int value) {
		// add a value to the list
		size++;
		if (size > data.size() * CHUNK_SIZE) {
			data.add(new int[CHUNK_SIZE]);
		}
		data.get((size-1) / CHUNK_SIZE)[(size-1) % CHUNK_SIZE] = value;
	}

	public int get(int index) {
		return data.get(index / CHUNK_SIZE)[index % CHUNK_SIZE];
	}

	public int getSize() {
		return size;
	}
}
