package fms;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Tester {


FlightManagementSystem db;
	
	/*
	 * This method is executed before each test method is executed.
	 */
	@Before
    public void setUp() {
		db = new FlightManagementSystem();
    }
	
	private void addPassengers() {
		try {
			db.addPassenger("e1", new PassengerInfo("Heeyeon"	, 10, 2000));
			db.addPassenger("e2", new PassengerInfo("Jiyoon"	, 50, 2577)); 
			db.addPassenger("e3", new PassengerInfo("Jaebin"	, 70, 2000));
			db.addPassenger("e4", new PassengerInfo("Suyeon"	, 70, 2577));
			db.addPassenger("e5", new PassengerInfo("Yuna"	    , 50, 990));
			db.addPassenger("e6", new PassengerInfo("Sunhye"	, 30, 2577));
			db.addPassenger("e7", new PassengerInfo("Jihye"	    , 70, 990));
		} catch (IdAlreadyExistsExceptoin e) {
			// exception not expected
			fail();
		}
	}
	
	private void addFlights() {
		try {
			db.addFlight(2000, new FlightInfo("LondonToronto"	, "AirCanada"));
			db.addFlight(2577, new FlightInfo("ParisLondon"			, "AirFrance"));
			db.addFlight(990, new FlightInfo("ParisToronto"	, "UnitedAirlines"));
		} catch (IdAlreadyExistsExceptoin e) {
			// exception not expected
			fail();
		} 
	}
	
	@Test
	public void test0() { 
		try {
			db.addPassenger("e10", new PassengerInfo("zzzz"	    , 71, 991));
			db.addFlight(2001, new FlightInfo("LondonParis"	, "AirCanada"));
		}catch (IdAlreadyExistsExceptoin e) {
			// exception not expected
			fail();
		}
		try {
			db.removePassenger("e10");
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		}
		
		try {
			db.removeFlight(2001);
			
		} catch (IdNotFoundException e) {
			// exception expected
		} 
	}

	
	
	
	@Test
	public void test_Constructor() { 
		assertEquals(db.passengers.size(), 0);
		assertEquals(db.flights.size(), 0);
	}
	
	@Test
	public void test_addPassenger_abnormal() {
		addPassengers();
		
		try {
			db.addPassenger("e3", new PassengerInfo("Jiwon", 400, 2000));
			fail();
		} catch (IdAlreadyExistsExceptoin e) {
			// exception expected
		}
	}

	@Test
	public void test_addPassenger_normal() {
		try {
			db.addPassenger("e1", new PassengerInfo("Heeyeon"	, 10, 2000));
			db.addPassenger("e2", new PassengerInfo("Jiyoon"	, 50, 2577)); 
			db.addPassenger("e3", new PassengerInfo("Jaebin"	, 70, 2000));
			db.addPassenger("e4", new PassengerInfo("Suyeon"	, 70, 2577));
			db.addPassenger("e5", new PassengerInfo("Yuna"	    , 50, 990));
			db.addPassenger("e6", new PassengerInfo("Sunhye"	, 60, 2577));
			db.addPassenger("e7", new PassengerInfo("Jihye"	    , 70, 990));
			
			
		} catch (IdAlreadyExistsExceptoin e) {
			// exception not expected
			fail();
		} 
		
		
		assertEquals(7, db.passengers.size());
		assertEquals(new PassengerInfo("Heeyeon"	, 10, 2000), db.passengers.get("e1"));
		assertEquals(new PassengerInfo("Jiyoon"	, 50, 2577), db.passengers.get("e2"));
		assertEquals(new PassengerInfo("Jaebin"	, 70, 2000), db.passengers.get("e3"));
		assertEquals(new PassengerInfo("Suyeon"	, 70, 2577), db.passengers.get("e4"));
		assertEquals(new PassengerInfo("Yuna"	, 50, 990), db.passengers.get("e5"));
		assertEquals(new PassengerInfo("Sunhye"	, 60, 2577), db.passengers.get("e6"));
		assertEquals(new PassengerInfo("Jihye"	, 70, 990), db.passengers.get("e7"));
	}
	
	@Test
	public void test_removePassenger_abnormal() {
		addPassengers();
		
		try {
			db.removePassenger("e8");
			fail();
		} catch (IdNotFoundException e) {
			// exception expected 
		}
	}
	
	@Test
	public void test_removePassenger_normal() {
		addPassengers();
		
		try {
			db.removePassenger("e3");
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		}
		
		assertEquals(6, db.passengers.size());
		assertEquals(new PassengerInfo("Heeyeon"	, 10, 2000), db.passengers.get("e1"));
		assertEquals(new PassengerInfo("Jiyoon"	, 50, 2577), db.passengers.get("e2"));
		assertTrue(db.passengers.get("e3") == null);
		assertEquals(new PassengerInfo("Suyeon"	, 70, 2577), db.passengers.get("e4"));
		assertEquals(new PassengerInfo("Yuna"	, 50, 990), db.passengers.get("e5"));
		assertEquals(new PassengerInfo("Sunhye"	, 30, 2577), db.passengers.get("e6"));
		assertEquals(new PassengerInfo("Jihye"	, 70, 990), db.passengers.get("e7"));
		
		try {
			db.removePassenger("e6");
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		}
		
		assertEquals(5, db.passengers.size());
		assertEquals(new PassengerInfo("Heeyeon"	, 10, 2000), db.passengers.get("e1"));
		assertEquals(new PassengerInfo("Jiyoon"	, 50, 2577), db.passengers.get("e2"));
		assertTrue(db.passengers.get("e3") == null);
		assertEquals(new PassengerInfo("Suyeon"	, 70, 2577), db.passengers.get("e4"));
		assertEquals(new PassengerInfo("Yuna"	, 50, 990), db.passengers.get("e5"));
		assertTrue(db.passengers.get("e6") == null);
		assertEquals(new PassengerInfo("Jihye"	, 70, 990), db.passengers.get("e7"));
	}
	
	@Test
	public void test_addFlight_abnormal() {
		addFlights();
		
		try {
			db.addFlight(2577, new FlightInfo("PUBLIC RELATION", "Vancouver"));
			fail();
		} catch (IdAlreadyExistsExceptoin e) {
			// exception expected
		} 
	}
	
	@Test
	public void test_addFlight_normal() {
		try {
			db.addFlight(2000, new FlightInfo("LondonToronto"	, "AirCanada"));
			db.addFlight(2577, new FlightInfo("ParisLondon"			, "AirFrance"));
			db.addFlight(990, new FlightInfo("ParisToronto"	, "UnitedAirlines"));
		} catch (IdAlreadyExistsExceptoin e) {
			// exception not expected
			fail();
		} 
		
		assertEquals(3, db.flights.size());
		assertEquals(new FlightInfo("LondonToronto", "AirCanada"), db.flights.get(2000));
		assertEquals(new FlightInfo("ParisLondon"		, "AirFrance")	, db.flights.get(2577));
		assertEquals(new FlightInfo("ParisToronto"	, "UnitedAirlines")	, db.flights.get(990));
	}
	
	@Test
	public void test_removeFlight_abnormal() {
		addFlights();
		
		try {
			db.removeFlight(4);
			fail();
		} catch (IdNotFoundException e) {
			// exception expected
		} 
	}
	
	@Test
	public void test_removeFlight_normal() {
		addFlights();
		
		try {
			db.removeFlight(2577);
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		} 
		assertEquals(2, db.flights.size());
		assertEquals(new FlightInfo("LondonToronto", "AirCanada"), db.flights.get(2000));
		assertTrue(db.flights.get(2) == null);
		assertEquals(new FlightInfo("ParisToronto"	, "UnitedAirlines")	, db.flights.get(990));
		
		try {
			db.removeFlight(990);
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		} 
		assertEquals(1, db.flights.size());
		assertEquals(new FlightInfo("LondonToronto", "AirCanada"), db.flights.get(2000));
		assertTrue(db.flights.get(2577) == null);
		assertTrue(db.flights.get(990) == null);
	}
	
	@Test
	public void test_changeFlight_abnormal() {
		addFlights();
		addPassengers();
		
		try {
			// invalid student id
			db.changeFlight("e8", 3);
			fail();
		} catch (IdNotFoundException e) {
			// exception expected
		}
		
		try {
			// invalid course id
			db.changeFlight("e2", 4);
			fail();
		} catch (IdNotFoundException e) {
			// exception expected
		}
	}
	
	@Test
	public void test_changeFlight_normal() {
		addFlights();
		addPassengers();
		
		try {
			db.changeFlight("e2", 990);
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		}
		
		assertEquals(7, db.passengers.size());
		/* changed student */
		assertEquals(new PassengerInfo("Jiyoon"	, 50, 990), db.passengers.get("e2"));
		/* other passengers remain unchanged */
		assertEquals(new PassengerInfo("Heeyeon"	, 10, 2000), db.passengers.get("e1"));
		assertEquals(new PassengerInfo("Jaebin"	, 70, 2000), db.passengers.get("e3"));
		assertEquals(new PassengerInfo("Suyeon"	, 70, 2577), db.passengers.get("e4"));
		assertEquals(new PassengerInfo("Yuna"	, 50, 990), db.passengers.get("e5"));
		assertEquals(new PassengerInfo("Sunhye"	, 30, 2577), db.passengers.get("e6"));
		assertEquals(new PassengerInfo("Jihye"	, 70, 990), db.passengers.get("e7"));
		
		
		
		try {
			db.changeFlight("e7", 2000);
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		}
		
		assertEquals(7, db.passengers.size());
		/* changed student */
		assertEquals(new PassengerInfo("Jihye"	, 70, 2000), db.passengers.get("e7"));
		/* other passengers remain unchanged */
		assertEquals(new PassengerInfo("Heeyeon"	, 10, 2000), db.passengers.get("e1"));
		assertEquals(new PassengerInfo("Jiyoon"	, 50, 990), db.passengers.get("e2"));
		assertEquals(new PassengerInfo("Jaebin"	, 70, 2000), db.passengers.get("e3"));
		assertEquals(new PassengerInfo("Suyeon"	, 70, 2577), db.passengers.get("e4"));
		assertEquals(new PassengerInfo("Yuna"	, 50, 990), db.passengers.get("e5"));
		assertEquals(new PassengerInfo("Sunhye"	, 30, 2577), db.passengers.get("e6"));
		
	}
	
	@Test
	public void test_getPassengerName_abnormal() {
		addFlights();
		addPassengers();
		
		try {
			String name = db.getPassengerName("e8");
			fail();
		} catch (IdNotFoundException e) {
			// exception expected
		} 
	}
	
	@Test
	public void test_getPassengerName_normal() {
		addFlights();
		addPassengers();
		
		try {
			assertEquals("Heeyeon"	, db.getPassengerName("e1"));
			assertEquals("Jiyoon"	, db.getPassengerName("e2"));
			assertEquals("Jaebin"	, db.getPassengerName("e3"));
			assertEquals("Suyeon"	, db.getPassengerName("e4"));
			assertEquals("Yuna"		, db.getPassengerName("e5"));
			assertEquals("Sunhye"	, db.getPassengerName("e6"));
			assertEquals("Jihye"	, db.getPassengerName("e7"));
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		} 
	}
	
	@Test
	public void test_getPassengerNames() {
		addFlights();
		addPassengers();
		
		ArrayList<String> names;
		names = db.getPassengerNames(2577);
		assertEquals(3, names.size());
		assertTrue(names.contains("Jiyoon"));
		assertTrue(names.contains("Suyeon"));
		assertTrue(names.contains("Sunhye"));
		names = db.getPassengerNames(2000);
		assertEquals(2, names.size());
		assertTrue(names.contains("Jaebin"));
		assertTrue(names.contains("Heeyeon"));
		names = db.getPassengerNames(990);
		assertEquals(2, names.size());
		assertTrue(names.contains("Yuna"));
		assertTrue(names.contains("Jihye"));
		// non-existing course id
		names = db.getPassengerNames(4);
		assertEquals(0, names.size());
	}
	
	@Test
	public void test_getFlightInfo_abnormal() {
		addFlights();
		addPassengers();
		
		try {
			FlightInfo name = db.getFlightInfo("e8");
			fail();
		} catch (IdNotFoundException e) {
			// exception expected
		} 
	}
	
	@Test
	public void test_getFlightInfo_normal() {
		addFlights();
		addPassengers();
		
		try {
			assertEquals(new FlightInfo("LondonToronto", "AirCanada"), db.getFlightInfo("e1"));
			assertEquals(new FlightInfo("ParisLondon"		, "AirFrance")	, db.getFlightInfo("e2"));
			assertEquals(new FlightInfo("LondonToronto", "AirCanada")	, db.getFlightInfo("e3"));
			assertEquals(new FlightInfo("ParisLondon"		, "AirFrance")	, db.getFlightInfo("e4"));
			assertEquals(new FlightInfo("ParisToronto"	, "UnitedAirlines"), db.getFlightInfo("e5"));
			assertEquals(new FlightInfo("ParisLondon"		, "AirFrance")	, db.getFlightInfo("e6"));
			assertEquals(new FlightInfo("ParisToronto", "UnitedAirlines"), db.getFlightInfo("e7"));
			
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		} 
	}
	
	
	@Test
	public void test_getSortedPassengerInfo_normal() {
		addFlights();
		addPassengers();
		
		PassengerInfo[] sorted = db.getSortedPassengerInfo();
		PassengerInfo[] expected = {
				new PassengerInfo("Heeyeon"	, 10, 2000),
				new PassengerInfo("Sunhye"	, 30, 2577),
				new PassengerInfo("Jiyoon"	, 50, 2577),
				new PassengerInfo("Yuna"	, 50, 990),
				new PassengerInfo("Suyeon"	, 70, 2577),
				new PassengerInfo("Jaebin"	, 70, 2000),
				new PassengerInfo("Jihye"	 ,70, 990),				
		};
		assertEquals(7, sorted.length);
		assertArrayEquals(expected, sorted);
		
	}
	
	
	
	
	
	@Test
	public void test_getAveragePercentage_abnormal() {
		addFlights();
		addPassengers();
		
		try {
			double avgTicket = db.getAverageTicketAmount(4);
			fail();
		} catch (IdNotFoundException e) {
			// exception expected
		} 
	}
	
	
	@Test
	public void test_icketAmount_normal() {
		addFlights();
		addPassengers();
		
		try {
			// precision of getAverageTicketAmount is within a tolerance of +/- 0.1
			assertEquals((30 + 50 + 70) / 3.0, db.getAverageTicketAmount(2577), 0.1);
			assertEquals((10 + 70) / 2.0, db.getAverageTicketAmount(2000), 0.1);
			assertEquals((70 + 50) / 2.0, db.getAverageTicketAmount(990), 0.1);
			
		} catch (IdNotFoundException e) {
			// exception not expected
			fail();
		} 
	}
	

	

}
