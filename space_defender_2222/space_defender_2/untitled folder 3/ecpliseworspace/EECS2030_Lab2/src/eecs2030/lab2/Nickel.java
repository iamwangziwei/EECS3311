package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;

	public Nickel(int year) {
		if (year < 1858) {
			throw new IllegalArgumentException();
		}

		this.year = year;

	}

	public int issueYear() {
		return this.year;
	}

	public int hashCode() {
		return issueYear();
	}

	@Override
	public int compareTo(Nickel o) {
		return this.year - o.year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() == obj.getClass()) {
			return true;
		} else {
			return false;
		}
	}
}
