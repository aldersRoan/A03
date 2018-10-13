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

		return (thisTerm, thatTerm) -> {		
			String thisQuery = thisTerm.query.substring(0, Math.min(r, thisTerm.query.length()));
			String thatQuery = thatTerm.query.substring(0, Math.min(r, thatTerm.query.length()));
			return thisQuery.compareToIgnoreCase(thatQuery);
		};
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


