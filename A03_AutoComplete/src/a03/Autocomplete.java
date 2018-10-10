package a03;

public class Autocomplete {
	
	/**
	 * Initialize the data structure from the given array of terms.
	 * @param terms
	 */
	public Autocomplete(Term[] terms) {
		if(terms.equals(null)) {
			throw new NullPointerException("Input arguments cannot be null");
		}
		
		
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
		
		return null; //TODO
		
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
		
		return 0; //TODO
		
	}

}
