package com.sei.dedup;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Raju 
 */
public class FilterDuplicatesTest {

	private FilterDuplicates dedups = new FilterDuplicates();

	private int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34,
			86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15,
			6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17,
			16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17,
			10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	@Test(expected=RuntimeException.class)
	public void testRemoveDuplicatesUsingInvalidInput() {
		dedups.removeDuplicates(null);
	}
	
	@Test(expected=RuntimeException.class)
	public void testRemoveDuplicatesUsingEmptyInput() {
		dedups.removeDuplicates(new int[0]);
	}
	
	@Test
	public void testRemoveDuplicatesUsingSetImplementation() {
		int[] filteredArray = dedups.removeDuplicates(randomIntegers);
		checkForDuplicates(filteredArray);
	}

	@Test
	public void testRemoveDuplicatesUsingOrder() {
		int[] filteredArray = dedups
				.removeDuplicatesAndRetainOrder(randomIntegers);
		checkForDuplicates(filteredArray);
	}

	@Test
	public void testRemoveDuplicatesAndSort() {
		int[] filteredArray = dedups.removeDuplicatesAndSort(randomIntegers);
		checkForDuplicates(filteredArray);
	}

	@Test
	public void testRemoveDuplicatesUsingSortAndFilter() {
		int[] filteredArray = dedups
				.removeDuplicatesUsingSortAndFilter(randomIntegers);
		checkForDuplicates(filteredArray);
	}

	private void checkForDuplicates(int[] filteredArray) {
		for (int i = 0; i < filteredArray.length; i++) {
			for (int j = i + 1; j < filteredArray.length; j++) {
				if (filteredArray[i] == filteredArray[j]) {
					fail("Filtered array should not consist duplicates");
				}
			}
		}
	}
}
