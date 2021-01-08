package lab1package;

import java.util.Scanner;


	/*
	 * A test driver program for the Student class.
	 */
	public class tester {
	   public static void main(String[] args) {
	      // Test constructor and toString()
	      Student Jim = new Student("Jim", "1 Happy Ave");
	      System.out.println(Jim);  // toString()

	      // Test Setters and Getters
	      Jim.setAddress("8 maple, vaughan");
	      System.out.println(Jim);  // run toString() to inspect the modified instance
	      System.out.println(Jim.getName());
	      System.out.println(Jim.getAddress());

	      // Test addCourseGrade(), printGrades() and getAverageGrade()
	      Jim.addCourseGrade("IM101", 89);
	      Jim.addCourseGrade("IM102", 57);
	      Jim.addCourseGrade("IM103", 96);
	      Jim.printGrades();
	      System.out.printf("The average grade is %.2f%n", Jim.getAverageGrade());
	   }
	}
	


	
	
	
	
	
