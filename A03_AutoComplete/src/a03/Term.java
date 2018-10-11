package a03;

import java.util.Comparator;

public class Term implements Comparable<Term>{
	private String query;
	private double weight;
	
	/**
	 * Initialize a term with the given query string and weight
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight) {
		if(query.equals(null)) {
			throw new NullPointerException("Query cannot be null");
		}
		
		if(weight < 0) {
			throw new IllegalArgumentException("Weight must be a nonnegative number");
		}
		
		this.query  = query;
		this.weight = weight;
	}
	
	/**
	 * Compare the terms in descending order by weight.
	 * @return
	 */
	public static Comparator<Term> byReverseWeightOrder() {
			return (t1, t2) -> Double.compare(t2.weight, t1.weight);
	}
	
	/**
	 * Compare the terms in lexicographic order but using only the 
	 * first r characters of each query.
	 * @param r
	 * @return
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		if(r < 0 ) {
			throw new IllegalArgumentException("Input argument must be a nonnegative number");
		}

		return (t1, t2) -> {		
			String query1 = queryLength(t1.query, r);
			String query2 = queryLength(t2.query, r);
			int comparison = query1.compareToIgnoreCase(query2);
			
			if(comparison < 0) return -1;
			else if(comparison > 0) return 1;
			else return 0;
		};
		
	}

	private static String queryLength(String query, int r) {
		int queryLength = query.length() > r ? r : query.length();
		return query.substring(0, queryLength);
	}

	/**
	 * Compare the terms in lexicographic order by query.
	 */
	@Override
	public int compareTo(Term that) {
		return this.query.compareToIgnoreCase(that.query);
	}

	/**
	 * Return a string representation of the term in the following format:
	 * the weight, followed by a tab, followed by the query.
	 */
	@Override
	public String toString() {	
		return Double.toString(this.weight) + "\t" + this.query; 
	}
}


