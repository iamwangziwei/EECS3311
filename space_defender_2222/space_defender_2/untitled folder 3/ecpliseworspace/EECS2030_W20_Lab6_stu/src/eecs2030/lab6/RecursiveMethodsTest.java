package eecs2030.lab6;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;



import org.junit.FixMethodOrder;
import org.junit.Rule;
//import org.junit.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RecursiveMethodsTest {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	public static double delta = 0.0000001;
	
	//@Rule
	//public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	
	 
	/*******************************************************************/
	@Test
	public void test_IntegerToBinary_01() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(1);
		int[] exp = {1};
		assertArrayEquals(exp, rest);
		
		
		
		
	}
	@Test
	public void test_IntegerToBinary_02() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(4);
		
		//for(int i =0;i<rest.length;i++)
			
			
		//	System.out.println(rest[i]);
		
		int[] exp = {1, 0, 0};
		assertArrayEquals(exp, rest);
		
	}
	@Test
	public void test_IntegerToBinary_03() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(9);
		int[] exp = {1,0,0,1};
		assertArrayEquals(exp, rest);
		
	}
	
	@Test
	public void test_IntegerToBinary_04() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(13);
		int[] exp = {1,1,0,1};
		assertArrayEquals(exp, rest);
		
	}
	
	@Test
	public void test_IntegerToBinary_05() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(32);
		int[] exp = {1, 0, 0, 0, 0,0};
		assertArrayEquals(exp, rest);
		
	}
	@Test
	public void test_IntegerToBinary_06() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(107);
		int[] exp = {1, 1, 0, 1, 0, 1,1};
		assertArrayEquals(exp, rest);
		
	}
	@Test
	public void test_IntegerToBinary_07() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(65535);
		int[] exp = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		assertArrayEquals(exp, rest);
		
	}
	/*******************************************************************/
	@Test
	public void test_numberOfFirstChar0_01() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar0("aaaxd%fdsaefg");
		
		int  exp = 4;
		assertTrue( exp==rest );
	}
	
	
	@Test
	public void test_numberOfFirstChar0_02() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar0("drfefdsefg");
		int  exp = 2;
		assertTrue( exp==rest );
	}
	
	@Test
	public void test_numberOfFirstChar0_03() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("");
		int  exp = 0;
		assertTrue( exp==rest );
	}
	
	@Test
	public void test_numberOfFirstChar0_04() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar0("bbbcfreb$b");
		int  exp = 5;
	
		assertTrue( exp==rest );
	}
	
	/*************************************************************/
	
	@Test
	public void test_numberOfFirstChar_01() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("aaaxd%fdsaefg");
		int  exp = 3;
		assertTrue( exp==rest );
	}
	
	
	@Test
	public void test_numberOfFirstChar_02() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("drfefdsefg");
		int  exp = 1;
		assertTrue( exp==rest );
	}
	
	@Test
	public void test_numberOfFirstChar_03() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("");
		int  exp = 0;
		assertTrue( exp==rest );
	}
	
	@Test
	public void test_numberOfFirstChar_04() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("bbbcfreb$b");
		int  exp = 3;
		assertTrue( exp==rest );
	}
