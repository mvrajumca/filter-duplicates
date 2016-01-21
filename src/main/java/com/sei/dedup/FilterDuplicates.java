package com.sei.dedup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * @author Raju
 * 
 */
public class FilterDuplicates {

	private final static Logger logger = Logger
			.getLogger(FilterDuplicates.class);

	/**
	 * Removes duplicates using set implementation.
	 * 
	 * @param randomIntegers
	 * @return
	 */
	public int[] removeDuplicates(int[] randomIntegers) {
		validateRandomIntegers(randomIntegers);
		Set<Integer> filteredSet = new HashSet<Integer>();
		for (Integer intgr : randomIntegers) {
			filteredSet.add(intgr);
		}
		// Converting set to int array
		return toIntArray(filteredSet);
	}

	/**
	 * Removes duplicates using set implementation and retains the insertion
	 * order.
	 * 
	 * @param randomIntegers
	 * @return
	 */
	public int[] removeDuplicatesAndRetainOrder(int[] randomIntegers) {
		validateRandomIntegers(randomIntegers);
		Set<Integer> filteredSet = new LinkedHashSet<Integer>();
		for (Integer intgr : randomIntegers) {
			filteredSet.add(intgr);
		}
		// Converting set to int array
		return toIntArray(filteredSet);
	}

	/**
	 * Removes duplicates and sorts the elements using set implementation.
	 * 
	 * @param randomIntegers
	 * @return
	 */
	public int[] removeDuplicatesAndSort(int[] randomIntegers) {
		validateRandomIntegers(randomIntegers);
		Set<Integer> filteredSet = new TreeSet<Integer>();
		for (Integer intgr : randomIntegers) {
			filteredSet.add(intgr);
		}
		// Converting set to int array
		return toIntArray(filteredSet);
	}

	/**
	 * Removes duplicates using quick sort approach and filters duplicates.
	 * 
	 * @param randomIntegers
	 * @return
	 */
	public int[] removeDuplicatesUsingSortAndFilter(int[] randomIntegers) {
		validateRandomIntegers(randomIntegers);
		sortElements(0, randomIntegers.length - 1, randomIntegers);
		return filterDups(randomIntegers);
	}

	private int[] filterDups(int[] randomIntegers) {
		int count = 1;
		int[] filterElements = new int[randomIntegers.length];
		int lastElement = randomIntegers[0];
		filterElements[0] = lastElement;
		for (int i = 1; i < randomIntegers.length; i++) {
			if (randomIntegers[i] != lastElement) {
				filterElements[count] = randomIntegers[i];
				count = count + 1;
			}
			lastElement = randomIntegers[i];
		}
		int[] filterCompress = new int[count];
		System.arraycopy(filterElements, 0, filterCompress, 0, count);
		logger.debug("Numbers using sort and filter "
				+ Arrays.toString(filterCompress));
		return filterCompress;
	}

	private void sortElements(int start, int end, int[] randomIntegers) {
		int middleElement = randomIntegers[start + (end - start) / 2];
		int i = start;
		int j = end;
		while (i <= j) {
			while (randomIntegers[i] < middleElement) {
				i++;
			}
			while (randomIntegers[j] > middleElement) {
				j--;
			}
			if (i <= j) {
				swap(randomIntegers, i, j);
				i++;
				j--;
			}
		}
		if (start < j) {
			sortElements(start, j, randomIntegers);
		}
		if (i < end) {
			sortElements(i, end, randomIntegers);
		}
	}

	private static void swap(int[] values, int startIndex, int nextIndex) {
		int temp = values[startIndex];
		values[startIndex] = values[nextIndex];
		values[nextIndex] = temp;
	}

	/**
	 * @param filteredSet
	 * @return
	 */
	private int[] toIntArray(Set<Integer> filteredSet) {
		int[] filteredVals = new int[filteredSet.size()];
		int index = 0;
		for (Integer filSetVal : filteredSet) {
			filteredVals[index++] = filSetVal;
		}
		logger.debug("Filtered Array " + Arrays.toString(filteredVals));
		return filteredVals;
	}
	
	private void validateRandomIntegers(int[] randomIntegers) {
		if(randomIntegers==null || randomIntegers.length == 0) {
			throw new RuntimeException("Invalid input.");
		}
	}
}
