package a03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermTest {
	private List<Term> terms;
	private Term t = new Term("computer",13);

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
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
