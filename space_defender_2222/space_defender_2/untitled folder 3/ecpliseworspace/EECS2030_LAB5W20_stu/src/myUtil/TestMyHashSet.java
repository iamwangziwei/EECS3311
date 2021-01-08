package myUtil;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMyHashSet extends TestSet {
	
	@Override
	protected MySet<String> loadSet() {
		return new MyHashSet<String>();
	}
	
	// a few test cases methods
	@Test
	public void testAddHash() {
		// add a new method for ordering
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		s.add("Cindy");
		s.add("Joe");
		
		assertEquals(5, ((MyHashSet<String>)s).map.size());
		
			
	}
	
	@Test
	public void testSetUnionLinked() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		
		MySet <String> s2 = loadSet();
		s2.add("Cindy");
		s2.add("Sue");
		s2.add("Joe");
		
		s.addAll(s2);
		
		assertEquals(5, ((MyHashSet<String>)s).map.size());
		
		 
	} 
	
	@Test
	public void testSetClearLinked() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		
		s.clear();
		
		assertEquals(0, ((MyHashSet<String>)s).map.size());
		
	} 
	
}
