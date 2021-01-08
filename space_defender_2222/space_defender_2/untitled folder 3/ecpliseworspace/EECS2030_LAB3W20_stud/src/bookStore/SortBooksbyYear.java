package bookStore;

import java.util.Comparator;

public class SortBooksbyYear extends Object implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		return book1.getyearPublished()-book2.getyearPublished();
	}
}
