package myUtil;

import java.util.HashMap;
import java.util.Iterator;

public class MyHashSet<E> extends MyAbstractSet<E> {

	protected HashMap<E, Object> map; // non-private for testing purposes

	/**
	 * Dummy value to associate with an Object in the backing Map used as vlaues for
	 * all the keys in the backing Map
	 */
	private static final Object PRESENT = new Object();

	/**
	 * Constructs a new, empty set;
	 */
	public MyHashSet() {
		map = new HashMap<>();
	}

	/**
	 * Create an empty set of default capacity
	 * 
	 */
	public MyHashSet(int initialCapacity) {
		super(); // can be skipped
		this.map = new HashMap<>(initialCapacity);
	}

	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public boolean contains(E o) {
		// COMPLETE THIS
		if (map.containsKey(o))
			return true;
		else
			return false;
	}

	@Override
	// Hint. add e into map as key, with the Dummy object PRESENT as value.
	// Hint. look Map API for the return type of put
	public boolean add(E e) {
		// COMPLETE THIS
		if (this.contains(e))
			return false;
		else {
			map.put(e, null);
			return true;
		}
	}

	@Override
	public boolean remove(E o) {
		// COMPLETE THIS
		if (!this.contains(o))
			return false;
		else {
			map.remove(o);
			return true;
		}
	}

	@Override
	public void clear() {
		// COMPLETE THIS
		map = new HashMap<>();
	}

	// Other methods, such as the following size(), isEmpty(), addAll(), toString()
	// are inherited from MyAbstractSet

	@Override
	public int size() {
		return map.size();
	}

}
