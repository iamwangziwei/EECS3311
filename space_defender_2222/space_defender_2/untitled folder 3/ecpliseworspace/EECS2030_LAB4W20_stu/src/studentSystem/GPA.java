package studentSystem;

public class GPA {
	private double gpa;
	private int year;

	public GPA() {

	}

	public GPA(int year, double gpa) {
		// super();
		this.gpa = gpa;
		this.year = year;
	}

	public double getGPA() {
		return gpa;
	}

	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GPA other = (GPA) obj;
		if (gpa!=other.gpa)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
