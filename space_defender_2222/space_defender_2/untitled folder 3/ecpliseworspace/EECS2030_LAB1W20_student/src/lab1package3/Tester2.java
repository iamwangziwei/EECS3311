package lab1package3;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;




	public class Tester2 {

		
		@Test
	    public void test1() {
	        Attraction c = new Attraction("TonPrice", 10.0);
	        String name = c.getName();
	        double price = c.getPrice();
	        assertEquals("TonPrice", name);
	        //double var1=10.0;
	        assertEquals(10.0, price,0.00001);
	    }

	    @Test
	    public void test2() {
	    	Attraction c = new Attraction();
	        String name = c.getName();
	        double price = c.getPrice();
	        assertEquals(null, name);
	        assertEquals(0, price,0.0001);
	        c.setName("Tom");
	        c.setPrice(20.0);
	        name = c.getName();
	        price = c.getPrice();
	        assertEquals("Tom", name);
	        assertEquals(20.0, price,0.0001);
	    }

	    @Test
	    public void test3() {
	        TourismBook r = new TourismBook();
	        Attraction[] Attractions = r.getAttractions();
	        assertEquals(0, Attractions.length);
	    }

	    @Test
	    public void test4() {
	        TourismBook r = new TourismBook();
	        Attraction p1 = new Attraction("Alan", 30.0);
	        Attraction p2 = new Attraction("Jenny",40.0);
	        r.addAttraction(p1);
	        r.addAttraction(p2);
	        Attraction[] Attractions = r.getAttractions();
	        assertEquals(2, Attractions.length);
	        assertEquals(p1.getName(), Attractions[0].getName());
	        assertEquals(p1.getPrice(), Attractions[0].getPrice(),0.0001);
	        assertEquals(p2.getName(), Attractions[1].getName());
	        assertEquals(p2.getPrice(), Attractions[1].getPrice(),0.0001);
	    }

	    @Test
	    public void test5() {
	        TourismBook r = new TourismBook();
	        r.addAttraction("Joy", 50.0);
	        r.addAttraction("Peter", 60.0);
	        Attraction[] Attractions = r.getAttractions();
	        assertEquals(2, Attractions.length);
	        assertEquals("Joy", Attractions[0].getName());
	        assertEquals(50.0, Attractions[0].getPrice(),0.0001);
	        assertEquals("Peter", Attractions[1].getName());
	        assertEquals(60.0, Attractions[1].getPrice(),0.0001);
	    }

	    @Test
	    public void test6() {
	    	TourismBook r = new TourismBook();
	    	Attraction p1 = new Attraction("One", 30.0);
	    	Attraction p2 = new Attraction();
	        p2.setName("Two");
	        p2.setPrice(60.0);
	        r.addAttraction(p1);
	        r.addAttraction(p2);
	        r.addAttraction("Three", 40.0);
	        r.addAttraction("Four", 50.0);
	        Attraction[] Attractions = r.getAttractions();
	        assertEquals(4, Attractions.length);
	        assertEquals("One", Attractions[0].getName());
	        assertEquals(30.0, Attractions[0].getPrice(),0.0001);
	        assertEquals("Two", Attractions[1].getName());
	        assertEquals(60.0, Attractions[1].getPrice(),0.0001);
	        assertEquals("Three", Attractions[2].getName());
	        assertEquals(40.0, Attractions[2].getPrice(),0.0001);
	        assertEquals("Four", Attractions[3].getName());
	        assertEquals(50.0, Attractions[3].getPrice(),0.0001);
	        assertEquals("One", r.nameBestAttraction());
	    }

	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        TourismBook r = new TourismBook();
	        for (int i = 0; i < 3; i++) {
	            System.out.println("Enter customer name");
	            String name = sc.next();
	            System.out.println("Enter purchase price");
	            double price = sc.nextDouble();
	            r.addAttraction(name, price);
	        }
	        System.out.println("Name of best customer is " + r.nameBestAttraction());

	    }


	}
