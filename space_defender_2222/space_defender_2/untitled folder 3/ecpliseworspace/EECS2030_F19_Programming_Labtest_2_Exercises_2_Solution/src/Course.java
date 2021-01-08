public class Course {
	private String title;
	private double fee;
	
	Course(String title, double fee) {
		this.title = title;
		this.fee = fee;
	}
	
	String getTitle() {
		return this.title;
	}
	
	double getFee() {
		return this.fee;
	}
}
