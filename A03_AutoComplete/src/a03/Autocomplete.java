package a03;

import java.util.Arrays;

/**
 * This class returns terms which match a given prefix. There are two methods.
 * The allMatches method returns a sorted array by reverse weight order that includes
 * all of the terms which match the given prefix. The second method returns the number of
 * matches based on the given prefix.
 * 
 * @author Aaron Sadler, Pace Wasden
 *
 */

public class Autocomplete {
	private Term[] terms;
	
	/**
	 * Initialize the data structure from the given array of terms. 
	 * @param terms
	 */
	public Autocomplete(Term[] terms) {
		if(terms.equals(null)) {
			throw new NullPointerException("Input arguments cannot be null");
		}
		
		this.terms = terms;
		Arrays.sort(terms);
		
	}
	
	/**
	 * Return all terms that start with the given prefix, 
	 * in descending order of weight.
	 * @param prefix
	 * @return
	 */
	public Term[] allMatches(String prefix) {
		if(prefix.equals(null)) {
			throw new NullPointerException("Input arguments cannot be null");
		}
		Term term = new Term(prefix, 0);
		
		int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		if(firstIndex == -1) {
			return new Term[0];
		}
		
		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		Term[] matches = new Term[1 + lastIndex - firstIndex];
		
		for(int i = 0; i < matches.length; i++) {
			matches[i] = terms[firstIndex++];
		}

		Arrays.sort(matches, Term.byReverseWeightOrder());
		return matches; 
	}
	
	/**
	 * Return the number of terms that start with the given prefix.
	 * @param prefix
	 * @return
	 */
	public int numberOfMatches(String prefix) {
		if(prefix.equals(null)) {
			throw new NullPointerException("Input arguments cannot be null");
		}
		Term term = new Term(prefix, 0);
		int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		
		return 1 + (lastIndex - firstIndex);
	}

}
