package com.szeretematejet.esakakaotis.circularbuffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircularBuffer<T> {

	private int arraySize = 10;
	private T[] dataMembers;
	private int bufferHead;
	private int bufferTail;
	private int bufferSize;

	@SuppressWarnings("unchecked")
	public CircularBuffer() {
		this.dataMembers = (T[]) new Object[arraySize];
		arraySize = 10;
		bufferSize = 0;
		bufferHead = 0;
		bufferTail = 0;
	}

	@SuppressWarnings("unchecked")
	public CircularBuffer(int arraySize) {
		this.dataMembers = (T[]) new Object[arraySize];
		this.arraySize = arraySize;
		bufferSize = 0;
		bufferHead = 0;
		bufferTail = 0;
	}

	public void put(T t) {
		if (bufferHead == bufferTail && bufferSize == arraySize) {
			throw new NotAllowedToOverwrite("Shant write over unread things");
		}
		dataMembers[bufferHead] = t;
		bufferHead = (bufferHead + 1) % arraySize;
		bufferSize++;
	}

	public T get() {
		if (bufferHead == bufferTail && isEmpty()) {
			throw new NotAllowedToRead("You already read this");
		}
		T element = (T) dataMembers[bufferTail];
		bufferTail = (bufferTail + 1) % arraySize;
		bufferSize--;
		return element;
	}

	public Object[] toObjectArray() {
		Object[] objectArray = new Object[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			objectArray[i] = dataMembers[(i + bufferTail) % arraySize];
		}
		return objectArray;
	}

	@SuppressWarnings("unchecked")
	public T[] toArray(T[] a) {
		Object[] objectArray = new Object[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			objectArray[i] = dataMembers[(i + bufferTail) % arraySize];
		}
		return (T[]) Arrays.copyOf(objectArray, objectArray.length, a.getClass());
	}

	@SuppressWarnings("unchecked")
	public List<T> asList() {
		return (List<T>) Arrays.asList(toObjectArray());
	}

	public void addAll(List<? extends T> toAdd) throws NotEnoughSpaceInBuffer {
		if (toAdd.size() > arraySize - bufferSize) {
			throw new NotEnoughSpaceInBuffer("Too big fam");
		}

		for (T t : toAdd) {
			put(t);
		}
	}

	public void sort(Comparator<? super T> comparator) {
		List<T> list = asList();
		list.sort(comparator);
		this.bufferTail = 0;
		this.bufferHead = 0;
		this.bufferSize = 0;
		try {
			addAll(list);
		} catch (NotEnoughSpaceInBuffer e) {
			e.printStackTrace();
		}
	}

	public boolean isEmpty() {
		return bufferSize == 0;
	}
}
