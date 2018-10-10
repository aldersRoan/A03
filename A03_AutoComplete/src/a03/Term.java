package a03;

import java.util.Arrays;
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

		return new Comparator<Term>() {

			@Override
			public int compare(Term t1, Term t2) {
				String query1;
				String query2;
				
				if(t1.query.length() < r) query1 = t1.query;
				else query1 = t1.query.substring(0, r);
				
				if(t2.query.length() < r) query2 = t2.query;
				else query2 = t2.query.substring(0, r);
				
				return query1.compareToIgnoreCase(query2);
			}
		};
	}

	/**
	 * Compare the terms in lexicographic order by query.
	 */
	@Override
	public int compareTo(Term other) {
		return this.query.compareToIgnoreCase(other.query);
	}

	/**
	 * Return a string representation of the term in the following format:
	 * the weight, followed by a tab, followed by the query.
	 */
	@Override
	public String toString() {	
		return Double.toString(this.weight) + "\t" + this.query; 
	}

	/**
	 * Test method for Term class.
	 * @param args
	 */
	public static void main(String args[]) {
		Term[] terms = { new Term("happy", 890), new Term("hollow", 90), new Term("hello", 9), new Term("hippy", 8) };

		for (Term term : terms) {
			System.out.println(term);
		}
		System.out.println();
		
		Arrays.sort(terms);
		for (Term term : terms)
			System.out.println(term);
		System.out.println();
		
		Arrays.sort(terms, Term.byReverseWeightOrder());
		for (Term term : terms)
			System.out.println(term);
		System.out.println();
		
		Arrays.sort(terms, Term.byPrefixOrder(5));
		for (Term term:terms)
			System.out.println(term);
		
		Term[] term2 = { new Term("jam jar", 8.0), new Term("jar of jam jars", 6.0)}; 
		Comparator<Term> prefixComp = byPrefixOrder(1);
		System.out.println(prefixComp.compare(term2[1], term2[0]));

	}

}


