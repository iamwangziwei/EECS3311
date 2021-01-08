package lab0package;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * A random assortment of methods reviewing topics that should have been covered
 * in your previous programming courses.
 *
 */

public class lab0 {

	private lab0() {
		// empty to prevent object creation
	}

	/**
	 * Returns the value 1.
	 * 
	 * @return the value 1
	 */
	public static int one() {
		return 1;
	}

	/**
	 * [Question 1]
	 * <p>
	 * <strong> Divisibility </strong> : When dividing an integer by a second
	 * nonzero integer, the quotient may or may not be an integer.
	 * </p>
	 * <p>
	 * For example, 12/3 = 4 while 9/4 = 2.25.
	 * </p>
	 * <p>
	 * <strong>Definition </strong>: <em> If {@code a} and {@code b} are integers
	 * with {@code a} is not equal to zero , we say that {@code b} divided by
	 * {@code a} if there exists an integer {@code c} such that {@code b = ac}.</em>
	 * </p>
	 * <p>
	 * This method take two integers {@code a} and {@code b}, then it return true if
	 * {@code b} divided by {@code a }
	 * </p>
	 * 
	 * <pre>
	 *  Example:
	 *  
	 *  isDivisible ( 3, 5) returns false 
	 *  isDivisible ( 5, 21) returns false
	 *  isDivisible ( 75, 512) returns false
	 *  isDivisible ( 5, 10) returns true 
	 *  isDivisible ( 22, 198) returns true 
	 *  isDivisible ( 64, 512) returns true
	 * </pre>
	 * 
	 * @param a integer not equal to zero
	 * @param b integer not equal to zero
	 * @return true if {@code b} divided by {@code a} @pre. {@code a != 0} , and
	 *         {@code b != 0}
	 */

	public static boolean isDivisible(int a, int b) {
		if (a <= 0 || b <= 0)
			return true;

		if (b % a == 0)
			return true;
		else
			return false;
	}

