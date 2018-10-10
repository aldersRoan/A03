package a03;

import java.util.Arrays;

public class Autocomplete {
	private Term[] terms;
	
	//ingore
	
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
				
		Term[] matches = Arrays.copyOfRange(terms, firstIndex, lastIndex);
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
