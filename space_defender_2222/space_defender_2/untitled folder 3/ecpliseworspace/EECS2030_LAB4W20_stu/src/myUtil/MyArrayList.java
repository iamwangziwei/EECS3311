package myUtil;

public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_CAPACITY = 10;

	int size; // non-private for testing purpose
	E[] elementData; // non-private for testing purpose

	/**
	 * Create an empty list of capacity capa
	 * 
	 * @param capa the initial capacity. Assume greater than 0.
	 */
	@SuppressWarnings({ "unchecked" })
	public MyArrayList(int capa) {
		this.elementData = (E[]) new Object[capa];
	}

	/**
	 * Create an empty list of default capacity
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	public MyArrayList() {
		this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public int size() {
		int count = 0;
		for (E e : elementData) {
			if (e != null)
				count++;
		}
		return count;
	}

	public boolean isEmpty() {
		if (this.size() == 0)
			return true;
		else
			return false;
	}

	public E get(int index) {
		if (index >= size())
			throw new IndexOutOfBoundsException();
		else {
			return elementData[index];
		}
	}

	public boolean contains(E o) {
		boolean flag = false;
		for (E e : elementData) {
			if (e == o)
				flag = true;

		}
		return flag;
	}

	public int indexOf(E o) {
		int i = 0;
		boolean flag = false;
		for (E e : elementData) {
			if (e == o) {
				flag = true;
				break;
			} else
				i++;
		}
		if (flag == true)
			return i;
		else
			return -1;
	}

	public int lastIndexOf(E o) {
		int i = 0;
		int j = -1;

		boolean flag = false;
		for (E e : elementData) {
			if (e == o) {
				if (i >= j)
					flag = true;
				j = i;
			}

			i++;

		}
		if (flag == true)
			return j;
		else
			return -1;
	}

	public E set(int index, E element) {
		if (index >= size())
			throw new IndexOutOfBoundsException();
		else {
			E old = elementData[index];
			elementData[index] = element;
			return old;
		}
	}

	@SuppressWarnings("unchecked")
	public void add(E o) {

		if (size() >= elementData.length) {

			E[] newe = (E[]) new Object[elementData.length];
			int k = 0, j = 0;
			for (E ee : elementData) {
				newe[k] = ee;
				k++;
			}
			this.elementData = (E[]) new Object[elementData.length + DEFAULT_CAPACITY];
			for (E ee : newe) {
				elementData[j] = ee;
				j++;
			}
		}
		elementData[size()] = o;
	}

	public void add(int index, E element) {
		if (index >= size())
			throw new IndexOutOfBoundsException();
		else {
			for (int i = size(); i > index; i--) {
				elementData[i] = elementData[i - 1];
			}
			elementData[index] = element;
		}
	}

	public void remove(E o) {
		int i = indexOf(o);
		if (i != -1) {
			for (int k = i; k < size() - 1; k++)
				elementData[k] = elementData[k + 1];
			elementData[size() - 1] = null;
		} else
			return;
	}

	public E remove(int index) {
		E e = elementData[index];
		if (index >= size())
			throw new IndexOutOfBoundsException();
		else {
			for (int i = index; i < size() - 1; i++) {
				elementData[i] = elementData[i + 1];

			}
			elementData[size() - 1] = null;
		}
		return e;
	}

}
