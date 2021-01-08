package studentSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestStudents {

	/*private Student createStudent() {
		
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Computability", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		
		GPA g1 = new GPA(1, 8.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		return s;
		
	}*/
	
	
    @Test (expected = IllegalArgumentException.class)
	public void testDate() {
		new Date (-2010, 1);
    }
    @Test (expected = IllegalArgumentException.class)
	public void testDate2() {
		Date d = new Date (2010, 15);
    }
	@Test (expected = IllegalArgumentException.class)
	public void testDate3() {
		Date d = new Date (2010, 1);
		d.setMonth(15);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDate4() {
		Date d = new Date (2010, 1);
		d.setYear(-1200);
    }
	
	
	@Test
	public void test0_serialYorkID() {
		Student.serial = 0; // manually reset for testing purposes
		Student s = new Student();
		assertEquals("York-01", s.getYorkID());
		
		Student s2 = new Student();
		assertEquals("York-02", s2.getYorkID());
		
		Student s3 = new Student();
		assertEquals("York-03", s3.getYorkID());
		
		Student s4 = new Student();
		assertEquals("York-04", s4.getYorkID());
		
		Student s5 = new Student();
		assertEquals("York-05", s5.getYorkID());
		
		Student s6 = new Student();
		assertEquals("York-06", s6.getYorkID());
		
		Student s7 = new Student();
		assertEquals("York-07", s7.getYorkID());
		
		Student s8 = new Student();
		assertEquals("York-08", s8.getYorkID());
		
		Student s9 = new Student();
		assertEquals("York-09", s9.getYorkID());
		
		Student s10 = new Student();
		assertEquals("York-10", s10.getYorkID());
		
		Student s11 = new Student();
		assertEquals("York-11", s11.getYorkID());
		
		 
	}
	@Test
	public void test1_contr0() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		//------------------------------------------------------------
		assertEquals("John", s.getName());
		assertEquals(3, s.getYear());
		assertEquals(new Date(2018,10), s.getJoinDate());
		Set<Course> coursesExp = new HashSet<>(Arrays.asList(new Course(2030,"Advanced OOP", "Wang"), new Course(2011,"Data Stucture", "Nguyen"),new Course(2001,"Theory of Computation", "Jeff")));
		assertEquals(coursesExp, s.getCourses());
		
		List<GPA> gpasExp = new ArrayList<>(Arrays.asList(new GPA(1, 6.2), new GPA(2, 3.6)) );
		assertEquals(gpasExp, s.getGPAs());
		
	}
	@Test
	public void test1_contrDate() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		//------------------------------------------------------------
		assertNotSame( d, s.joinDate); // should be different reference
		d.setYear(2020);   // s.joinDate should not change, still 2018,10
		assertEquals(new Date(2018,10), s.joinDate);
	}
	
	@Test
	public void test2_contrCourses() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		
		//---------------------------------------------------------------------------
		assertNotSame(courses, s.courses); // should be different set reference
		
		// but course reference in the set should be shared.
		for(Course c: courses) { // hashset guarantee no order, so use loops to find corresponding elements based on code
			int code = c.getCode();
			for(Course cs: s.courses)
				if (cs.getCode() == code)
					assertSame(cs,c);  // should be same reference
		}
		
		courses.clear();   // s.getCourses should not change
		Set<Course> coursesExp = new HashSet<>(Arrays.asList(new Course(2030,"Advanced OOP", "Wang"), new Course(2011,"Data Stucture", "Nguyen"),new Course(2001,"Theory of Computation", "Jeff")));
		assertEquals(coursesExp, s.courses);
		
		//
		
		course2.setInstructor("Andy");  // 2011 in Student.courses should be impacted
		Set<Course> coursesExp2 = new HashSet<>(Arrays.asList(new Course(2030,"Advanced OOP", "Wang"), new Course(2011,"Data Stucture", "Andy"),new Course(2001,"Theory of Computation", "Jeff")));
		assertEquals(coursesExp2, s.courses);
	}
	
	@Test
	public void test3_contrGPAs() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		//---------------------------------------------------------
		assertNotSame(gpas, s.GPAs); // should be different reference
		
		for(int i=0; i<gpas.size(); i++) { // also content should be different references
			assertNotSame(gpas.get(i), s.GPAs.get(i));
		}
		
		
		gpas.clear();   // s.getCourses should not change
		List<GPA> gpasExp = new ArrayList<>(Arrays.asList(new GPA(1, 6.2), new GPA(2, 3.6)) );
		assertEquals(gpasExp, s.getGPAs());
		
		g1.setGPA(0);  // should not affect student.gpas
		assertEquals(gpasExp, s.getGPAs());
	
		
	}
	
	// test the 3 accessors
	@Test
	public void test4_getterDate() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		//---------------------------------------------------
		Date dG = s.getJoinDate(); 
		assertNotSame(dG, s.joinDate); // should be of different references
		
		dG.setYear(2030);    // s.getJoinDate should not change
		assertEquals(new Date(2018,10), s.getJoinDate());
		
				
	}
	
	@Test
	public void test5_getterCourses() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		//---------------------------------------------------
		
		Set<Course> sGet = s.getCourses();   
		assertNotSame(sGet, s.courses); // should be different references
		
		// but course reference in the set should be shared.
		for(Course c: sGet) { // hashset guarantee no order, so use loops to find corresponding elements
			int code = c.getCode();
			for(Course cs: s.courses)
				if (cs.getCode() == code)
					assertSame(cs,c);  // should be same reference
		}
		
		sGet.clear();  // should not change 
		Set<Course> coursesExp = new HashSet<>(Arrays.asList(new Course(2030,"Advanced OOP", "Wang"), new Course(2011,"Data Stucture", "Nguyen"),new Course(2001,"Theory of Computation", "Jeff")));
		assertEquals(coursesExp, s.courses);
		
		Set<Course> sGet2 = s.getCourses();   
		for(Course c: sGet2 )
			if (c.getCode() == 2011)
				c.setInstructor("Andy");
		
		Set<Course> coursesExp2 = new HashSet<>(Arrays.asList(new Course(2030,"Advanced OOP", "Wang"), new Course(2011,"Data Stucture", "Andy"),new Course(2001,"Theory of Computation", "Jeff")));
		assertEquals(coursesExp2, s.courses);
					
	}
	
	@Test
	public void test_getterGPAs() {
		String name = "John";
		int year = 3;
		Date d = new Date(2018,10);
		Course course1 = new Course(2030,"Advanced OOP", "Wang");
		Course course2 = new Course(2011,"Data Stucture", "Nguyen");
		Course course3 = new Course(2001,"Theory of Computation", "Jeff");
		Set<Course> courses = new HashSet<>();
		courses.add(course1); courses.add(course2); courses.add(course3);
		
		GPA g1 = new GPA(1, 6.2);
		GPA g2 = new GPA(2, 3.6);
		List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
		
		Student s = new Student(name, year, d, courses, gpas);
		//-----------------------------------------------------------
		
		List<GPA> gGet = s.getGPAs(); 
		assertNotSame(gGet, s.GPAs); // should be of different list references
		
		for(int i=0; i<gGet.size(); i++) { // also content should be different references
			assertNotSame(gGet.get(i), s.GPAs.get(i));
		}
		
		gGet.clear(); // should not change s.gpas
		
		List<GPA> gpasExp = new ArrayList<>(Arrays.asList(new GPA(1, 6.2), new GPA(2, 3.6)) );
		assertEquals(gpasExp, s.GPAs);
		
		List<GPA> gGet2 = s.getGPAs();   
		for(GPA c: gGet2) 
	    	if (c.getGPA() < 5) 
	    		c.setGPA(8); 
	   
		assertEquals(gpasExp, s.GPAs);
		
						
	}
	
	
	// test mutators
		@Test
		public void test7_setterDate() {
			String name = "John";
			int year = 3;
			Date d = new Date(2018,10);
			Course course1 = new Course(2030,"Advanced OOP", "Wang");
			Course course2 = new Course(2011,"Data Stucture", "Nguyen");
			Course course3 = new Course(2001,"Theory of Computation", "Jeff");
			Set<Course> courses = new HashSet<>();
			courses.add(course1); courses.add(course2); courses.add(course3);
			
			GPA g1 = new GPA(1, 6.2);
			GPA g2 = new GPA(2, 3.6);
			List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
			
			Student s = new Student(name, year, d, courses, gpas);
			//---------------------
			
			Date d2 = new Date(2020,10);
		    s.setJoinDate(d2);  
		    assertEquals(new Date(2020,10), s.joinDate);  // should be set 
		    assertNotSame(d2, s.joinDate); // but reference should be different
		    
		    
		    d2.setMonth(12); 
		    assertEquals(new Date(2020,10), s.getJoinDate());  // should not be changed
		    
		}
		
		@Test
		public void test5_setterCourses() {
			String name = "John";
			int year = 3;
			Date d = new Date(2018,10);
			Course course1 = new Course(2030,"Advanced OOP", "Wang");
			Course course2 = new Course(2011,"Data Stucture", "Nguyen");
			Course course3 = new Course(2001,"Theory of Computation", "Jeff");
			Set<Course> courses = new HashSet<>();
			courses.add(course1); courses.add(course2); courses.add(course3);
			
			GPA g1 = new GPA(1, 6.2);
			GPA g2 = new GPA(2, 3.6);
			List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
			
			Student s = new Student(name, year, d, courses, gpas);
			//-----------------------------------------------------------------
			
			Set<Course> courses2 = new HashSet<>(Arrays.asList(new Course(1000,"A","X"), new Course(1001,"B","Y")));
		    s.setCourses(courses2);
		    
		    Set<Course> coursesExp = new HashSet<>(Arrays.asList(new Course(1000,"A","X"), new Course(1001,"B","Y")));
		    assertEquals(coursesExp, s.courses); // set accordingly, 
		    assertNotSame(course2, s.courses); // but not same reference
		    // but course reference in the set should be shared.
			for(Course c: courses2) { // hashset guarantee no order, so use loops to find corresponding elements
				int code = c.getCode();
				for(Course cs: s.courses)
					if (cs.getCode() == code)
						assertSame(cs,c);  // should be same reference
			}
		    
		    courses2.clear(); 
		    assertEquals(coursesExp, s.courses); // this should not change
		    
		}
		
		@Test
		public void test_setterGPAs() {
			String name = "John";
			int year = 3;
			Date d = new Date(2018,10);
			Course course1 = new Course(2030,"Advanced OOP", "Wang");
			Course course2 = new Course(2011,"Data Stucture", "Nguyen");
			Course course3 = new Course(2001,"Theory of Computation", "Jeff");
			Set<Course> courses = new HashSet<>();
			courses.add(course1); courses.add(course2); courses.add(course3);
			
			GPA g1 = new GPA(1, 6.2);
			GPA g2 = new GPA(2, 3.6);
			List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
			
			Student s = new Student(name, year, d, courses, gpas);
			//-----------------------------------------------------------
			
			List<GPA> gpas2 = new ArrayList<>(Arrays.asList(new GPA(1,8.0), new GPA(2,8.0), new GPA(3,7.8)) );
		    s.setGPAs(gpas2); // this changes, mutator
		    
		    List<GPA> gpasExp = new ArrayList<>(Arrays.asList(new GPA(1,8.0), new GPA(2,8.0), new GPA(3,7.8)));
		    assertEquals(gpasExp, s.getGPAs());
		    assertNotSame(gpas2, s.GPAs); // should be of different list references
			// also content should be different references
		    for(int i=0; i<gpas2.size(); i++) { 
				assertNotSame(gpas2.get(i), s.GPAs.get(i));
			}
			
		    gpas2.clear(); 
		    assertEquals(gpasExp, s.GPAs); // this should not change
					
		}
		
		//finally show primitive and immutable object cannot be modified, should always pass this test?!
		@Test
		public void test_primitveImmutable() {
			String name = "John";
			int year = 3;
			Date d = new Date(2018,10);
			Course course1 = new Course(2030,"Advanced OOP", "Wang");
			Course course2 = new Course(2011,"Data Stucture", "Nguyen");
			Course course3 = new Course(2001,"Theory of Computation", "Jeff");
			Set<Course> courses = new HashSet<>();
			courses.add(course1); courses.add(course2); courses.add(course3);
			
			GPA g1 = new GPA(1, 6.2);
			GPA g2 = new GPA(2, 3.6);
			List<GPA> gpas = new ArrayList<>();   gpas.add(g1);  gpas.add(g2);
			
			Student s = new Student(name, year, d, courses, gpas);
			//------------------------------------------------------------------
			name = "Sue";
			assertEquals("John", s.name);
			
			year++;
			assertEquals(3, s.year);
			
			// accessors
			String nGet = s.getName();
			nGet = "Sue";
			assertEquals("John", s.name);
			
			int yGet = s.getYear();
			yGet--;
			assertEquals(3, s.year);
			
			//mutators
			String nameSet = "George";
			s.setName(nameSet);
			nameSet = "XXX";
			assertEquals("George", s.name);
			
			int yearSet = 5;
			s.setYear(yearSet);
			yearSet += 100;
			assertEquals(5, s.year);
		}
			
		
	
	
	
	
	
	
	
	
}
