package a03;

import java.util.Collections;
import java.util.Comparator;

public class BinarySearchDeluxe {

	/**
	 * Return the index of the first key in a[] that equals the search key,
	 * or -1 if no such key.
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if(a.equals(null) || key.equals(null) || comparator.equals(null)) {
			throw new NullPointerException("Input arguments cannot be null");
		}
		
		int lo = 0;
		int hi = a.length - 1;
		
		if(comparator.compare(key, a[lo]) == 0) return lo;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if(comparator.compare(key, a[mid]) < 0 ||
					comparator.compare(a[mid -1], a[mid]) == 0) hi = mid - 1;
			else if(comparator.compare(key, a[mid]) > 0) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	/**
	 * Return the index of the last key in a[] that equals the search key,
	 * or -1 if no such key.
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if(a.equals(null) || key.equals(null) || comparator.equals(null)) {
			throw new NullPointerException("Input arguments cannot be null");
		}
		int lo = 0;
		int hi = a.length - 1;
		
		if(comparator.compare(key, a[hi]) == 0) return hi;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if(comparator.compare(key, a[mid]) < 0) hi = mid - 1;
			else if(comparator.compare(key, a[mid]) > 0 ||
					comparator.compare(a[mid + 1], a[mid]) == 0) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Integer[] numbers = {10, 10, 10, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 2, 2, 2, 1, 1, 1,};
		System.out.print(BinarySearchDeluxe.firstIndexOf(numbers, 10, Collections.reverseOrder()) + "\t");
		System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 10, Collections.reverseOrder()));
	}
}
