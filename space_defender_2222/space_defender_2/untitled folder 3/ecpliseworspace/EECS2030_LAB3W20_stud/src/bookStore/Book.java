package bookStore;

public class Book extends Object implements Comparable<Book> {

	private String title;
	private int yearPublished;
	private double price;

	public Book() {
		this.title = "";
		this.yearPublished = 0;
		this.price = 0;
	}

	public Book(Book other) {
		this.title = other.title;
		this.yearPublished = other.yearPublished;
		this.price = other.price;
	}

	public Book(String title, int yearPublished, double price) {
		this.title = title;
		this.yearPublished = yearPublished;
		this.price = price;
	}

	public int compareTo(Book other) {
		if (this.price == other.price) {
			return 0;
		} else {
			return (int) (this.price - other.price);
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book other = (Book) obj;
			return title.equals(other.title) && yearPublished == other.yearPublished && price == other.price;
		} else {
			return false;
		}
	}

	public double getPrice() {
		return this.price;
	}

	public String gettitle() {
		return this.title;
	}

	public int getyearPublished() {
		return this.yearPublished;
	}

	public int hashcode() {
		return (title + yearPublished + "" + price).hashCode();
	}

	@Override
	public String toString() {
		return (title + "\nPublished in: " + yearPublished + "/nPrice: " + price);
	}
}