/******************************************************************/
	@Test
	public void test_yorknacci_01() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(0);
		int  exp = 1;
		assertTrue(exp==rest);
	}
	@Test
	public void test_yorknacci_02() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(1);
		int  exp = 1;
		assertTrue(exp==rest);
	}
	
	@Test
	public void test_yorknacci_03() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(2);
		int  exp = 1;
		assertTrue(exp==rest);
	}
	
	@Test
	public void test_yorknacci_04() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(4);
		int  exp = 4;
		assertTrue(exp==rest);
	}
	
	
	@Test
	public void test_yorknacci_05() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(20);
		int  exp = 26244;
		assertTrue(exp==rest);
	}
	
	 
	/******************************************************************/
	@Test
	public void test_repeatCharNTimes_01() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(4, 'e');
		
		String exp = "eeee" ;
		assertTrue(exp.equals(rest));
	}
	@Test
	public void test_repeatCharNTimes_02() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(10, 'A');
		String exp = "AAAAAAAAAA" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_repeatCharNTimes_03() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(0, 'A');
		System.out.println(rest);
		String exp = "" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_repeatCharNTimes_04() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(7, 'A');
		String exp = "AAAAAAA" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_repeatCharNTimes_05() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(10, '*');
		String exp = "**********" ;
		assertTrue(exp.equals(rest));
	}
	
	/********************************************************************/
	@Test
	public void test_maxChar_00() {
		RecursiveMethods rm = new RecursiveMethods();
		char c = rm.maxChar("h");
		char exp = 'h' ;
		assertEquals(exp, c);
	}
	
	 @Test
	public void test_maxChar_01() {
		RecursiveMethods rm = new RecursiveMethods();
		char c = rm.maxChar("abbL");
		char exp = 'b' ;
		assertEquals(exp, c);
	}
	@Test
	public void test_maxChar_02() {
		RecursiveMethods rm = new RecursiveMethods();
		char c = rm.maxChar("helloWORLD");
		char exp = 'o' ;
		assertEquals(exp, c);
	}
	@Test
	public void test_maxChar_03() {
		RecursiveMethods rm = new RecursiveMethods();
		char c = rm.maxChar("helloworld");
		char exp = 'w' ;
		assertEquals(exp, c);
	}
	@Test
	public void test_maxChar_04() {
		RecursiveMethods rm = new RecursiveMethods();
		char c = rm.maxChar("abbxL ? 12 x5y @");
		char exp = 'y' ;
		assertEquals(exp, c);
	}
	
	
	@Test
	public void test_maxChar_05() {
		RecursiveMethods rm = new RecursiveMethods();
		char c = rm.maxChar("abc123cab@");
		char exp = 'c' ;
		assertEquals(exp, c);
	}
	/********************************************************************/
	@Test
	public void test_power_00() {
		RecursiveMethods rm = new RecursiveMethods();
		double c = rm.power(2, 0);
		//System.out.println(c);
		double exp = 1;
		assertEquals(exp, c, delta);
	}
	
	@Test
	public void test_power_01() {
		RecursiveMethods rm = new RecursiveMethods();
		double c = rm.power(2, 3);
		//System.out.println(c);
		double exp = 8;
		assertEquals(exp, c, delta);
	}
	 @Test
	public void test_power_02() {
		RecursiveMethods rm = new RecursiveMethods();
		double c = rm.power(-2, 5);
		//System.out.println(c);
		double exp = -32;
		assertEquals(exp, c, delta);
	}
	 @Test
	public void test_power_03() {
		RecursiveMethods rm = new RecursiveMethods();
		double c = rm.power(2, -3);
		//System.out.println(c);
		double exp = 0.125;
		assertEquals(exp, c, delta);
		}
	
	 @Test
	public void test_power_04() {
		RecursiveMethods rm = new RecursiveMethods();
		double c = rm.power(2, -6);
		//System.out.println(c);
		double exp = 0.015625;
		assertEquals(exp, c, delta);
	}
	
	 @Test
	public void test_power_05() {
		RecursiveMethods rm = new RecursiveMethods();
		double c = rm.power(-2, -5);
		//System.out.println(c);
		double exp = -0.03125;
		assertEquals(exp, c, delta);
	}
	/********************************************************************/
	 @Test
	public void test_readLine_01() throws FileNotFoundException{
		RecursiveMethods rm = new RecursiveMethods();
		//System.out.println(System.getProperty("user.dir") + System.getProperty("file.separator"));
		Scanner scan = new Scanner(new File("file.txt"));//file.txt"));
		System.out.println("------------------------");
		rm.printLines(scan);
		System.out.println("------------------------");
		//System.out.println(systemOutRule.getLog());
		 
	}
	 
	 /********************************************************************/
	   @Test
		public void test_palindrome_01() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("d");
			assertTrue(c);
		}
	   @Test
		public void test_palindrome_02() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("dad");
			assertTrue(c);
		}
	    @Test
		public void test_palindrome_03() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("Dad");
			assertFalse(c);
		}
	    @Test
		public void test_palindrome_04() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("li Saxxxas IL");
			assertFalse(c);
		} 
	    @Test
		public void test_palindrome_05() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("li SaxxxaS il");
			assertTrue(c);
		}
	    @Test
		public void test_palindrome_06() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("1234 5 4321");
			assertTrue(c);
		}
	    @Test
		public void test_palindrome_07() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("that is a is taht");
			assertFalse(c);
		}
	    @Test
		public void test_palindrome_08() {
			RecursiveMethods rm = new RecursiveMethods();
			boolean c = rm.isPalindrome("that is a si taht");
			assertTrue(c);
		}
	    /********************************************************************/
	    @Test
		public void test_sum_00() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> li = new ArrayList<>();
			int s = rm.sum(li);
			int exp = 0;
			assertSame(exp, s);
			
			li = new LinkedList<>();
			assertSame(exp, rm.sum(li));
		}
			
	    @Test
		public void test_sum_01() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> li = Arrays.asList(7);
			int s = rm.sum(li);
			int exp = 7;
			assertSame(exp, s);
		}
	    
	    @Test
		public void test_sum_02() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> li = Arrays.asList(7,3,5);
			int s = rm.sum(li);
			int exp = 15;
			assertSame(exp, s);
		}
	    @Test
		public void test_sum_03() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> li = Arrays.asList(7,3,5, 6, 8, 9, 2, 0, -1);
			int s = rm.sum(li);
			int exp = 39;
			assertSame(exp, s);
		}
	    
	    /********************************************************************/
	    @Test
		public void test_evenDigits_00() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(0);
			int exp = 1;
			assertSame(exp, c);
		}
	    @Test
		public void test_evenDigits_01() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(3);
			int exp = 0;
			assertSame(exp, c);
		}
	    @Test
		public void test_evenDigits_02() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(2030);
			int exp = 3;
			assertSame(exp, c);
		} 
	    
	    @Test
		public void test_evenDigits_03() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(2031);
			int exp = 2;
			assertSame(exp, c);
		}
	    
	    @Test
		public void test_evenDigits_04() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(1237);
			int exp = 1;
			assertSame(exp, c);
		}
	    @Test
		public void test_evenDigits_05() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(19357);
			int exp = 0;
			assertSame(exp, c);
		}
	    @Test
		public void test_evenDigits_06() {
			RecursiveMethods rm = new RecursiveMethods();
			int c = rm.evenDigits(765342);
			int exp = 3;
			assertSame(exp, c);
		}
	    
	 /********************************************************************/
	    @Test
		public void testIsArithmeticArray_01() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_02() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {7};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_03() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {7, 10};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_04() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {10, 7};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_05() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {1,3, 5};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_06() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {1, 3, 7};
			assertFalse(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_07() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {7, 10, 13, 16, 19, 22, 25, 28};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_08() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {7, 10, 13, 16, 20, 23, 26, 29};
			assertFalse(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_09() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {7, 10, 13, 16, 19, 22, 25, 29};
			assertFalse(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_10() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {29, 26, 23, 20, 17, 14, 11, 8};
			assertTrue(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_11() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {29, 26, 23, 20, 16, 13, 10, 7};
			assertFalse(rm.isArithmeticArray(a));
		}
		
		@Test
		public void testIsArithmeticArray_12() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] a = {29, 25, 22, 19, 16, 13, 10, 7};
			assertFalse(rm.isArithmeticArray(a));
		} 
	 /******************************************************************/
	 private List<Integer> a2l(int[] a) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i ++) {
			list.add(a[i]);
		}
		return list;
	}
	
}
