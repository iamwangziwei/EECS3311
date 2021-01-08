package myUtil;

public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_CAPACITY = 10;
	
	int size;  // non-private for testing purpose
	E [] elementData; // non-private for testing purpose
	
	/**
	 * Create an empty list of capacity capa
	 * 
	 * @param capa the initial capacity. Assume greater than 0.
	 */
	@SuppressWarnings({"unchecked"})
    public MyArrayList(int capa) {
		this.elementData = (E[])new Object [capa];  // this is needed
		
		this.size = 0 ; // this can be ignored, as this.size will be 0 automatically
	}

	/**
	 * Create an empty list of default capacity
	 * 
	 */
    @SuppressWarnings({"unchecked"})
    public MyArrayList() {
		this.elementData = (E[])new Object [DEFAULT_CAPACITY];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size ==0;
	}

	 
	@Override
	public boolean contains(E o) {
		// TODO Auto-generated method stub
		for (int i=0; i< size; i++)
			if(o.equals(this.elementData[i]))
				return true;
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index<0 || index >= size)
			throw new IndexOutOfBoundsException();
		return this.elementData[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		if (index<0 || index >= size)
			throw new IndexOutOfBoundsException();
		E oldV = this.elementData[index];
		this.elementData[index] = element;
		return oldV;
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		int leng = this.elementData.length ;
		if (this.size == leng) { // full, need to expand by 10
		// 1) crate bigger array, 2) copy existing data 3) this.elementData reference the bigger array
			E[] temp = (E[])new Object [this.elementData.length+DEFAULT_CAPACITY];
			for(int i=0; i< leng; i++ )
				temp[i] = elementData[i];
		    this.elementData = temp;
		}
		this.elementData[size++] = e;
	}
		
	
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if (index<0 || index >= size)
			throw new IndexOutOfBoundsException();
		int leng = this.elementData.length;
		if (this.size == leng) {
			E[] temp = (E[]) new Object [this.elementData.length+DEFAULT_CAPACITY];
			// copy elements before index
			for(int i=0; i< index; i++ )
				temp[i] = elementData[i];
			
			// add new element at index
			temp[index] = element;
			
			// copy (shift) elements after index
			for (int i=index; i< leng; i++ )
				temp[i+1] = elementData[i];
		    
			this.elementData = temp;
	
		}
		else {
			// copy (shift) elements after index
			for(int i= size; i>index; i-- )
				elementData[i] = elementData[i-1];
			
			// add the new element at index
			this.elementData [index] = element;
		}
		size++;
	}
	
	
	@Override
	public void remove(E o) {
		// TODO Auto-generated method stub
		for(int i=0; i< size; i++ )
			if(elementData[i].equals(o)) {
				remove(i);
				return;
		}
	
	}
			

	@Override
	public E remove(int index) {
		if (index<0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		// TODO Auto-generated method stub
		E oldV = this.elementData[index];
		int i;
		// shift elements after index, to fill in the 'hole'
		for(i=index; i< size-1; i++ )
			elementData[i] = elementData[i+1];
		
		// i is size-1 now
		elementData[i] = null; // optional. clear to let Garbage Collector do its work 
		
		size--;
		return oldV;
	}

	@Override
	public int indexOf(E o) {
		// TODO Auto-generated method stub
		for(int i=0; i < size; i++)
			if(this.elementData[i].equals(o))
				return i;
		return -1;
	}

	@Override
	public int lastIndexOf(E o) {
		// TODO Auto-generated method stub
		for(int i=size-1; i >= 0; i--)
			if(this.elementData[i].equals(o))
				return i;
		return -1;
	}

	
	
/*	public String toString() {
		String s = "[";
		int i;
		for (i=0; i<size-1; i++)
			s += get(i) + ", ";
		s += get(i) +"]";
		
		return s;
	
	}*/



}
