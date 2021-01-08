
public class Birthday {
	private int month;
	private int day;

	public Birthday(int month, int day) {
		// TODO Auto-generated constructor stub
		if ((month < 13) && (month > 0 && (day < 32) && day > 0)) {
			this.month = month;
			this.day = day;
		} else

			throw new IllegalArgumentException();
	}

	public Birthday() {
		// TODO Auto-generated constructor stub
		
	}

	public int getMonth() {
		// TODO Auto-generated method stub
		return month = this.month;
	}

	public int getDay() {
		// TODO Auto-generated method stub
		return day = this.day;
	}

	public String toString() {
		String[] monlist = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] daylist = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31 };
		return monlist[this.month - 1] + " " + daylist[this.day - 1];
	}

	public boolean equals(Birthday bd) {
		if ((this.day == bd.day) && (this.month == bd.month))
			return true;
		else
			return false;
	}

}
