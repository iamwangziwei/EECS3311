package lab1package3;

import java.util.Scanner;

public class tester {

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double ticket =0;
		int numOfAttractions=0;
		
		TourismBook rest =new TourismBook();
		scanner = new Scanner(System.in);
		System.out.println("Enter 0 to stop reading input");
		System.out.println("Enter amount of ticket");
		ticket=scanner.nextDouble();
		
		while (ticket!=0)
		{
			System.out.println("Enter attraction name");	
			String customerName= scanner.next();
			numOfAttractions++;
			rest.addAttraction(customerName, ticket);
			System.out.println("Enter amount of ticket");
			ticket=scanner.nextDouble();
			
			
		}
		
		if(numOfAttractions>0)
		{
			System.out.println("Best Attraction");
			System.out.println(rest.nameBestAttraction());
			}
		
	}

}
