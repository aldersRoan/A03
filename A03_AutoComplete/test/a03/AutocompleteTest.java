package a03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutocompleteTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAutocomplete() {
		fail("Not yet implemented");
	}

	@Test
	void testAllMatches() {
		Term[] terms = {
				new Term("company", 133159.0), 
				new Term("complete", 78039.0),
				new Term("companion", 60384.9),
				new Term("completely", 52050.3),
				new Term("comply", 44817.7)
		};
		Autocomplete matches = new Autocomplete(terms);
		Term[] match1 = matches.allMatches("compa");
		assertEquals(terms.length, match1.length);
	}

	@Test
	void testNumberOfMatches() {
		fail("Not yet implemented");
	}

}
