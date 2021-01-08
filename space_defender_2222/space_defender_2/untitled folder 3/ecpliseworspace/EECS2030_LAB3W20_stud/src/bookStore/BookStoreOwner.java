package bookStore;

public class BookStoreOwner {
	private String name;
	private long id;

	public BookStoreOwner(String name) {
		this.name = name;
		id = name.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof BookStoreOwner) {
			BookStoreOwner other = (BookStoreOwner) obj;
			return name == other.name;
		} else {
			return false;
		}
	}

	public long getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int hashCode() {
		return (name + id).hashCode();
	}

	public String toString() {
		return name;
	}
}
