package com.szeretematejet.esakakaotis.circularbuffer;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		int size = 200;
		CircularBuffer<Number> circuralBuffer = new CircularBuffer<>(size);

		for (int i = 0; i < size / 2; i++) {
			circuralBuffer.put((int) (Math.random() * 899 + 100));
		}

		System.out.println("\n\nAs Object array:");

		Object[] objectArray = circuralBuffer.toObjectArray();

		for (int i = 0; i < objectArray.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(objectArray[i] + "\t");
		}

		System.out.println("\n\nAs Integer array:");

		Integer[] intArray = new Integer[0];
		printIntegerArray((Integer[]) circuralBuffer.toArray(intArray));

		System.out.println("\n\nGetting data out of the buffer:");

		for (int i = 0; i < size / 2; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(circuralBuffer.get() + "\t");
		}

		System.out.println("\n\nAftermath, there is nothing in the buffer:");

		printIntegerArray((Integer[]) circuralBuffer.toArray(intArray));

		System.out.println("\n\nAdding a List to the buffer:");

		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			integers.add((int) (Math.random() * 899 + 100));
		}

		try {
			circuralBuffer.addAll(integers);
		} catch (NotEnoughSpaceInBuffer e) {
			e.printStackTrace();
		}

		printIntegerArray((Integer[]) circuralBuffer.toArray(intArray));

		System.out.println("\n\nSorting also works fine:");

		circuralBuffer.sort(null);
		printIntegerArray((Integer[]) circuralBuffer.toArray(intArray));
	}

	public static void printIntegerArray(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(array[i] + "\t");
		}
	}
}
