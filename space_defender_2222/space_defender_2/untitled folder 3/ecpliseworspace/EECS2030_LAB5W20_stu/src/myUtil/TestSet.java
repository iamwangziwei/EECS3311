package myUtil;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import static org.junit.Assert.fail;

import org.junit.Test;

public abstract class TestSet {
	
	protected abstract MySet<String> loadSet();
	
	
	@Test
	public void testEmptySetSize() {
		MySet<String> s = loadSet();
		assertEquals(0, s.size());
	}
	
	@Test
	public void testOneItemSetSize() {
		MySet<String> s = loadSet();
		s.add("A");
		assertEquals(1, s.size());
		assertTrue(s.contains("A"));
		
	
	} 
	 
	@Test
	public void testFiveItemSetSize() {
		MySet <String> s = loadSet();
		assertTrue(s.add("Alice"));
		assertTrue(s.add("Sue"));
		assertTrue(s.add("Bob"));
		assertTrue(s.add("Cindy"));
		assertTrue(s.add("Joe"));
		
		assertEquals(5, s.size());
		assertTrue(s.contains("Alice"));
		assertTrue(s.contains("Sue"));
		assertTrue(s.contains("Bob"));
		assertTrue(s.contains("Cindy"));
		assertTrue(s.contains("Joe"));
		assertFalse(s.contains("Judy"));
		
		
		// add duplicate
		assertFalse(s.add("Cindy"));
		assertFalse(s.add("Joe"));
		assertEquals(5, s.size());
	} 
	
	@Test
	public void testRemove() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		s.add("Cindy");
		s.add("Joe");
		
		assertFalse(s.remove("Judy")); // nothing happen
		assertEquals(5, s.size());
		
		 
		assertTrue(s.remove("Cindy"));
		assertEquals(4, s.size());
		assertFalse( s.contains("Cindy"));
		
		assertTrue(s.remove("Joe"));
		assertEquals(3, s.size());
		assertFalse( s.contains("Cindy"));
	} 
	
	@Test
	public void testSetUnion() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		
		MySet <String> s2 = loadSet();
		s2.add("Cindy");
		s2.add("Sue");
		s2.add("Joe");
		
		s.addAll(s2);
		assertEquals(5, s.size());
		assertTrue( s.contains("Alice"));
		assertTrue( s.contains("Sue"));
		assertTrue( s.contains("Bob"));
		assertTrue( s.contains("Cindy"));
		assertTrue( s.contains("Joe"));
		
	} 
	
	@Test
	public void testClear() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		System.out.println(s.size());
		
		s.clear();
		System.out.println(s.size());
		assertEquals(0, s.size());
		assertFalse( s.contains("Alice"));
		assertFalse( s.contains("Sue"));
		assertFalse( s.contains("Bob"));
		assertEquals("[ ]", s.toString());		
	} 
	
	
		 
	
}
