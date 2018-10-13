package a03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchDeluxeTest {
	Term[] a = {new Term("a", 10), new Term("aab", 8), new Term("abc", 7), new Term("b", 11),
			new Term("baa", 12), new Term("bac", 13)};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFirstIndexOfNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			BinarySearchDeluxe.firstIndexOf(null, null, null);
		});
	}

	@Test
	void testFirstIndexOf_AtFirstElement() {
		Term term = new Term("a", 0);
		int expected = 0;
		int actual = BinarySearchDeluxe.firstIndexOf(a, term, Term.byPrefixOrder(1)) ;
		assertEquals(expected, actual);
	}

	@Test
	void testFirstIndexOf() {
		Term term = new Term("b", 0);
		int expected = 3;
		int actual = BinarySearchDeluxe.firstIndexOf(a, term, Term.byPrefixOrder(1));
		assertEquals(expected, actual);
	}

	@Test
	void testFirstIndexOf_AtLastElement() {
		Term term = new Term("bac", 0);
		int expected = 5;
		int actual = BinarySearchDeluxe.firstIndexOf(a, term, Term.byPrefixOrder(3));
		assertEquals(expected, actual);
	}

	@Test
	void testLastIndexOfNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			BinarySearchDeluxe.firstIndexOf(null, null, null);
		});
	}

	void testLastIndexOf_AtFirstElement() {
		Term[] a = {new Term("c", 10), new Term("cab", 8), new Term("cba", 7), new Term("b", 11),
				new Term("baa", 12), new Term("bac", 13)};
		Term term = new Term("c", 0);
		int expected = 0;
		int actual = BinarySearchDeluxe.lastIndexOf(a, term, Term.byPrefixOrder(1)) ;
		assertEquals(expected, actual);
	}

	void testLastIndexOf() {
		Term term = new Term("c", 0);
		int expected = 2;
		int actual = BinarySearchDeluxe.lastIndexOf(a, term, Term.byPrefixOrder(1)) ;
		assertEquals(expected, actual);
	}

	void testLastIndexOf_AtLastElement() {
		Term term = new Term("b", 0);
		int expected = 5;
		int actual = BinarySearchDeluxe.lastIndexOf(a, term, Term.byPrefixOrder(1)) ;
		assertEquals(expected, actual);
	}

}