	/**
	 * [Question 2]
	 * <p>
	 * <strong> Primes</strong>
	 * </p>
	 * <p>
	 * A <em> positive integer </em> {@code n > 1} is called <strong> prime</strong>
	 * if the only positive factors of {@code n} are {@code  1} and {@code  n} . A
	 * positive integer that is greater than one and is not prime is called <strong>
	 * composite</strong>.
	 * </p>
	 * <p>
	 * An integer {@code  n} is <strong> composite </strong> if and only if there
	 * exists an integer {@code a} such that <strong> <em> {@code a} divides
	 * {@code n} </em></strong> and {@code 1 < a < n}.
	 * </p>
	 * 
	 * <p>
	 * <strong> Hint: 1 is neither prime nor composite. It forms its own special
	 * category as a "unit".</strong>
	 * </p>
	 * 
	 * <p>
	 * This method checks the positive integer if it is prime or not.
	 * </p>
	 * 
	 * <pre>
	 *  Example:
	 *  
	 *  isPrime ( -5) returns false 
	 *  isPrime ( 6) returns false
	 *  isPrime ( 25) returns false
	 *  isPrime ( 2) returns true 
	 *  isPrime ( 3) returns true 
	 *  isPrime ( 13) returns true 
	 *  isPrime ( 17) returns true 
	 *  isPrime ( 29) returns true
	 * </pre>
	 * 
	 * @param n positive integer
	 * @return true if number {@code n} is prime, else false @pre. {@code n > 0}
	 */
	public static boolean isPrime(int n) {
		boolean result = true;
		if (n < 0)
			result = false;
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				result = false;
				break;
			} else
				continue;

		}
		return result;
	}

	/**
	 * [Question 3] Computes the standard Gaussian distribution probability density
	 * function (see the lab document for the actual formula) with scale parameter.
	 * 
	 * @param x     a value
	 * @param sigma scale parameter
	 * @return the standard Rayleigh distribution probability density function
	 *         evaluated at x
	 */
	public static double gaussian(double x, int sigma) {
		return (Math.pow(Math.E, -Math.pow(x, 2) / 2 * Math.pow(sigma, 2))) / (sigma * Math.sqrt(2 * Math.PI));
	}

	/**
	 * [Question 4]
	 * 
	 *
	 * Write a Java program to test if an array contains a specific value. This
	 * contains method receives an array of integers and integer as input, then
	 * determines whether this integer exists in the array or not.
	 * <p>
	 * <strong> You can assume that the array is not empty and contains at least 1
	 * one element.</strong>
	 * </p>
	 * <p>
	 * For example:
	 * </p>
	 * 
	 * <pre>
	* if arr = {3, 6} and a=4 then return false
	* if arr = { 1, 1, 1} and a =1 then return true
	 * </pre>
	 * 
	 * @param arr is the input array of integers
	 * @param a   is the separate integer to be found out from the array
	 * @return boolean output true or false
	 */
	public static boolean contains(int[] arr, int a) {
		boolean result = false;
		for (int i : arr) {
			if (i == a)
				result = true;
		}
		return result;
	}

	/**
	 * [Question 5]
	 * 
	 * Java program to find largest number in an array This maximum method check all
	 * elements of the input array of integers and returns the maximum integer value
	 * <p>
	 * <strong> You can assume that the array is not empty and contains at least 1
	 * one element.</strong>
	 * </p>
	 * <p>
	 * <strong>Your are forbidden to use any library class, e.g., Arrays.sort.
	 * </strong>
	 * </p>
	 * <p>
	 * For example:
	 * </p>
	 * 
	 * <pre>
	* if arr = { 4, 2, 5} then return 5
	 *
	 * </pre>
	 * 
	 * @param arr is the input array of integers
	 * @return maximum integer in the array
	 */
	public static int maximum(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max)
				max = i;
		}
		return max;
	}

	/**
	 * [Question 6] This method reverseOf received an array of integers, then return
	 * the input array in reverse element order.
	 * <p>
	 * <strong> You can assume that the array is not empty and contains at least 1
	 * one element.</strong>
	 * </p>
	 * <p>
	 * <strong>You are forbidden to use any library class, e.g., Arrays.sort.
	 * </strong>
	 * </p>
	 * <p>
	 * For example:
	 * </p>
	 * 
	 * <pre>
	* if inputarray = { 4, 2, 5} then return {5, 2, 4}
	 *
	 * </pre>
	 *
	 *
	 * @param inputarray input array of integer need to be reverse element-wise
	 * @return the input array in reverse element order
	 */
	public static int[] reverseOf(int[] inputarray) {
		int[] newa = new int[inputarray.length];
		for (int i = 0; i < inputarray.length; i++) {
			newa[inputarray.length - i - 1] = inputarray[i];
		}

		return newa;
	}

	/**
	 * [Question 7] Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the range is
	 * considered outside of the range.
	 * 
	 * @param x     a value
	 * @param range a Range to check
	 * @return the value 1 if x is strictly inside the given Range, and 0 otherwise
	 */
	public static int contains1(double x, Range range) {
		if (x < range.getMaximum() && x > range.getMinimum())
			return 1;
		else
			return 0;
	}

	/**
	 * [Question 8] Compares two <code>Range</code> instances by their widths.
	 * 
	 * @param r1 a Range
	 * @param r2 a second Range
	 * @return the value 0 if both Range instances are equal; -1 if r1 is narrower
	 *         than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		if ((r1.getMaximum() - r1.getMinimum()) >= (r2.getMaximum() - r2.getMinimum())) {
			if ((r1.getMaximum() - r1.getMinimum()) > (r2.getMaximum() - r2.getMinimum()))
				return 1;
			else
				return 0;
		} else
			return -1;

	}

	/**
	 * [Question 9] Partially validates a string that is supposed to represent a
	 * time on a 24-hour clock. Returns <code>true</code> if:
	 * 
	 * <ul>
	 * <li>the string has length equal to <code>5</code>, AND
	 * <li>the third character is a colon <code>:</code>
	 * </ul>
	 * 
	 * <p>
	 * and <code>false</code> otherwise.
	 * 
	 * @param s a string to validate
	 * @return true if the string length is 5 and the third character is a colon,
	 *         and false otherwise
	 */
	public static boolean hasValidLengthAndSeparator(String s) {
		if (s.length() == 5 && s.charAt(2) == ':')
			return true;
		else
			return false;
	}

	/**
	 * [Question 10a] Sorts a list of two integers so that the elements are in
	 * ascending order. The size of the list remains unchanged.
	 * 
	 * @param t a list
	 * @throws IllegalArgumentException if the size of list is not equal to 2
	 */
	public static void sort2(List<Integer> t) {
		if (t.size() != 2)
			throw new IllegalArgumentException();
		if (t.get(0) > t.get(1)) {
			int n = t.get(0);
			int k = t.get(1);
			t.clear();
			t.add(0, k);
			t.add(1, n);

		}
	}

	/**
	 * [Question 10b] Replaces the elements of a list of angles in degrees with the
	 * equivalent angles in radians. The size of the list remains unchanged.
	 * 
	 * @param t a list of angles in degrees
	 */
	public static void toRadians(List<Double> t) {
		List<Double> newl = new ArrayList<Double>();
		for (int i = 0; i < t.size(); i++) {
			newl.add(Math.toRadians(t.get(i)));
		}
		t.clear();
		for (int i = 0; i < newl.size(); i++) {
			t.add(newl.get(i));
		}
	}

	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The string contains the minimum and maximum values separated by a comma and
	 * space all inside of a pair of parentheses. For example, the string
	 * 
	 * <p>
	 * <code>(-3.14, 3.14)</code>
	 * 
	 * <p>
	 * represents the range whose minimum value is <code>-3.14</code> and whose
	 * maximum value is <code>3.14</code>
	 * 
	 * @param r a Range instance
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {
		return "(" + r.getMinimum() + ", " + r.getMaximum() + ")";
	}

	/**
	 * Returns a new list of characters formed by shuffling the characters of the
	 * given list. It is a precondition that the given list t contains at least two
	 * elements, and that the number of elements is an even number. The list is not
	 * modified by this method.
	 * 
	 * <p>
	 * To shuffle the characters in t, imagine splitting the list t in half so that
	 * the first (n / 2) characters of t are in one sublist, and the remaining (n /
	 * 2) characters of t are in the second sublist. The new returned list is formed
	 * by adding the first character of the first sublist to the new list, then
	 * adding the first character of the second sublist, then adding the second
	 * character of the first sublist, then adding the second character of the
	 * second sublist, and so on, until all of the characters in the two sublists
	 * are added to the new list.
	 * 
	 * <p>
	 * For example, if t was the list:
	 * 
	 * <pre>
	 * ['a', 'b', 'c', 'd', 'e', 'f']
	 * </pre>
	 * 
	 * <p>
	 * then splitting t into two sublists yields:
	 * 
	 * <pre>
	 * ['a', 'b', 'c'] and ['d', 'e', 'f']
	 * </pre>
	 * 
	 * <p>
	 * Take the first two characters of each sublist and add them to the new list:
	 * 
	 * <pre>
	 * ['a', 'd']
	 * </pre>
	 * 
	 * <p>
	 * Then take the next two characters of each sublist and add them to the new
	 * list:
	 * 
	 * <pre>
	 * ['a', 'd', 'b', 'e']
	 * </pre>
	 * 
	 * <p>
	 * Then take the next two characters of each sublist and add them to the new
	 * list:
	 * 
	 * <pre>
	 * ['a', 'd', 'b', 'e', 'c', 'f']
	 * </pre>
	 * 
	 * @param t a non-null list of characters
	 * @return a new list equal to the shuffle of the characters in t @pre. t is not
	 *         null @pre. t.size() is greater than or equal to 2 @pre. t.size() is
	 *         an even number
	 */
	public static List<Character> shuffle(List<Character> t) {
		List<Character> l1 = new ArrayList<Character>();
		List<Character> l2 = new ArrayList<Character>();
		List<Character> newl = new ArrayList<Character>();
		for (int i = 0; i < t.size() / 2; i++) {
			l1.add(t.get(i));
		}
		for (int i = t.size() / 2; i < t.size(); i++) {
			l2.add(t.get(i));
		}
		for (int i = 0; i < t.size() / 2; i++) {
			newl.add(l1.get(i));
			newl.add(l2.get(i));
		}
		return newl;

	}

}
