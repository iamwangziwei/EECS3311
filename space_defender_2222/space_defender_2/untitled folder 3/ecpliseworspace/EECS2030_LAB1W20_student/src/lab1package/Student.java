package lab1package;

public class Student {

	private char[] name;
	private String address;
	private String[] course;
	private int[] grade;
	private int number;
	public Student(String name, String address) {
		// TODO Auto-generated constructor stub
		for(int i = 0;i<name.length();i++) {
			this.name[i] = name.charAt(i);
		}
		
		
		this.address = address;
	}
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
		this.address = address;
	}
	public char[] getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public void addCourseGrade(String course, int grade) {
		// TODO Auto-generated method stub
		this.course[number] = course;
		this.grade[number] = grade;
		number++;
	}
	public void printGrades() {
		// TODO Auto-generated method stub
		return this.getName() +" " +;
	}
	public Object getAverageGrade() {
		// TODO Auto-generated method stub
		return 111;
	}
	public char[] getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}

}
