package a03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutocompleteTest {
	private Term[] terms = {
			new Term("company", 133159.0), new Term("complete", 78039.0),
			new Term("companion", 60384.9), new Term("completely", 52050.3),
			new Term("comply", 44817.7)
	};
	private Autocomplete matches;
	
	@BeforeEach
	void setUp() throws Exception {
		matches = new Autocomplete(terms);
	}

	@Test
	void testAutocomplete() {
		assertThrows(NullPointerException.class, () -> {
			Term[] t = null;
			new Autocomplete(t);
		});
	}

	@Test
	void testAllMatches() {
		Term[] match1 = matches.allMatches("c");
		assertEquals(terms.length, match1.length);
	}

	@Test
	void testNumberOfMatches() {
		fail("Not yet implemented");
	}

}
