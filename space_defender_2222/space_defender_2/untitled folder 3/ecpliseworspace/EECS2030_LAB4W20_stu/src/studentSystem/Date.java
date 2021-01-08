package studentSystem;

public class Date {

	private int year, month;

	public Date(Date date) {
		this.year = date.year;
		this.month = date.month;

	}

	public Date(int year, int month) {
		// TODO Auto-generated constructor stub
		if (year <= 0 || month > 12 || month < 1)
			throw new IllegalArgumentException();
		else {
			this.year = year;
			this.month = month;
		}
	}

	public void setMonth(int month) {
		// TODO Auto-generated method stub
		if (month > 12 || month < 1)
			throw new IllegalArgumentException();
		else {

			this.month = month;
		}
	}

	public void setYear(int year) {
		// TODO Auto-generated method stub
		if (year <= 0)
			throw new IllegalArgumentException();
		else {
			this.year = year;

		}
	}

	public int getyear() {
		return this.year;
	}

	public int getmonth() {
		return this.month;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + year;
		result = prime * result + month;
		return result;
		
	}	
	
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass() || obj == null)
			return false;
		if (this == obj)
			return true;
		Date d = (Date) obj;
		if (this.getyear() == d.getyear() && this.getmonth() == d.getmonth())
			return true;
		return true;
	}
}
