package studentSystem;

public class Date {
	// class invariant: year is non-negative, and month is 1~12
	
	int year;
	int month;
	
	/**
	 * @param year year of the Date
	 * @param month month of the Date
	 * @throws IllegalArgumentException if year is negative, and month is less than 1 or greater than 12.
	 */
	public Date(int year, int month) {
		super();
		// maintain class invariant
		if (year <0 || month <1 || month > 12)
			throw new IllegalArgumentException();

		this.year = year;
		this.month = month;
	}

	
	/**
	 * @return the year
	 * 
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 * @throws IllegalArgumentException if year is negative
	 */
	public void setYear(int year) {
		// maintain class invariant
		if(year <0)
			throw new IllegalArgumentException();
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 * @throws IllegalArgumentException is month is not 1~12
	 */
	public void setMonth(int month) {
		if(month <=0  || month > 12)
			throw new IllegalArgumentException();
		this.month = month;
	}
	
	/*@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + "]";
	}*/


	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}*/


	
	/**
	 * two Dates are equal if the year and month are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Date)) {
			return false;
		}
		Date other = (Date) obj;
		if (month != other.month) {
			return false;
		}
		if (year != other.year) {
			return false;
		}
		return true;
	}
	
	

	
	

}

