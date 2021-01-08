package myUtil;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;



public class TestMyArrayList {

	@Test
	public void test_initialAndGeneric() {
		MyArrayList<String> arrL = new MyArrayList<>();
		 
		int leng = ((Object[])arrL.elementData).length;
		assertEquals(10, leng);
		String exp [] = {null, null, null, null, null, null, null,null, null, null};
		assertArrayEquals(exp, arrL.elementData);
		assertEquals(0, arrL.size());
		assertTrue(arrL.isEmpty());
		
		MyArrayList<Integer> arrL2 = new MyArrayList<>();
		assertEquals(10, ((Object[])arrL2.elementData).length);
		assertEquals(0, arrL2.size());
		assertTrue(arrL2.isEmpty());
		
		
		MyArrayList<Double> arrL3 = new MyArrayList<>(3);
		System.out.println(Arrays.toString(arrL3.elementData));
		assertEquals(3, ((Object[])arrL3.elementData).length);
		String exp2 [] = {null, null, null};
		assertArrayEquals(exp2, arrL3.elementData);
		assertEquals(0, arrL3.size());
		assertTrue(arrL3.isEmpty());
		
				
	}
	
	// queries
	@Test
	public void test_getContainIndexSet() {
		MyArrayList<String> arrL = new MyArrayList<>();
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.size=7;
		arrL.elementData = tmp;
		
		assertEquals("EECS", arrL.get(0));
		assertEquals("2030", arrL.get(1));
		assertEquals("Example about", arrL.get(3)); 
		assertEquals("Class", arrL.get(2));
		assertEquals("List", arrL.get(5)); 
		
		assertTrue(arrL.contains("Array"));
		assertFalse(arrL.contains("Arrays"));
		assertTrue(arrL.contains("Class"));
		
		assertEquals(0, arrL.indexOf("EECS"));
		assertEquals(4, arrL.indexOf("Array"));
		assertEquals(-1, arrL.indexOf("Arrays"));
		assertEquals(6, arrL.lastIndexOf("Array"));
		
		
		// set
		String resu = arrL.set(1, "2030MZ");
		String[] exp3 = {"EECS", "2030MZ", "Class","Example about", "Array", "List", "Array", null, null,null};
		assertArrayEquals(exp3, arrL.elementData);
		assertEquals(7, arrL.size());
		assertEquals("2030", resu);
		
		String resu2 = arrL.set(3, "XXX YYY");
		String[] exp4 = {"EECS", "2030MZ", "Class","XXX YYY", "Array", "List", "Array", null, null,null};
		assertArrayEquals(exp4, arrL.elementData);
		assertEquals(7, arrL.size());
		assertEquals("Example about", resu2);
	}
	
	
	@Test
	public void test_add() {
		MyArrayList<String> arrL = new MyArrayList<>();
		 
		arrL.add("EECS");   arrL.add("2030");
		arrL.add("Class");  arrL.add("Example about");
		String[] exp = {"EECS", "2030", "Class","Example about", null, null, null, null, null,null};
		assertArrayEquals(exp, arrL.elementData);
		assertEquals(4, arrL.size());
		assertFalse(arrL.isEmpty());
		assertEquals(2, arrL.indexOf("Class"));
		
		arrL.add("Array");  arrL.add("List");
		String[] exp2 = {"EECS", "2030", "Class","Example about", "Array", "List", null, null, null,null};
		assertArrayEquals(exp2, arrL.elementData);
		assertEquals(6, arrL.size());
		assertFalse(arrL.isEmpty());
		assertEquals(2, arrL.indexOf("Class")); // no change
			
	}
	
	@Test
	public void test_addIndex() {
		MyArrayList<String> arrL = new MyArrayList<>();
		arrL.add("EECS");   arrL.add("2030");
		arrL.add("Class");  arrL.add("Example about");
		arrL.add("Array");  arrL.add("List");
		assertEquals(0, arrL.indexOf("EECS"));
		assertEquals(2, arrL.indexOf("Class"));
		assertEquals(4, arrL.indexOf("Array"));
		
		arrL.add(1, "XXX");
		String[] exp = {"EECS", "XXX", "2030", "Class","Example about", "Array", "List", null, null, null};
		assertArrayEquals(exp, arrL.elementData);
		assertEquals(7, arrL.size());
		assertEquals(0, arrL.indexOf("EECS"));
		assertEquals(3, arrL.indexOf("Class"));
		assertEquals(5, arrL.indexOf("Array"));
		
		arrL.add(3, "YYY");
		String exp2[] = {"EECS", "XXX", "2030", "YYY", "Class","Example about", "Array", "List", null, null};
		assertArrayEquals(exp2, arrL.elementData);
		assertEquals(8, arrL.size());
		assertEquals(0, arrL.indexOf("EECS"));
		assertEquals(4, arrL.indexOf("Class"));
		assertEquals(6, arrL.indexOf("Array"));
	}
	
