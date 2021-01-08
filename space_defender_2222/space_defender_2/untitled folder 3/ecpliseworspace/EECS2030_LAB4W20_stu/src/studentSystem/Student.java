package studentSystem;

import java.util.ArrayList;
//import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
	
	static int serial = 0;    // non-private for testing
	String name;   // non-private for testing
	int year;   // non-private for testing
	String yorkID;    // non-private for testing
	Date joinDate;     // non-private for testing
	Set<Course> courses;   // assume no duplicate courses so use a set  // non-private for testing
	List<GPA> GPAs;  // non-private for testing
	
	
	/**
	 * create a student with empty courses and GPAs
	 */
	public Student() {
//		Date jDate = new Date();
//		this.joinDate = new Date(jDate.getYear(), jDate.getMonth());
		++serial;
		if (serial<10) {
			this.yorkID = "York-0"+serial;
		}else {
			this.yorkID = "York-"+serial;
		}
		this.courses = new HashSet<Course>();
		this.GPAs = new ArrayList<GPA>();
	}
	
	public Student(String name, int year, Date joinDate, Set<Course> courses, List<GPA> gpas) {
		++serial;
		if (serial<10) {
			this.yorkID = "York-0"+serial;
		}else {
			this.yorkID = "York-"+serial;
		}
		this.name = name;
		this.year = year;
		this.joinDate = new Date(joinDate.getyear(), joinDate.getmonth());
		this.courses = new HashSet<Course>(courses);
		
		for (GPA g : gpas) {
			this.GPAs.add(new GPA(g.getYear(), g.getGPA()));
		}
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the id
	 */
	public String getYorkID() {
		return yorkID;
	}
	
	
	/**
	 * @param id the id to set
	 */
	public void setYorkID(String id) {
		this.yorkID = id;
	}
	
	
	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return new Date(this.joinDate.getyear(), this.joinDate.getmonth());
	}
	
	
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = new Date(joinDate.getyear(), joinDate.getmonth());
	}
	
	
	/**
	 * @return the course
	 */
	public Set<Course> getCourses() {
//		return new HashSet<Course>(this.courses);
		HashSet<Course> set = new HashSet<Course>();
		for (Course c : this.courses) {
			set.add(c);
		}
		return set;
	}
	
	
	/**
	 * @param courses the course to set
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = new HashSet<Course>(courses);
	}
	
	
	/**
	 * @return the gpas
	 */
	public List<GPA> getGPAs() { // need deep copy
		List<GPA> list = new ArrayList<GPA>();
		for (GPA gpa : this.GPAs) {
			list.add(new GPA(gpa.getYear(), gpa.getGPA()));
		}
		return list;
		
	}
	
	
	/**
	 * @param gpas the gpas to set
	 */
	public void setGPAs(List<GPA> gpas) {
		//this.GPAs = new ArrayList<GPA>(gpas);
		this.GPAs = new ArrayList<GPA>();
		for (GPA gpa : gpas) {
			this.GPAs.add(new GPA(gpa.getYear(), gpa.getGPA()));
		}
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
	
}
