package studentSystem;

import java.util.ArrayList;
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
		//leave the default value for name, year and joinDate
		//this.name= null; 
		//this.year =0;  
		//this.joinDate = null
		
		
		this.courses=new HashSet<>();
		this.GPAs = new ArrayList<>();
		
		this.yorkID = String.format("York-%02d", ++serial);
	}
	
	
	
	public Student(String name, int year, Date joinDate, Set<Course> courses, List<GPA> gpas) {
		super();
		this.name = name;
		this.year = year;
		
		// aliasing not working
		/*this.joinDate = joinDate;
		/*this.courses = course;
		this.GPAs = gpas;*/
		
		this.joinDate = new Date(joinDate.getYear(), joinDate.getMonth());
		
		this.courses = new HashSet<>();
		for(Course c: courses)
			this.courses.add(c);
		
		this.GPAs = new ArrayList<>();
		for(GPA g: gpas)
			this.GPAs.add(new GPA(g.getYear() , g.getGPA()));
		
		
		this.yorkID = String.format("York-%02d", ++serial);
	}


	/**
	 * @return the name
	 */
	public String getName() {   // String is immutable, safe to share
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
	public String getYorkID() { // String is immutable, safe to share
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
	public Date getJoinDate() {  // return a defensive copy
		return new Date(this.joinDate.year, this.joinDate.month);
	}
	
	
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {  // create defensive copy
		this.joinDate = new Date(joinDate.getYear(), joinDate.getMonth());
	}
	
	
	/**
	 * @return the course
	 */
	public Set<Course> getCourses() {
		Set<Course> copy = new HashSet<>(); //defensive copy
		for(Course c: this.courses)
			copy.add(c);   // shallow copy
		return copy;
	}
	
	
	/**
	 * @param courses the course to set
	 */
	public void setCourses(Set<Course> courses) {  // defensive copy
		Set<Course> copy = new HashSet<>();
		for(Course c: courses)
			copy.add(c);   // shallow copy
	
		this.courses = copy;
	}
	
	
	/**
	 * @return the gpas
	 */
	public List<GPA> getGPAs() {    // need deep copy
		List<GPA> copy = new ArrayList<>();
		for(GPA g: this.GPAs)
			copy.add(new GPA(g.getYear(), g.getGPA()));
		return copy;
	}
	
	
	/**
	 * @param gpas the gpas to set
	 */
	public void setGPAs(List<GPA> gpas) {
		List<GPA> copy = new ArrayList<>();
		for(GPA g: gpas)
			copy.add(new GPA(g.getYear(), g.getGPA()));
		this.GPAs = copy;
	}


	/**
	 * @return the year
	 */
	public int getYear() {   // primitive, safe to return
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
}
