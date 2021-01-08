package studentSystem;

public class GPA {
	//private String studentID;
	private int year;
	private double gpa;

	
	/**
	 * create GPA with year and gpa
	 * 	 
	 */
	public GPA(int year, double gpa) {
		super();
		//this.studentID = studentID;
		this.year = year;
		this.gpa = gpa;
	}


	/* 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
		return result;
	}*/


	
	/**
	 * two GPAs are equal if the year and gpa are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof GPA)) {
			return false;
		}
		GPA other = (GPA) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa)) {
			return false;
		}
		if (year != other.year) {
			return false;
		}
		return true;
	}







	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the gpa
	 */
	public double getGPA() {
		return gpa;
	}


	/**
	 * @param gpa the gpa to set
	 */
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	/*@Override
	public String toString() {
		return "GPA [year=" + year + ", gpa=" + gpa + "]";
	}*/
	
	
	
}
