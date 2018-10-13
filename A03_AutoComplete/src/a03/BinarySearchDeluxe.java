package a03;

import java.util.Comparator;

/**
 * This class searches an array of terms based on key and a given comparator. 
 * The class uses binary search to perform searches of a sorted array in log2(N) time.
 * There are two methods. One searches for the first occurrence of a query in an array of terms.
 * The second method searches for the last occurrence of a query in an array of terms.
 * 
 * @author Aaron Sadler, Pace Wasden
 *
 */
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

			if(comparator.compare(key, a[mid]) < 0) {
				hi = mid - 1;
			} else if(comparator.compare(key, a[mid]) > 0) {
				lo = mid + 1;
			} else if(comparator.compare(a[mid - 1], a[mid]) == 0) {
				hi = mid - 1;
			} else return mid;
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
		
		if(comparator.compare(key, a[hi]) == 0) {
			return hi;
		}
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if(comparator.compare(key, a[mid]) < 0) {
				hi = mid - 1;
			} else if(comparator.compare(key, a[mid]) > 0) {
				lo = mid + 1;
			} else if(comparator.compare(a[mid + 1], a[mid]) == 0) {
				lo = mid + 1;
			} else return mid;
		}
		return -1;
	}
}
