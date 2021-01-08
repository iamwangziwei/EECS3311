package myUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MyLinkedHashSet<E> extends MyAbstractSet<E> {

	private static final int DEFAULT_CAPACITY = 10;

	public LinkedHashMap<E, Object> map; // non-private for testing purposes

	/**
	 * Dummy value to associate with an Object in the backing Map used as vlaues for
	 * all the keys in the backing Map
	 */
	private static final Object PRESENT = new Object();

	/**
	 * Constructs a new, empty set;
	 */
	public MyLinkedHashSet() {
		// COMPLETE THIS
		map = new LinkedHashMap<>();
	}

	/**
	 * Create an empty set of default capacity
	 * 
	 */
	public MyLinkedHashSet(int initialCapacity) {
		// COMPLETE THIS
		super();
		this.map = new LinkedHashMap<>(initialCapacity);
	}

	@Override
	public Iterator<E> iterator() {
		// COMPLETE THIS
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
	public boolean add(E e) {
		// COMPLETE THIS
		if (!this.contains(e)) {
			map.put(e, null);
			return true;
		} else
			return false;

	}

	@Override
	public boolean remove(E o) {
		// COMPLETE THIS
		if (this.contains(o)) {
			map.remove(o);
			return true;
		} else
			return false;
	}

	@Override
	public void clear() {
		// COMPLETE THIS
		map = new LinkedHashMap<>();
	}

	@Override
	public int size() {
		return map.size();
	}

}
