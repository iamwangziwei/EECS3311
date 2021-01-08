package myUtil;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMyLinkedHashSet extends TestSet {

	@Override
	protected MySet<String> loadSet() {
		return new MyLinkedHashSet<String>();
		// COMPLETE THIS
	}

	// add some new test methods
	@Test
	public void test1() {
		// add a new method for ordering
		MySet<String> s = loadSet();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		s.add("f");
		s.add("g");
		s.add("h");
		assertEquals(8, ((MyLinkedHashSet<String>) s).map.size());

		String exp = "[ a b c d e f g h ]";
		assertEquals(exp, s.toString());

	}

	@Test
	public void test2() {
		MySet<String> s = loadSet();
		s.add("i");
		s.add("g");
		s.add("k");

		s.clear();

		assertEquals(0, ((MyLinkedHashSet<String>) s).map.size());

	}

	@Test
	public void testAddLinked() {
		// add a new method for ordering
		MySet<String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		s.add("Cindy");
		s.add("Joe");

		assertEquals(5, ((MyLinkedHashSet<String>) s).map.size());

		String exp = "[ Alice Sue Bob Cindy Joe ]"; // insertion order
		assertEquals(exp, s.toString());

	}

	@Test
	public void testSetUnionLinked() {
		MySet<String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");

		MySet<String> s2 = loadSet();
		s2.add("Cindy");
		s2.add("Sue");
		s2.add("Joe");

		s.addAll(s2);

		assertEquals(5, ((MyLinkedHashSet<String>) s).map.size());

		String exp = "[ Alice Sue Bob Cindy Joe ]"; // insertion order
		assertEquals(exp, s.toString());
	}

	@Test
	public void testSetClearLinked() {
		MySet<String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");

		s.clear();

		assertEquals(0, ((MyLinkedHashSet<String>) s).map.size());

	}

}