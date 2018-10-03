package a03;

import java.util.Comparator;

public class Term implements Comparable<Term>{
	
	/**
	 * Initialize a term with the given query string and weight
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight) {
		
	}
	
	/**
	 * Compare the terms in descending order by weight.
	 * @return
	 */
	public static Comparator<Term> byReverseWeightOrder() {
		return null; //TODO
		
	}
	
	/**
	 * Compare the terms in lexicographic order but using only the 
	 * first r characters of each query.
	 * @param r
	 * @return
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		return null; //TODO
		
	}
	

	@Override
	/**
	 * Compare the terms in lexicographic order by query.
	 */
	public int compareTo(Term o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	/**
	 * Return a string representation of the term in the following format:
	 * the weight, followed by a tab, followed by the query.
	 */
	public String toString() {
		return null; //TODO
	}

}