	@Test
	public void test_remove() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.size=7;
		arrL.elementData = tmp;
		
		assertEquals(1, arrL.indexOf("2030"));
		assertEquals(4, arrL.indexOf("Array")); // first occurrence
		
		arrL.remove("EECSX"); //nothing happen
		String exp[] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		assertArrayEquals(exp, arrL.elementData);
		
		
		arrL.remove("EECS");  
		String exp2[] = {"2030", "Class","Example about", "Array", "List", "Array", null,null, null,null};
		assertArrayEquals(exp2, arrL.elementData);
		assertEquals(6, arrL.size());
		assertEquals(0, arrL.indexOf("2030"));
		assertEquals(3, arrL.indexOf("Array")); // first occurrence
		
		arrL.remove("Array");  
		System.out.println(Arrays.toString(arrL.elementData));
		String exp3[] = {"2030", "Class","Example about",  "List", "Array", null,null,null, null,null};
		assertArrayEquals(exp3, arrL.elementData);
		assertEquals(5, arrL.size());
		assertEquals(0, arrL.indexOf("2030"));
		assertEquals(4, arrL.indexOf("Array")); // first occurrence
	}
	
	@Test
	public void test_removeIndex() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.size=7;
		arrL.elementData = tmp;
		
		assertEquals(1, arrL.indexOf("2030"));
		assertEquals(4, arrL.indexOf("Array")); // first occurrence
		
		arrL.remove(2); 
		String exp[] = {"EECS", "2030", "Example about", "Array", "List", "Array", null,null,null, null};
		assertArrayEquals(exp, arrL.elementData);
		assertEquals(6, arrL.size());
		assertEquals(1, arrL.indexOf("2030"));
		assertEquals(3, arrL.indexOf("Array")); // first occurrence
		
		
		String resu = arrL.remove(0);  
		String exp2[] = {"2030", "Example about", "Array", "List", "Array", null,null,null, null,null};
		assertArrayEquals(exp2, arrL.elementData);
		assertEquals(5, arrL.size());
		assertEquals("EECS", resu);
		assertEquals(0, arrL.indexOf("2030"));
		assertEquals(2, arrL.indexOf("Array")); // first occurrence
		
		
		resu = arrL.remove(2); 
		//System.out.println(Arrays.toString(arrL.elementData));
		String exp3[] = {"2030", "Example about",  "List", "Array", null,null,null,null, null,null};
		assertArrayEquals(exp3, arrL.elementData);
		assertEquals("Array", resu);
		assertEquals(4, arrL.size());
		assertEquals(0, arrL.indexOf("2030"));
		assertEquals(3, arrL.indexOf("Array")); // first occurrence
	}
	
	// test expansion
	@Test
	public void testExpansion() {
		MyArrayList<String> arrL = new MyArrayList<>();
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", "How", "Are","You"};
		arrL.size=10;
		arrL.elementData = tmp;
		
		arrL.add("XXX");
		String exp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", "How", "Are","You", 
				    "XXX", null, null, null, null, null, null, null, null, null};
		assertArrayEquals(exp, arrL.elementData);
		assertEquals(20, ((Object[])arrL.elementData).length);
		assertEquals(11, arrL.size());
		
		
	}
	
	@Test
	public void testExpansion2() {
		MyArrayList<Integer> arrL = new MyArrayList<>();
		// manually do this to avoid using add()
		Integer tmp [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		arrL.size=20;
		arrL.elementData = tmp;
		
		arrL.add(100);
		Integer exp [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,100,null, null, null, null, null, null, null, null, null };
		assertArrayEquals(exp, arrL.elementData);
		assertEquals(30, ((Object[])arrL.elementData).length);
		assertEquals(21, arrL.size());
		
		
	}
	
	
	// finally test index out of bound
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetExp() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using get()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.get(-2);
		 
    }
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetExp2() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using get()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.get(13);
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetExp() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using get()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.set(-2, "xx");
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetExp2() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using get()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.set(9, "xx");
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddExp() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.add(-2, "xx");
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddExp2() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.add(9, "xx");
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveExp() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.remove(-2);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveExp2() {
		MyArrayList<String> arrL = new MyArrayList<>();
		
		// manually do this to avoid using add()
		String tmp [] = {"EECS", "2030", "Class","Example about", "Array", "List", "Array", null,null, null};
		arrL.elementData = tmp;
		arrL.size=7;
		arrL.remove(9);
    }
	
	
    
	
	
	
	
	
	
	
	

}
