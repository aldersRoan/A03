package a03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	@Test 
	void testTermNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Term(null, 0);
		});
	}

	@Test
	void testTermIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Term("query", -1);
		});
	}

	@Test
	void testByReverseWeightOrderGreaterThanZero() {
		Term term1 = new Term("query1", 4);
		Term term2 = new Term("query2", 5);
		boolean result = Term.byReverseWeightOrder().compare(term1, term2) > 0;
		assertTrue(result);
	}

	@Test
	void testByReverseWeightOrderLessThanZero() {
		Term term1 = new Term("query1", 4);
		Term term2 = new Term("query2", 5);
		boolean result = Term.byReverseWeightOrder().compare(term2, term1) < 0;
		assertTrue(result);
	}

	@Test
	void testByReverseWeightOrderEqualThanZero() {
		Term term1 = new Term("query1", 5);
		Term term2 = new Term("query2", 5);
		boolean result = Term.byReverseWeightOrder().compare(term1, term2) == 0;
		assertTrue(result);
	}

	@Test
	void testByPrefixOrderIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Term.byPrefixOrder(-1);			
		});
	}

	@Test
	void testByPrefixOrderLessThanR() {
		Term term1 = new Term("to", 0);
		Term term2 = new Term("tom", 0);
		boolean result = Term.byPrefixOrder(3).compare(term1, term2) < 1;
		assertTrue(result);
	}
	
	@Test
	void testByPrefixOrderLessThanZero() {
		Term term1 = new Term("toffee", 0);
		Term term2 = new Term("tom", 0);
		boolean result = Term.byPrefixOrder(3).compare(term1, term2) < 0;
		assertTrue(result);
	}


	@Test
	void testByPrefixOrderEqualToZero() {
		Term term1 = new Term("tomorrow", 0);
		Term term2 = new Term("tom", 0);
		int expected = 0;
		int actual = Term.byPrefixOrder(3).compare(term1, term2);
		assertEquals(expected, actual);
	}

	@Test
	void testByPrefixOrderGreaterThanZero() {
		Term term1 = new Term("top", 0);
		Term term2 = new Term("tom", 0);
		boolean result = Term.byPrefixOrder(3).compare(term1, term2) > 0;
		assertTrue(result);
	}

	@Test
	void testCompareToLessThanZero() {
		Term term1 = new Term("and", 0);
		Term term2 = new Term("ate", 0);
		boolean result = term1.compareTo(term2) < 0;
		assertTrue(result);
	}

	@Test
	void testCompareToEqualToZero() {
		Term term1 = new Term("and", 0);
		Term term2 = new Term("and", 0);
		boolean result = term1.compareTo(term2) == 0;
		assertTrue(result);
	}

	@Test
	void testCompareToGreaterThanZero() {
		Term term1 = new Term("and", 0);
		Term term2 = new Term("ate", 0);
		boolean result = term2.compareTo(term1) > 0;
		assertTrue(result);
	}

	@Test
	void testToString() {
		Term term1 = new Term("Salt Lake City", 500);
		Term term2 = new Term("Salt Lake City", 500);
		assertEquals(term1.toString(), term2.toString());
	}

}
