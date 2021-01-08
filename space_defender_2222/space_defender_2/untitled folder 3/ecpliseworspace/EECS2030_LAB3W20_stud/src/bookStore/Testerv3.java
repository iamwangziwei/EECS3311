package bookStore;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;


import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Testerv3 {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	

	@Test
	public void test01_staticFields() {
		try {
			List<Field> fields = Arrays.asList(BookStore.class.getDeclaredFields());

			int nStatic = 0;
			for (Field f : fields) {
				int mod = f.getModifiers();
				if (Modifier.isStatic(mod)) {
					nStatic++;
				}
			}
			assertTrue("there should be no static fields", nStatic == 0);
		} catch (Exception x) {
			fail("exception occurred trying to get the fields of this class");
		}
	}
	

	
	@Test
	public void test02a_ctor() {
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		assertEquals("ctor set the wrong BookStoreOwner",
				w, b.getOwner());
	}
	

	
	@Test
	public void test03a_copyCtor() {
		BookStoreOwner w = new BookStoreOwner("OwnerC");
		BookStore b = new BookStore(w);
		BookStore c = new BookStore(b);
		assertEquals("copy ctor set the wrong owner",
				w, c.getOwner());
	}
	


	//changeOwner
	@Test(expected = IllegalArgumentException.class)
	public void test04a_changeOwner() {
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		BookStoreOwner x = new BookStoreOwner("OwnerB");
		b.changeOwner(x, x);
	}
	
	@Test
	public void test04b_changeOwner() {
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		BookStoreOwner x = new BookStoreOwner("OwnerB");
		b.changeOwner(w, x);
		assertEquals("changeOwner failed to set the correct owner",
				x, b.getOwner());
	}
	
	
//contains
	@Test
	public void test06a_contains() {
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		Book b1= new Book("ABC",2018, 36);
		assertFalse("contains returned true for an empty Bookstore!",
				b.contains(b1));
		
	}
	
	
	@Test
	public void test06b_contains() {
		List<Book> books = new ArrayList<Book>();
		Book b1= new Book("Java 1",2010, 160);
		books.add(b1);
		Book b2= new Book("Signals and Systems",2011, 260);
		books.add(b2);
		Book b3= new Book("Optical Communication",2011, 30);
		books.add(b3);
		Book b4= new Book("5G",2010, 10);
		books.add(b4);
		
		
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		b.add(books);
		
		assertTrue("contains returned false for a BookStore with every book",
				b.contains(b1));
		assertTrue("contains returned false for a BookStore with every book",
				b.contains(b2));
		assertTrue("contains returned false for a BookStore with every book",
				b.contains(b3));
		assertTrue("contains returned false for a BookStore with every book",
				b.contains(b4));
		
	}
	
	
	@Test
	public void test06c_contains() {
		List<Book> books = new ArrayList<Book>();
		Book b1= new Book("Java 1",2010, 160);
		books.add(b1);
		Book b2= new Book("Signals and Systems",2011, 260);
		books.add(b1);
		Book b3= new Book("Optical Communication",2011, 30);
		books.add(b1);
		Book b4= new Book("5G",2010, 10);
		books.add(b1);

		
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		b.add(books);
		
		
		assertTrue("contains returned true for a BookStore with only b1",
				b.contains(b1));
		assertFalse("contains returned false for a BookStore with only b1",
				b.contains(b2));
		assertFalse("contains returned false for a BookStore with only b1",
				b.contains(b3));
		assertFalse("contains returned false for BookStore with only b1",
				b.contains(b4));
		
	}
	
	
	//sellingsinglebook
	@Test
	public void test07a_sellingsingleBook() {
		List<Book> books = new ArrayList<Book>();
		
		Book b1= new Book("Java 1",2010, 160);
		books.add(b1);
		Book b2= new Book("Signals and Systems",2011, 260);
		books.add(b2);
		Book b3= new Book("Optical Communication",2011, 30);
		books.add(b3);
		Book b4= new Book("5G",2010, 10);
		books.add(b4);
		
	
	
		
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		b.add(books);
		
		Book got = b.sellingsingleBook(w, b1);
		assertEquals("selling returned the wrong Book", b1, got);
				
		got = b.sellingsingleBook(w, b2);
		assertEquals("selling returned the wrong Book", b2, got);
		
		got = b.sellingsingleBook(w, b3);
		assertEquals("selling returned the wrong Book", b3, got);
		
		got = b.sellingsingleBook(w, b4);
		assertEquals("selling returned the wrong Book", b4, got);
		
				
	}
	
	@Test
	public void test07b_sellingsingleBook() {
		List<Book> books = new ArrayList<Book>();
		Book b1= new Book("Java 1",2010, 160);
		books.add(b1);
		Book b2= new Book("Signals and Systems",2011, 260);
		books.add(b2);
		Book b3= new Book("Optical Communication",2011,30);
		books.add(b3);
		Book b4= new Book("5G",2010, 10);
		books.add(b4);
		
		
		
		BookStoreOwner w = new BookStoreOwner("OwnerA");
		BookStore b = new BookStore(w);
		b.add(books);
				
		Book got = b.sellingsingleBook(new BookStoreOwner("OwnerB"),b1);
		assertNull("remove allowed a non-owner to remove a book", got);
	}
	
	@Test
	public void test_comparator() {
		List<Book> books = new ArrayList<Book>();
		Book b1= new Book("Java 1",2010, 160);
		books.add(b1);
		Book b2= new Book("Signals and Systems",2011, 260);
		books.add(b2);
		Book b3= new Book("Optical Communication",2018, 30);
		books.add(b3);
		Book b4= new Book("5G",2000, 10);
		books.add(b4);
		
		Collections.sort(books, new SortBooksbyYear());

		List<Book> exp = new ArrayList<>(Arrays.asList(new Book("5G",2000, 10), new Book("Java 1",2010, 160), new Book("Signals and Systems",2011, 260), new Book("Optical Communication",2018, 30)));
		assertEquals("comparator fails", exp, books);
	}
	
	
	
}
